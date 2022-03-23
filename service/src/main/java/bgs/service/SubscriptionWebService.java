package bgs.service;

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
    @WebMethod
    public List<Subscription> getAllSubscriptions() {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByName(String name) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byName(name).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsById(int id) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byId(id).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByThroughputLe(double throughput) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byThroughputLe(throughput).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByThroughputGe(double throughput) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byThroughputGe(throughput).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByRateLe(double rate) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateLe(rate).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByRateGe(double rate) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateGe(rate).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByTv(boolean hasTv) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byTv(hasTv).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsBetterThan(double rate, double throughput) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateLe(rate).byThroughputGe(throughput)
                .getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsWorseThan(double rate, double throughput) {
        SQLDAO dao = new SQLDAO(getConnection());
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateGe(rate).byThroughputLe(throughput)
                .getResults();
        return persons;
    }

    private Connection getConnection() {
        DataSource dataSource;
        try {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/bgs-ws");
        } catch (NamingException ex) {
            Logger.getLogger(SubscriptionWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SubscriptionWebService.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return result;
    }
}