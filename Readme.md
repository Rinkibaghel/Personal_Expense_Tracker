# 💸 Personal Expense Tracker – Web Application

A secure, business-focused Personal Expense Tracker designed for high-transaction users, small businesses, and service centers.
This application goes beyond basic daily expense tracking by providing multi-account management, loan analytics, time-based reports, and layered security.

## 📌 Project Overview

The Personal Expense Tracker helps users manage and analyze expenses across multiple linked accounts such as bank, cash, wallet, and loans.
It simulates a UPI-like transaction environment (without using real banking APIs) and provides accurate expense analytics based on date, time, and account type.

This project is built to demonstrate real-world backend logic, security concepts, and data analytics skills.

## 🏠 Main Features

### 🔹 Home Page

- View linked bank/demo accounts by contact number
  - Secure account access using encrypted PIN verification
  - Expense dashboard with:
    - 📅 Year-wise analysis
    - 📆 Month-wise analysis
    - 🕒 Day-wise analysis

- Automatic calculation of expenses based on user selection
- Global search across all transactions

- Loan transaction overview:
  - Loan-linked account
    - Total loan expense tracking
    - Overall loan transaction calculation

### 🔹 Create Account

- User registration with:
  - Username
  - Contact number (linked to demo bank accounts)
  - Gmail
  - Multi-layer encryption:
    - App lock PIN
    - Optional fingerprint simulation
    - SIM-based restriction:
      - Only SIM-inserted users can create accounts (conceptual validation)

### 🔹 Login

- Secure login using:
  - Username
  - Contact number
  - Encrypted credential verification

## 🌟 Unique Selling Points (USP)

🟢 USP 1: High-Transaction Business-Focused Design
🟢 USP 2: Simulated UPI Environment (No Real APIs)
🟢 USP 3: Multi-Account Expense Tracking
🟢 USP 4: Loan & EMI Expense Analytics
🟢 USP 5: Time-Based Smart Reports
🟢 USP 6: Layered Security Model

## 🛠️ Tech Stack

### Backend

- Core Java
- Spring Boot

### Frontend

- React.js

### Database

- MySQL

## 🔧 Setup and Running Instructions

### Prerequisites

Before running the application, make sure you have these installed:
1. **Java 8 or higher**
2. **MySQL Server** (running with root user and password "Coder@1122")
3. **Node.js and npm**
4. **Maven**

### Database Setup

1. Install and start MySQL Server
2. Create a MySQL user with the following credentials:
   - Username: `root`
   - Password: `Coder@1122`
   - Or update the credentials in the Java files if you prefer different ones

### Running the Backend

1. Navigate to the backend directory:
   ```
   cd backend
   ```

2. Build the project using Maven:
   ```
   mvn clean install
   ```

3. Run the user profile management system:
   ```
   mvn exec:java -D"exec.mainClass"="com.PersonalExpenseTracker.UserProfile"
   ```

### Running the Frontend

1. Navigate to the frontend directory:
   ```
   cd frontend
   ```

2. Install dependencies:
   ```
   npm install
   ```

3. Start the development server:
   ```
   npm run dev
   ```

The application will be available at `http://localhost:5173`

## 🔐 Security Concepts Used

- Password hashing & encryption
- Multi-level authentication
- Secure database access
- PIN-based verification logic

## 🎯 Project Objective

To build a real-world inspired expense management system

To demonstrate:

- Backend development skills
- Secure system design
- Database modeling
- Business-level logic handling

## 🚀 Future Enhancements

- Real UPI API integration (sandbox)
- Advanced charts & analytics
- Export reports (PDF / Excel)
- Mobile app version
- AI-based expense insights