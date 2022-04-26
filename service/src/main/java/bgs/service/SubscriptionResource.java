package bgs.service;

import bgs.shared.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import lombok.extern.java.Log;

@RequestScoped
@Path("/subscriptions")
@Produces({MediaType.APPLICATION_JSON})
@Log
public class SubscriptionResource {

    private final SQLDAO dao;
    
    public SubscriptionResource() throws SQLException {
        this.dao = new SQLDAO(getConnection());
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

    private Connection getConnection() {
        DataSource dataSource;
        try {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/bgs-ws");
        } catch (NamingException ex) {
            log.log(Level.SEVERE, null, ex);
            return null;
        }
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return result;
    }
}