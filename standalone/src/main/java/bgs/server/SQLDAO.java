package bgs.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLDAO {
    private final Logger LOGGER = Logger.getLogger(SQLDAO.class.getName());
    private Connection connection;

    public class SubscriptionFilterBuilder {
        private String query = "select * from subscriptions";
        private boolean hasFilter = false;
        private Statement stmt;

        private SubscriptionFilterBuilder() throws SQLException {
            this.stmt = connection.createStatement();
        }

        private void addFilter(String filter) {
            if (hasFilter) {
                query += " and " + filter;
            } else {
                hasFilter = true;
                query += " where " + filter;
            }
        }

        SubscriptionFilterBuilder byName(String name) {
            try {
                addFilter("subscriptions.name = " + stmt.enquoteLiteral(name));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return this;
        }

        SubscriptionFilterBuilder byId(int id) {
            addFilter("subscriptions.id = " + id);
            return this;
        }

        SubscriptionFilterBuilder byRateGe(double rate) {
            addFilter("subscriptions.rate >= " + rate);
            return this;
        }

        SubscriptionFilterBuilder byRateLe(double rate) {
            addFilter("subscriptions.rate <= " + rate);
            return this;
        }

        SubscriptionFilterBuilder byThroughputGe(double throughput) {
            addFilter("subscriptions.throughput >= " + throughput);
            return this;
        }

        SubscriptionFilterBuilder byThroughputLe(double throughput) {
            addFilter("subscriptions.throughput <= " + throughput);
            return this;
        }

        SubscriptionFilterBuilder byTv(boolean has_tv) {
            addFilter("subscriptions.tv = " + (has_tv ? "true" : "false"));
            return this;
        }

        public List<Subscription> getResults() {
            LOGGER.log(Level.INFO, "Request to DB: {0}", query);
            List<Subscription> subscriptions = new ArrayList<>();
            ResultSet rs;
            try {
                rs = stmt.executeQuery(query);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double rate = rs.getDouble("rate");
                    double throughput = rs.getDouble("throughput");
                    boolean has_tv = rs.getBoolean("tv");
                    Subscription person = new Subscription(id, name, rate, throughput, has_tv);
                    subscriptions.add(person);
                }
            } catch (SQLException ex) {
                LOGGER.severe(ex.toString());
            }
            return subscriptions;
        }
    }

    public SQLDAO(Connection connection) {
        this.connection = connection;
    }

    public SubscriptionFilterBuilder getSubscriptionsFilterBuilder() {
        try {
            return new SubscriptionFilterBuilder();
        } catch (SQLException ex) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
            return null;
        }
    }
}
