@echo off
TITLE Personal Expense Tracker - Quick Start

echo ==========================================
echo Personal Expense Tracker - Quick Start
echo ==========================================

echo.
echo Starting the Personal Expense Tracker application...
echo.

echo 1. Starting Backend (User Management)...
echo    Make sure MySQL Server is running with root/Coder@1122 credentials
echo.
cd /d "d:\Minor project\Personal_Expense_Tracker\backend"
start "Backend" cmd /k "mvn exec:java -D"exec.mainClass"="com.PersonalExpenseTracker.UserProfile""

echo.
echo 2. Starting Frontend (Web Interface)...
echo.
cd /d "d:\Minor project\Personal_Expense_Tracker\frontend"
start "Frontend" cmd /k "npm run dev"

echo.
echo The application is now running!
echo.
echo - Backend console is in the first command window
echo - Frontend console is in the second command window
echo - Web interface will be available at http://localhost:5173
echo.
echo Press any key to exit this launcher...
pause >nul