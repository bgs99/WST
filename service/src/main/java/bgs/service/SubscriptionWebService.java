package bgs.service;

import bgs.shared.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@WebService(serviceName = "SubscriptionService")
public class SubscriptionWebService {
    private final static Logger LOGGER = Logger.getLogger(SubscriptionWebService.class.getName());
    
    private final SQLDAO dao;
    
    public SubscriptionWebService() throws SQLException {
        this.dao = new SQLDAO(getConnection());
    }
    
    @WebMethod
    public List<Subscription> getAllSubscriptions() {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByName(String name) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .byName(name)
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsById(int id) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .byId(id)
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByThroughputLe(double throughput) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .byThroughputLe(throughput)
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByThroughputGe(double throughput) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .byThroughputGe(throughput)
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByRateLe(double rate) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .byRateLe(rate)
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByRateGe(double rate) {
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder()
                .byRateGe(rate)
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByTv(boolean hasTv) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .byTv(hasTv)
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsBetterThan(double rate, double throughput) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .byRateLe(rate)
                .byThroughputGe(throughput)
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsWorseThan(double rate, double throughput) {
        List<Subscription> persons = this.dao.getSubscriptionsFilterBuilder()
                .byRateGe(rate)
                .byThroughputLe(throughput)
                .getResults();
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