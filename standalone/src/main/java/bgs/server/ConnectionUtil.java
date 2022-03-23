package bgs.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {
    private static final String JDBC_URL =
            "jdbc:postgresql://localhost/db_labs";
    /*static {
        try {
            Class.forName("org.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLDAO.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }*/
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return connection;
    }
}