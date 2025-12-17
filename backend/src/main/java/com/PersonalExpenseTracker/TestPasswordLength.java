package com.PersonalExpenseTracker;

public class TestPasswordLength {
    public static void main(String[] args) {
        // Test the length of a SHA-256 hash
        String testPassword = "myTestPassword123";
        String hashed = UserProfile.hashPassword(testPassword);
        
        System.out.println("Original password: " + testPassword);
        System.out.println("Hashed password: " + hashed);
        System.out.println("Hashed password length: " + hashed.length());
        System.out.println("Required column size: At least " + hashed.length() + " characters");
    }
}