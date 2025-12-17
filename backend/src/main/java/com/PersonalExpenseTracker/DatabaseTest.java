package com.PersonalExpenseTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "Coder@1122";

    public static void main(String[] args) {
        try {
            System.out.println("Testing database connection...");
            
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver loaded successfully");

            // Attempt to connect to MySQL server
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to MySQL server successfully");
            
            // Close connection
            conn.close();
            System.out.println("Connection closed");
            
            System.out.println("Database connection test completed successfully!");
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            System.err.println("Make sure you have added the MySQL connector dependency to your pom.xml");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            System.err.println("Possible causes:");
            System.err.println("1. MySQL server is not running");
            System.err.println("2. Incorrect username/password");
            System.err.println("3. Firewall blocking connection");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error occurred:");
            e.printStackTrace();
        }
    }
}