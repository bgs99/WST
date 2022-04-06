package bgs.shared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLDAO {

    private final static Logger LOGGER = Logger.getLogger(SQLDAO.class.getName());
    private final Connection connection;

    public class SubscriptionFilterBuilder {

        private final StringBuilder query = new StringBuilder("select * from subscriptions");
        private boolean hasFilter = false;
        private final Statement stmt;

        private SubscriptionFilterBuilder() throws SQLException {
            this.stmt = connection.createStatement();
        }

        private void addFilter(String filter) {
            if (hasFilter) {
                query.append(" and ").append(filter);
            } else {
                hasFilter = true;
                query.append(" where ").append(filter);
            }
        }

        public SubscriptionFilterBuilder byName(String name) {
            try {
                addFilter("subscriptions.name = " + stmt.enquoteLiteral(name));
            } catch (SQLException e) {

            }
            return this;
        }

        public SubscriptionFilterBuilder byId(int id) {
            addFilter("subscriptions.id = " + id);
            return this;
        }

        public SubscriptionFilterBuilder byRateGe(double rate) {
            addFilter("subscriptions.rate >= " + rate);
            return this;
        }

        public SubscriptionFilterBuilder byRateLe(double rate) {
            addFilter("subscriptions.rate <= " + rate);
            return this;
        }

        public SubscriptionFilterBuilder byThroughputGe(double throughput) {
            addFilter("subscriptions.throughput >= " + throughput);
            return this;
        }

        public SubscriptionFilterBuilder byThroughputLe(double throughput) {
            addFilter("subscriptions.throughput <= " + throughput);
            return this;
        }

        public SubscriptionFilterBuilder byTv(boolean has_tv) {
            addFilter("subscriptions.tv = " + (has_tv ? "true" : "false"));
            return this;
        }

        public List<Subscription> getResults() {
            List<Subscription> subscriptions = new ArrayList<>();
            ResultSet rs;
            try {
                rs = stmt.executeQuery(query.toString());

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
                LOGGER.log(Level.SEVERE, null, ex);
            }
            return subscriptions;
        }
    }

    private final PreparedStatement createStatement;
    private final PreparedStatement editStatement;
    private final PreparedStatement removeStatement;

    public SQLDAO(Connection connection) throws SQLException {
        this.connection = connection;
        this.createStatement = this.connection.prepareStatement(
                "INSERT INTO subscriptions (name, rate, throughput, tv) VALUES (?, ?, ?, ?) RETURNING id");
        this.editStatement = this.connection.prepareStatement(
                "UPDATE subscriptions SET name = ?, rate = ?, throughput = ?, tv = ? WHERE id = ?");
        this.removeStatement = this.connection.prepareStatement(
                "DELETE FROM subscriptions WHERE id = ?");
    }

    public SubscriptionFilterBuilder getSubscriptionsFilterBuilder() {
        try {
            return new SubscriptionFilterBuilder();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int createSubscription(
            String name,
            double rate,
            double throughput,
            boolean hasTv) {
        try {
            createStatement.setString(1, name);
            createStatement.setDouble(2, rate);
            createStatement.setDouble(3, throughput);
            createStatement.setBoolean(4, hasTv);
            var results = createStatement.executeQuery();
            while (results.next()) {
                return results.getInt(1);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean editSubscription(int id, String name, double rate, double throughput, boolean hasTv) {
        try {
            editStatement.setString(1, name);
            editStatement.setDouble(2, rate);
            editStatement.setDouble(3, throughput);
            editStatement.setBoolean(4, hasTv);
            editStatement.setInt(5, id);

            return editStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean removeSubscription(int id) {
        try {
            removeStatement.setInt(1, id);

            return removeStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
