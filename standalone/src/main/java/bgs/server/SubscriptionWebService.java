package bgs.server;

import java.sql.Connection;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "SubscriptionService")
public class SubscriptionWebService {
    static Connection connection = ConnectionUtil.getConnection();

    @WebMethod
    public List<Subscription> getAllSubscriptions() {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByName(String name) {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byName(name).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsById(int id) {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byId(id).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByThroughputLe(double throughput) {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byThroughputLe(throughput).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByThroughputGe(double throughput) {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byThroughputGe(throughput).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByRateLe(double rate) {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateLe(rate).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByRateGe(double rate) {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateGe(rate).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsByTv(boolean hasTv) {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byTv(hasTv).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsBetterThan(double rate, double throughput) {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateLe(rate).byThroughputGe(throughput).getResults();
        return persons;
    }

    @WebMethod
    public List<Subscription> getSubscriptionsWorseThan(double rate, double throughput) {
        SQLDAO dao = new SQLDAO(connection);
        List<Subscription> persons = dao.getSubscriptionsFilterBuilder().byRateGe(rate).byThroughputLe(throughput).getResults();
        return persons;
    }
}