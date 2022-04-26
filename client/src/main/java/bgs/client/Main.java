package bgs.client;

import bgs.shared.Subscription;

import java.util.Arrays;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

public class Main {

    private final static String URL = "http://localhost:8080/rest/subscriptions";
    private final static GenericType<List<Subscription>> LIST_TYPE = new GenericType<List<Subscription>>() {
    };

    private final Client client;
    private final UriBuilder builder;

    Main(URI uri) {
        this.client = ClientBuilder.newClient();
        this.builder = UriBuilder.fromUri(uri);
    }

    List<Subscription> getList(URI uri) {
        final var response = this.client.target(uri)
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        return response.readEntity(LIST_TYPE);
    }

    synchronized int createSubscription(List<String> args) throws IllegalArgumentException {
        if (args.size() < 4) {
            throw new IllegalArgumentException("Expected 4 values for name, rate, throughput, and tv");
        }

        final var name = args.get(0);
        final var rate = Double.parseDouble(args.get(1));
        final var throughput = Double.parseDouble(args.get(2));
        final var hasTv = Boolean.parseBoolean(args.get(3));

        final var subscription = new Subscription(0, name, rate, throughput, hasTv);

        final var uri = this.builder.build();

        final var response = this.client.target(uri)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN)
                .post(Entity.json(subscription));
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed: " + response.getStatusInfo());
        }
        return response.readEntity(Integer.class);
    }

    synchronized boolean editSubscription(List<String> args) throws IllegalArgumentException {
        if (args.size() < 5) {
            throw new IllegalArgumentException("Expected 5 values for id, name, rate, throughput, and tv");
        }

        final var id = Integer.parseInt(args.get(0));
        final var name = args.get(1);
        final var rate = Double.parseDouble(args.get(2));
        final var throughput = Double.parseDouble(args.get(3));
        final var hasTv = Boolean.parseBoolean(args.get(4));

        final var subscription = new Subscription(id, name, rate, throughput, hasTv);

        final var uri = this.builder.segment("{arg1}").build(id);

        final var response = this.client.target(uri)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN)
                .put(Entity.json(subscription));
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        return response.readEntity(Boolean.class);
    }

    synchronized boolean removeSubscription(List<String> args) throws IllegalArgumentException {
        if (args.size() < 1) {
            throw new IllegalArgumentException("Expected id");
        }
        final var id = Integer.parseInt(args.get(0));

        final var uri = this.builder.segment("{arg1}").build(id);

        final var response = this.client.target(uri)
                .request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN)
                .delete();
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        return response.readEntity(Boolean.class);
    }

    synchronized List<Subscription> getSubscriptions(List<String> args) throws IllegalArgumentException {
        if (args.isEmpty()) {
            return getList(this.builder.build());
        } else {
            if (args.size() < 2) {
                throw new IllegalArgumentException("Expected value after filter");
            }
            switch (args.get(0)) {
                case "id" -> {
                    final var id = Integer.parseInt(args.get(1)); // force client-side validation
                    final var uri = this.builder.segment("by_id").segment("{arg1}").build(id);
                    return getList(uri);
                }
                case "name" -> {
                    final var uri = this.builder.segment("by_name").segment("{arg1}").build(args.get(1));
                    return getList(uri);
                }
                case "througputle" -> {
                    final var throughput = Double.parseDouble(args.get(1));
                    final var uri = this.builder.segment("by_throughput").segment("le").segment("{arg1}").build(throughput);
                    return getList(uri);
                }
                case "througputge" -> {
                    final var throughput = Double.parseDouble(args.get(1));
                    final var uri = this.builder.segment("by_throughput").segment("ge").segment("{arg1}").build(throughput);
                    return getList(uri);
                }
                case "ratele" -> {
                    final var rate = Double.parseDouble(args.get(1));
                    final var uri = this.builder.segment("by_rate").segment("le").segment("{arg1}").build(rate);
                    return getList(uri);
                }
                case "ratege" -> {
                    final var rate = Double.parseDouble(args.get(1));
                    final var uri = this.builder.segment("by_rate").segment("ge").segment("{arg1}").build(rate);
                    return getList(uri);
                }
                case "worse" -> {
                    if (args.size() != 3) {
                        throw new IllegalArgumentException("Expected 2 values for this filter");
                    }
                    final var rate = Double.parseDouble(args.get(1));
                    final var throughput = Double.parseDouble(args.get(2));
                    final var uri = this.builder.segment("worse_than").queryParam("rate", rate).queryParam("throughput", throughput).build();
                    return getList(uri);
                }
                case "better" -> {
                    if (args.size() != 3) {
                        throw new IllegalArgumentException("Expected 2 values for this filter");
                    }
                    final var rate = Double.parseDouble(args.get(1));
                    final var throughput = Double.parseDouble(args.get(2));
                    final var uri = this.builder.segment("better_than").queryParam("rate", rate).queryParam("throughput", throughput).build();
                    return getList(uri);
                }
                case "tv" -> {
                    boolean hasTv;
                    switch (args.get(1).toLowerCase()) {
                        case "yes" -> {
                            hasTv = true;
                            break;
                        }
                        case "no" -> {
                            hasTv = false;
                            break;
                        }
                        default -> {
                            throw new IllegalArgumentException("Expected yes or no");
                        }
                    }
                    final var uri = this.builder.segment("by_tv").segment("{arg1}").build(hasTv);
                    return getList(uri);
                }
                default -> {
                    throw new IllegalArgumentException("Unexpected filter");
                }
            }
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        final var client = new Main(new URI(URL));

        if (args.length == 0) {
            throw new IllegalArgumentException("Expected command: create, edit, get, remove");
        }

        var argList = Arrays.asList(args).subList(1, args.length);

        switch (args[0]) {
            case "get" -> {
                final var subscriptions = client.getSubscriptions(argList);

                for (final Subscription subscription : subscriptions) {
                    System.out.println("Subscription{id = " + subscription.getId()
                            + ", name = " + subscription.getName()
                            + ", rate = " + subscription.getRate() + " roubles"
                            + ", throughput = " + subscription.getThroughput() + " Mbps"
                            + ", has tv = " + (subscription.getHasTv() ? "Yes" : "No")
                            + "}");
                }
                System.out.println("Total subscriptions: " + subscriptions.size());
                break;
            }
            case "create" -> {
                final var id = client.createSubscription(argList);

                System.out.println("Created subscription with id " + id);
                break;
            }
            case "edit" -> {
                final var success = client.editSubscription(argList);
                if (success) {
                    System.out.println("Successfully edited subscription");
                } else {
                    System.out.println("Failed to edit subscription");
                }
                break;
            }
            case "remove" -> {
                final var success = client.removeSubscription(argList);
                if (success) {
                    System.out.println("Successfully removed subscription");
                } else {
                    System.out.println("Failed to remove subscription");
                }
                break;
            }
            default -> {
                throw new IllegalArgumentException("Expected command: create, edit, get, remove");
            }
        }
    }
}
