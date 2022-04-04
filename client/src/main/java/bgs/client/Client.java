package bgs.client;

import bgs.client.generated.Subscription;
import bgs.client.generated.SubscriptionService;
import bgs.client.generated.SubscriptionWebService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Client {
    private final SubscriptionWebService port;

    Client(URL url) {
        this.port = new SubscriptionService(url).getSubscriptionWebServicePort();
    }

    synchronized List<Subscription> run(String[] args) throws IllegalArgumentException {
        if (args.length == 0) {
            return this.port.getAllSubscriptions();
        } else {
            if (args.length < 2) {
                throw new IllegalArgumentException("Expected value after filter");
            }
            switch (args[0]) {
                case "id" -> {
                    return this.port.getSubscriptionsById(Integer.parseInt(args[1]));
                }
                case "name" -> {
                    return this.port.getSubscriptionsByName(args[1]);
                }
                case "througputle" -> {
                    return this.port.getSubscriptionsByThroughputLe(Double.parseDouble(args[1]));
                }
                case "througputge" -> {
                    return this.port.getSubscriptionsByThroughputGe(Double.parseDouble(args[1]));
                }
                case "ratele" -> {
                    return this.port.getSubscriptionsByRateLe(Double.parseDouble(args[1]));
                }
                case "ratege" -> {
                    return this.port.getSubscriptionsByRateGe(Double.parseDouble(args[1]));
                }
                case "worse" -> {
                    if (args.length != 3) {
                        throw new IllegalArgumentException("Expected 2 values for this filter");
                    }
                    return this.port.getSubscriptionsWorseThan(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                }
                case "better" -> {
                    if (args.length != 3) {
                        throw new IllegalArgumentException("Expected 2 values for this filter");
                    }
                    return this.port.getSubscriptionsBetterThan(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
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

        final var subscriptions = client.run(args);

        for (final Subscription subscription : subscriptions) {
            System.out.println("Subscription{id = " + subscription.getId()
                    + ", name = " + subscription.getName()
                    + ", rate = " + subscription.getRate() + " roubles"
                    + ", throughput = " + subscription.getThroughput() + " Mbps"
                    + ", has tv = " + (subscription.isHasTv() ? "Yes" : "No")
                    + "}");
        }
        System.out.println("Total subscriptions: " + subscriptions.size());
    }
}
