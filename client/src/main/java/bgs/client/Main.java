package bgs.client;

import bgs.shared.Subscription;

import java.util.List;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;

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

    synchronized List<Subscription> run(String[] args) throws IllegalArgumentException {
        if (args.length == 0) {
            return getList(this.builder.build());
        } else {
            if (args.length < 2) {
                throw new IllegalArgumentException("Expected value after filter");
            }
            switch (args[0]) {
                case "id" -> {
                    final var id = Integer.parseInt(args[1]); // force client-side validation
                    final var uri = this.builder.segment("by_id").segment("{arg1}").build(id);
                    return getList(uri);
                }
                case "name" -> {
                    final var uri = this.builder.segment("by_name").segment("{arg1}").build(args[1]);
                    return getList(uri);
                }
                case "througputle" -> {
                    final var throughput = Double.parseDouble(args[1]);
                    final var uri = this.builder.segment("by_throughput").segment("le").segment("{arg1}").build(throughput);
                    return getList(uri);
                }
                case "througputge" -> {
                    final var throughput = Double.parseDouble(args[1]);
                    final var uri = this.builder.segment("by_throughput").segment("ge").segment("{arg1}").build(throughput);
                    return getList(uri);
                }
                case "ratele" -> {
                    final var rate = Double.parseDouble(args[1]);
                    final var uri = this.builder.segment("by_rate").segment("le").segment("{arg1}").build(rate);
                    return getList(uri);
                }
                case "ratege" -> {
                    final var rate = Double.parseDouble(args[1]);
                    final var uri = this.builder.segment("by_rate").segment("ge").segment("{arg1}").build(rate);
                    return getList(uri);
                }
                case "worse" -> {
                    if (args.length != 3) {
                        throw new IllegalArgumentException("Expected 2 values for this filter");
                    }
                    final var rate = Double.parseDouble(args[1]);
                    final var throughput = Double.parseDouble(args[2]);
                    final var uri = this.builder.segment("worse_than").queryParam("rate", rate).queryParam("throughput", throughput).build();
                    return getList(uri);
                }
                case "better" -> {
                    if (args.length != 3) {
                        throw new IllegalArgumentException("Expected 2 values for this filter");
                    }
                    final var rate = Double.parseDouble(args[1]);
                    final var throughput = Double.parseDouble(args[2]);
                    final var uri = this.builder.segment("better_than").queryParam("rate", rate).queryParam("throughput", throughput).build();
                    return getList(uri);
                }
                case "tv" -> {
                    boolean hasTv;
                    switch (args[1].toLowerCase()) {
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

        final var subscriptions = client.run(args);

        for (final Subscription subscription : subscriptions) {
            System.out.println("Subscription{id = " + subscription.getId()
                    + ", name = " + subscription.getName()
                    + ", rate = " + subscription.getRate() + " roubles"
                    + ", throughput = " + subscription.getThroughput() + " Mbps"
                    + ", has tv = " + (subscription.isHasTv()? "Yes" : "No")
                    + "}");
        }
        System.out.println("Total subscriptions: " + subscriptions.size());
    }
}
