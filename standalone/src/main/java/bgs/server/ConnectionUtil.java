package bgs.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {    
    private final static Logger LOGGER = Logger.getLogger(ConnectionUtil.class.getName());

    private static final String JDBC_URL =
            "jdbc:postgresql://localhost/db_labs";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}