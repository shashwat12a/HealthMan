package com.health.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * DBUtil is a utility class responsible for managing database connections.
 * It provides a static method to get a connection to the database.
 * 
 */


public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/health";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    /**
     * Establishes and returns a connection to the database.
     * @return Connection object if connection is successful, otherwise null.
     * @throws SQLException If unable to connect to the database.
     */

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database Driver not found", e);
        }
    }

    
    /*
    * closes the sql connection object
    */
    public static void closeResources(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

