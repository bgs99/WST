package bgs.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;

public class Server {

    private final static Logger LOGGER = Logger.getLogger(Server.class.getName());
    private final static URI BASE_URI = URI.create("http://0.0.0.0:8080/rest/");

    private static void stopServer(HttpServer server) {
        if (server != null) {
            server.shutdownNow();
        }
    }

    public static void main(String[] args) {
        HttpServer server = null;
        try {
            ResourceConfig resourceConfig = new ResourceConfig().registerClasses(SubscriptionResource.class);
            server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig);
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to start http server at {0}: {1}", new Object[]{BASE_URI, e});
            stopServer(server);
        }
    }
}
