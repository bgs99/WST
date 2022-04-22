package bgs.server;

import bgs.shared.*;
import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(serviceName = "SubscriptionService")
public class SubscriptionWebService {

    private final static Logger LOGGER = Logger.getLogger(SubscriptionWebService.class.getName());
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
    public int createSubscription(String name, double rate, double throughput, boolean hasTv) {
        return this.dao.createSubscription(name, rate, throughput, hasTv);
    }

    @WebMethod
    public boolean editSubscription(int id, String name, double rate, double throughput, boolean hasTv) {
        return this.dao.editSubscription(id, name, rate, throughput, hasTv);
    }

    @WebMethod
    public boolean removeSubscription(int id) {
        return this.dao.removeSubscription(id);
    }

    @WebMethod
    public int countBytes(@XmlMimeType("application/octet-stream") DataHandler data) {
        try {
            return data.getInputStream().readAllBytes().length;
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Failed to count bytes: {0}", e);
            return -1;
        }
    }
}
