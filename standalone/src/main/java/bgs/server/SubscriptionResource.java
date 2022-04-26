package bgs.server;

import bgs.shared.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/subscriptions")
@Produces({MediaType.APPLICATION_JSON})
public class SubscriptionResource {

    private final static Connection connection = ConnectionUtil.getConnection();
    private final SQLDAO dao;

    public SubscriptionResource() throws SQLException {
        this.dao = new SQLDAO(connection);
    }

    @GET
    public List<Subscription> getAllSubscriptions() {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .getResults();
        return persons;
    }

    @Path("/by_name/{name}")
    @GET
    public List<Subscription> getSubscriptionsByName(@PathParam("name") String name) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder().byName(name).getResults();
        return persons;
    }

    @Path("/by_id/{id}")
    @GET
    public List<Subscription> getSubscriptionsById(@PathParam("id") int id) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder().byId(id).getResults();
        return persons;
    }

    @Path("/by_throughput/le/{throughput}")
    @GET
    public List<Subscription> getSubscriptionsByThroughputLe(@PathParam("throughput") double throughput) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder().byThroughputLe(throughput).getResults();
        return persons;
    }

    @Path("/by_throughput/ge/{throughput}")
    @GET
    public List<Subscription> getSubscriptionsByThroughputGe(@PathParam("throughput") double throughput) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder().byThroughputGe(throughput).getResults();
        return persons;
    }

    @Path("/by_rate/le/{rate}")
    @GET
    public List<Subscription> getSubscriptionsByRateLe(@PathParam("rate") double rate) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder().byRateLe(rate).getResults();
        return persons;
    }

    @Path("/by_rate/ge/{rate}")
    @GET
    public List<Subscription> getSubscriptionsByRateGe(@PathParam("rate") double rate) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder().byRateGe(rate).getResults();
        return persons;
    }

    @Path("/by_tv/{has_tv}")
    @GET
    public List<Subscription> getSubscriptionsByTv(@PathParam("has_tv") boolean hasTv) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder().byTv(hasTv).getResults();
        return persons;
    }

    @Path("/better_than")
    @GET
    public List<Subscription> getSubscriptionsBetterThan(@QueryParam("rate") double rate, @QueryParam("throughput") double throughput) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder().byRateLe(rate).byThroughputGe(throughput).getResults();
        return persons;
    }

    @Path("/worse_than")
    @GET
    public List<Subscription> getSubscriptionsWorseThan(@QueryParam("rate") double rate, @QueryParam("throughput") double throughput) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder().byRateGe(rate).byThroughputLe(throughput).getResults();
        return persons;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public int createSubscription(Subscription subscription) {
        return this.dao.createSubscription(subscription.getName(), subscription.getRate(), subscription.getThroughput(), subscription.getHasTv());
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public boolean editSubscription(Subscription subscription, @PathParam("id") int id) {
        return this.dao.editSubscription(id, subscription.getName(), subscription.getRate(), subscription.getThroughput(), subscription.getHasTv());
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public boolean removeSubscription(@PathParam("id") int id) {
        return this.dao.removeSubscription(id);
    }
}
