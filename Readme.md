# Personal Expense Tracker

A full-stack application for tracking personal expenses and income.

## Project Structure

```
Personal_Expense_Tracker/
├── backend/           # Java Spring Boot backend
│   ├── src/
│   │   └── main/java/com/PersonalExpenseTracker/
│   │       ├── App.java
│   │       ├── UserProfile.java
│   │       └── DatabaseTest.java
│   └── pom.xml
├── frontend/          # React frontend with Vite
│   ├── src/
│   │   ├── App.jsx
│   │   ├── App.css
│   │   └── main.jsx
│   ├── index.html
│   └── package.json
└── database.md
```

## Prerequisites

- Java 8 or higher
- MySQL Server
- Node.js and npm
- Maven

## Setup Instructions

### 1. Database Setup

1. Install and start MySQL Server
2. Create a MySQL user with the following credentials:
   - Username: `root`
   - Password: `Coder@1122`
   - Or update the credentials in the Java files if you prefer different ones

### 2. Backend Setup

1. Navigate to the backend directory:
   ```
   cd backend
   ```

2. Build the project using Maven:
   ```
   mvn clean install
   ```

3. Run the database initialization:
   ```
   mvn exec:java -Dexec.mainClass="com.PersonalExpenseTracker.UserProfile"
   ```

### 3. Frontend Setup

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

## Running the Application

### Backend

To run the backend services:

1. Database test:
   ```
   mvn exec:java -Dexec.mainClass="com.PersonalExpenseTracker.DatabaseTest"
   ```

2. User profile management:
   ```
   mvn exec:java -Dexec.mainClass="com.PersonalExpenseTracker.UserProfile"
   ```

3. Application check:
   ```
   mvn exec:java -Dexec.mainClass="com.PersonalExpenseTracker.App"
   ```

### Frontend

To start the frontend development server:
```
npm run dev
```

The application will be available at `http://localhost:5173`

## Features

- User registration and login
- Expense tracking
- Income tracking
- Dashboard with financial overview
- Detailed reports

## Troubleshooting

### Common Issues

1. **Database Connection Failed**
   - Ensure MySQL server is running
   - Check username and password
   - Verify MySQL JDBC driver is installed

2. **Port Already in Use**
   - Change the port in the frontend configuration

3. **Missing Dependencies**
   - Run `mvn clean install` in the backend
   - Run `npm install` in the frontend

### Testing Database Connection

Run the DatabaseTest class to verify your database connection:
```
mvn exec:java -Dexec.mainClass="com.PersonalExpenseTracker.DatabaseTest"
```