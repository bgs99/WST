package bgs.server;

import javax.xml.ws.Endpoint;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/wst/SubscriptionService";
        Logger.getLogger(Server.class.getName()).log(Level.INFO,
                "Server starting at " + url);
        Endpoint.publish(url, new SubscriptionWebService());
    }
}
