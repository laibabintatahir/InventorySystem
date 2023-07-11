package com.dsa.dsaproject.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    // Connect to database using JDBC
    public static Connection getConnection() {
        Connection conn = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection URL
            String url = "jdbc:mysql://localhost:3306/imsdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            // Create a connection to the database
            conn = DriverManager.getConnection(url, "imsdba", "ims123");
            System.out.println("Connection to imspdb has been established.");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
            System.out.println("Connection to imspdb has been closed.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
