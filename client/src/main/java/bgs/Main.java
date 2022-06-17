package bgs;

import bgs.client.Client;
import java.net.MalformedURLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Expected command: publish, search");
        }
        
        switch (args[0]) {
            case "publish" -> {
                if (args.length < 4) {
                    throw new IllegalArgumentException("Expected business name, service name and WSDL");
                }
                final var business = args[1];
                final var service = args[2];
                final var wsdl = args[3];
                System.out.println("Publishing business " + business + " with service " + service + " with WSDL " + wsdl);
                
                final var sp = new SimplePublish();
                sp.publish(business, service, wsdl);
            }
            case "search" -> {
                if (args.length < 2) {
                    throw new IllegalArgumentException("Expected service name");
                }

                final var serviceName = args[1];
                
                final var sb = new SimpleBrowse();
                var serviceURL = sb.SearchForService(serviceName);
                
                if (serviceURL == null) {
                    System.out.println("Service not found");
                    return;
                }
                
                var argList = Arrays.copyOfRange(args, 2, args.length);
                Client.main(serviceURL, argList);
            }
            default -> throw new IllegalArgumentException("Expected command: publish, search");
        }
    }
}
