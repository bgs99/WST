package bgs.client;

import bgs.client.generated.Subscription;
import bgs.client.generated.SubscriptionService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://bgs99claptop:8080/wst/SubscriptionService?wsdl");
        SubscriptionService subscriptionService = new SubscriptionService(url);
        
        var port = subscriptionService.getSubscriptionWebServicePort();
        
        List<Subscription> subscriptions;
        if (args.length == 0) {
            subscriptions = port.getAllSubscriptions();
        } else {
            if (args.length < 2) {
                System.out.println("Expected value after filter");
                return;
            } 
            switch (args[0]) {
                case "id" -> {
                    subscriptions = port.getSubscriptionsById(Integer.parseInt(args[1]));
                    System.out.println("by id " + Integer.parseInt(args[1]));
                    break;
                }
                case  "name" -> {
                    subscriptions = port.getSubscriptionsByName(args[1]);
                    break;
                }
                case  "througputle" -> {
                    subscriptions = port.getSubscriptionsByThroughputLe(Double.parseDouble(args[1]));
                    break;
                }
                case  "througputge" -> {
                    subscriptions = port.getSubscriptionsByThroughputGe(Double.parseDouble(args[1]));
                    break;
                }
                case  "ratele" -> {
                    subscriptions = port.getSubscriptionsByRateLe(Double.parseDouble(args[1]));
                    break;
                }
                case  "ratege" -> {
                    subscriptions = port.getSubscriptionsByRateGe(Double.parseDouble(args[1]));
                    break;
                }
                case "worse" -> {
                    if (args.length != 3) {
                        System.out.println("Expected 2 values for this filter");
                        return;
                    }
                    subscriptions = port.getSubscriptionsWorseThan(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                    break;
                }
                case "better" -> {
                    if (args.length != 3) {
                        System.out.println("Expected 2 values for this filter");
                        return;
                    }
                    subscriptions = port.getSubscriptionsBetterThan(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                    break;
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
                            System.out.println("Expected yes or no");
                            return;
                        }
                    }
                    subscriptions = port.getSubscriptionsByTv(hasTv);
                }
                default -> {
                    System.out.println("Unexpected filter");
                    return;
                }
            }
        }
        for (Subscription subscription : subscriptions) {
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
