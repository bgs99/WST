package bgs.server;

import org.glassfish.jersey.server.ResourceConfig;

public class Config extends ResourceConfig {
    public Config() {
        packages(SubscriptionResource.class.getPackageName());

        register(AuthFilter.class);
    }
}
