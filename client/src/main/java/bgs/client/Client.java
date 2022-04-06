package bgs.client;

import bgs.client.generated.Subscription;
import bgs.client.generated.SubscriptionService;
import bgs.client.generated.SubscriptionWebService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Client {

    private final SubscriptionWebService port;

    Client(URL url) {
        this.port = new SubscriptionService(url).getSubscriptionWebServicePort();
    }

    synchronized int createSubscription(List<String> args) throws IllegalArgumentException {
        if (args.size() < 4) {
            throw new IllegalArgumentException("Expected 4 values for name, rate, throughput, and tv");
        }
        return this.port.createSubscription(
                args.get(0),
                Double.parseDouble(args.get(1)),
                Double.parseDouble(args.get(2)),
                Boolean.parseBoolean(args.get(3)));
    }

    synchronized boolean editSubscription(List<String> args) throws IllegalArgumentException {
        if (args.size() < 5) {
            throw new IllegalArgumentException("Expected 5 values for id, name, rate, throughput, and tv");
        }
        return this.port.editSubscription(
                Integer.parseInt(args.get(0)),
                args.get(1),
                Double.parseDouble(args.get(2)),
                Double.parseDouble(args.get(3)),
                Boolean.parseBoolean(args.get(4)));
    }

    synchronized boolean removeSubscription(List<String> args) throws IllegalArgumentException {
        if (args.size() < 1) {
            throw new IllegalArgumentException("Expected id");
        }
        return this.port.removeSubscription(
                Integer.parseInt(args.get(0)));
    }

    synchronized List<Subscription> getSubscriptions(List<String> args) throws IllegalArgumentException {
        if (args.isEmpty()) {
            return this.port.getAllSubscriptions();
        } else {
            if (args.size() < 2) {
                throw new IllegalArgumentException("Expected value after filter");
            }
            switch (args.get(0)) {
                case "id" -> {
                    return this.port.getSubscriptionsById(Integer.parseInt(args.get(1)));
                }
                case "name" -> {
                    return this.port.getSubscriptionsByName(args.get(1));
                }
                case "througputle" -> {
                    return this.port.getSubscriptionsByThroughputLe(Double.parseDouble(args.get(1)));
                }
                case "througputge" -> {
                    return this.port.getSubscriptionsByThroughputGe(Double.parseDouble(args.get(1)));
                }
                case "ratele" -> {
                    return this.port.getSubscriptionsByRateLe(Double.parseDouble(args.get(1)));
                }
                case "ratege" -> {
                    return this.port.getSubscriptionsByRateGe(Double.parseDouble(args.get(1)));
                }
                case "worse" -> {
                    if (args.size() != 3) {
                        throw new IllegalArgumentException("Expected 2 values for this filter");
                    }
                    return this.port.getSubscriptionsWorseThan(Double.parseDouble(args.get(1)), Double.parseDouble(args.get(2)));
                }
                case "better" -> {
                    if (args.size() != 3) {
                        throw new IllegalArgumentException("Expected 2 values for this filter");
                    }
                    return this.port.getSubscriptionsBetterThan(Double.parseDouble(args.get(1)), Double.parseDouble(args.get(2)));
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
                    return this.port.getSubscriptionsByTv(hasTv);
                }
                default -> {
                    throw new IllegalArgumentException("Unexpected filter");
                }
            }
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        final var url = new URL("http://bgs99claptop:8080/wst/SubscriptionService?wsdl");
        final var client = new Client(url);

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
                            + ", has tv = " + (subscription.isHasTv() ? "Yes" : "No")
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
        }
    }
}
