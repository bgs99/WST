package bgs.server;

import bgs.shared.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "SubscriptionService")
public class SubscriptionWebService {
    private final static Connection connection = ConnectionUtil.getConnection();
    private final SQLDAO dao;
    
    public SubscriptionWebService() throws SQLException {
        this.dao = new SQLDAO(connection);
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
    
    @WebMethod
    public int createSubscription(String name, double rate, double throughput, boolean hasTv) throws NegativeParameterException{
        if (rate < 0) {
            throw new NegativeParameterException(
                    String.format("Failed to create subscription with rate %f: rate should be non-negative", rate),
                    SubscriptionServiceFault.defaultInstance());
        }
        if (throughput < 0) {
            throw new NegativeParameterException(
                    String.format("Failed to create subscription with throughput %f: throughput should be non-negative", throughput),
                    SubscriptionServiceFault.defaultInstance());
        }
        return this.dao.createSubscription(name, rate, throughput, hasTv);
    }
    
    @WebMethod
    public void editSubscription(int id, String name, double rate, double throughput, boolean hasTv) throws NegativeParameterException, SubscriptionNotFoundException {
        if (rate < 0) {
            throw new NegativeParameterException(
                    String.format("Failed to edit subscription %d with new rate %f: rate should be non-negative", id, rate),
                    SubscriptionServiceFault.defaultInstance());
        }
        if (throughput < 0) {
            throw new NegativeParameterException(
                    String.format("Failed to edit subscription %d with new throughput %f: throughput should be non-negative", id, throughput),
                    SubscriptionServiceFault.defaultInstance());
        }
        if (!this.dao.editSubscription(id, name, rate, throughput, hasTv)) {
            throw new SubscriptionNotFoundException(
                    String.format("Failed to edit subscription with id %d", id),
                    SubscriptionServiceFault.defaultInstance());
        }
    }

    @WebMethod
    public void removeSubscription(int id) throws SubscriptionNotFoundException {
        if (!this.dao.removeSubscription(id)) {
            throw new SubscriptionNotFoundException(
                    String.format("Failed to remove subscription with id %d", id),
                    SubscriptionServiceFault.defaultInstance());
        }
    }
}
