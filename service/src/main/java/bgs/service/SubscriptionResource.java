package bgs.service;

import bgs.shared.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@RequestScoped
@Path("/subscriptions")
@Produces({MediaType.APPLICATION_JSON})
public class SubscriptionResource {
    private final static Logger LOGGER = Logger.getLogger(SubscriptionResource.class.getName());
    
    @GET
    public List<Subscription> getAllSubscriptions() {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().getResults();
        return persons;
    }

    @Path("/by_name/{name}")
    @GET
    public List<Subscription> getSubscriptionsByName(@PathParam("name") String name) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byName(name).getResults();
        return persons;
    }

    @Path("/by_id/{id}")
    @GET
    public List<Subscription> getSubscriptionsById(@PathParam("id") int id) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byId(id).getResults();
        return persons;
    }

    @Path("/by_throughput/le/{throughput}")
    @GET
    public List<Subscription> getSubscriptionsByThroughputLe(@PathParam("throughput") double throughput) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byThroughputLe(throughput).getResults();
        return persons;
    }

    @Path("/by_throughput/ge/{throughput}")
    @GET
    public List<Subscription> getSubscriptionsByThroughputGe(@PathParam("throughput") double throughput) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byThroughputGe(throughput).getResults();
        return persons;
    }

    @Path("/by_rate/le/{rate}")
    @GET
    public List<Subscription> getSubscriptionsByRateLe(@PathParam("rate") double rate) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateLe(rate).getResults();
        return persons;
    }

    @Path("/by_rate/ge/{rate}")
    @GET
    public List<Subscription> getSubscriptionsByRateGe(@PathParam("rate") double rate) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateGe(rate).getResults();
        return persons;
    }

    @Path("/by_tv/{has_tv}")
    @GET
    public List<Subscription> getSubscriptionsByTv(@PathParam("has_tv") boolean hasTv) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byTv(hasTv).getResults();
        return persons;
    }

    @Path("/better_than")
    @GET
    public List<Subscription> getSubscriptionsBetterThan(@QueryParam("rate") double rate, @QueryParam("throughput") double throughput) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateLe(rate).byThroughputGe(throughput).getResults();
        return persons;
    }

    @Path("/worse_than")
    @GET
    public List<Subscription> getSubscriptionsWorseThan(@QueryParam("rate") double rate, @QueryParam("throughput") double throughput) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateGe(rate).byThroughputLe(throughput).getResults();
        return persons;
    }

    private Connection getConnection() {
        DataSource dataSource;
        try {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/bgs-ws");
        } catch (NamingException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return null;
        }
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return result;
    }
}