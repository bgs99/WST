package bgs.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.java.Log;

@Log
public class ConnectionUtil {

    private static final String JDBC_URL =
            "jdbc:postgresql://localhost/db_labs";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (SQLException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}