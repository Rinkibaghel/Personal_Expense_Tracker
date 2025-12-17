package com.PersonalExpenseTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class App {

    // Define database connection parameters
    static final String DB_URL = "jdbc:mysql://localhost:3306/expense_tracker";
    static final String USER = "root";
    static final String PASS = "Coder@1122";
    static final String QUERY = "SELECT COUNT(*) AS count FROM UserProfile";

    public static void main(String[] args) {
        // Use try-with-resources to ensure resources are closed automatically
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            System.out.println("Connection successful!");

            // Process the result set
            if (rs.next()) {
                int count = rs.getInt("count");
                System.out.println("Number of users in the database: " + count);
                
                if (count == 0) {
                    System.out.println("No users found. Please register a user first.");
                } else {
                    System.out.println("Database is properly initialized with " + count + " user(s).");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection or query failed: " + e.getMessage());
            System.err.println("Possible causes:");
            System.err.println("1. MySQL server is not running");
            System.err.println("2. Database 'expense_tracker' does not exist yet");
            System.err.println("3. Incorrect username/password");
            System.err.println("4. MySQL JDBC driver not found");
            e.printStackTrace();
        }
    }
}