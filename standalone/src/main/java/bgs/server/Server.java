package bgs.server;

import java.sql.SQLException;
import javax.xml.ws.Endpoint;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private final static Logger LOGGER = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) throws SQLException {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureStackTrace", "false");
        String url = "http://0.0.0.0:8088/wst/SubscriptionService";
        LOGGER.log(Level.INFO, "Server starting at {0}", url);
        Endpoint.publish(url, new SubscriptionWebService());
    }
}
