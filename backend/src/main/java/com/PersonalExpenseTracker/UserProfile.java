package com.PersonalExpenseTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserProfile {

    private static final String HOST_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "expense_tracker";
    private static final String USER = "root"; // Change if needed
    private static final String PASS = "Coder@1122"; // Change if needed

    public static void main(String[] args) {
        UserProfile userProfile = new UserProfile();
        userProfile.initializeDatabase();
        userProfile.updateTableStructure(); // Add this to update existing table structure
        
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Register new user");
        System.out.println("2. Login");
        System.out.print("Choose an option: ");
        
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                userProfile.registerUser();
                break;
            case 2:
                userProfile.loginUser();
                break;
            default:
                System.out.println("Invalid option");
        }
        
        sc.close();
    }

    public void initializeDatabase() {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 1: Connect to MySQL Server (no database yet)
            Connection con = DriverManager.getConnection(HOST_URL, USER, PASS);
            Statement stmt = con.createStatement();

            // Step 2: Create Database
            String createDB = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            stmt.executeUpdate(createDB);
            System.out.println("✅ Database created or already exists");

            // Step 3: Connect to the Database
            con = DriverManager.getConnection(HOST_URL + DB_NAME, USER, PASS);
            stmt = con.createStatement();

            // Step 4: Create Table with proper column sizes
            String createTable =
                    "CREATE TABLE IF NOT EXISTS UserProfile ("
                            + "UserName VARCHAR(50) NOT NULL, "
                            + "Gmail VARCHAR(50) UNIQUE NOT NULL, "
                            + "ContactNumber VARCHAR(15), "
                            + "AppLockPass VARCHAR(255) NOT NULL"  // Increased size to 255 for hashed passwords
                            + ")";

            stmt.executeUpdate(createTable);
            System.out.println("✅ Table created or already exists");

            con.close();

        } catch (Exception e) {
            System.err.println("Error initializing database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateTableStructure() {
        try {
            // Connect to the Database
            String url = HOST_URL + DB_NAME;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, USER, PASS);
            Statement stmt = con.createStatement();

            // Modify the AppLockPass column to increase its size
            String alterTable = "ALTER TABLE UserProfile MODIFY AppLockPass VARCHAR(255) NOT NULL";
            
            stmt.executeUpdate(alterTable);
            System.out.println("✅ Table structure updated successfully");

            con.close();

        } catch (Exception e) {
            // If the column doesn't exist or other SQL error, print but don't stop execution
            System.out.println("ℹ️  Table structure update skipped or not needed: " + e.getMessage());
        }
    }

    public void registerUser() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter User Name: ");
            String userName = sc.nextLine();

            System.out.print("Enter Gmail: ");
            String gmail = sc.nextLine();

            System.out.print("Enter Contact Number: ");
            String contact = sc.nextLine();

            System.out.print("Enter App Lock Password: ");
            String appLockPass = sc.nextLine();

            // 🔐 Hash the password
            String hashedPass = hashPassword(appLockPass);

            String url = HOST_URL + DB_NAME;
            String sql = "INSERT INTO UserProfile (UserName, Gmail, ContactNumber, AppLockPass) VALUES (?, ?, ?, ?)";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, USER, PASS);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, gmail);
            ps.setString(3, contact);
            ps.setString(4, hashedPass);  // This is now properly sized

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ User registered successfully!");
            }

            con.close();

        } catch (Exception e) {
            System.err.println("Error registering user: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // sc.close(); // Don't close here as it's used in main
        }
    }

    public void loginUser() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Gmail: ");
            String gmail = sc.nextLine();

            System.out.print("Enter App Lock Password: ");
            String appLockPass = sc.nextLine();

            // 🔐 Hash the password for comparison
            String hashedPass = hashPassword(appLockPass);

            String url = HOST_URL + DB_NAME;
            String sql = "SELECT UserName FROM UserProfile WHERE Gmail = ? AND AppLockPass = ?";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, USER, PASS);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, gmail);
            ps.setString(2, hashedPass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String userName = rs.getString("UserName");
                System.out.println("✅ Login successful! Welcome " + userName);
            } else {
                System.out.println("❌ Invalid credentials!");
            }

            con.close();

        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // sc.close(); // Don't close here as it's used in main
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}