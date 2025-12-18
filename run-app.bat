@echo off
TITLE Personal Expense Tracker - Runner

echo ==========================================
echo Personal Expense Tracker Application
echo ==========================================

echo.
echo Starting the Personal Expense Tracker application...
echo.

:menu
echo Select an option:
echo 1. Run Backend (User Management)
echo 2. Run Frontend (Web Interface)
echo 3. Run Database Test
echo 4. Run Both Backend and Frontend
echo 5. Exit
echo.

set /p choice=Enter your choice (1-5): 

if "%choice%"=="1" goto run_backend
if "%choice%"=="2" goto run_frontend
if "%choice%"=="3" goto run_db_test
if "%choice%"=="4" goto run_both
if "%choice%"=="5" goto exit
echo Invalid choice. Please try again.
echo.
goto menu

:run_backend
echo.
echo Starting Backend (User Management)...
echo Make sure MySQL Server is running with root/Coder@1122 credentials
echo.
cd /d "d:\Minor project\Personal_Expense_Tracker\backend"
call mvn exec:java -D"exec.mainClass"="com.PersonalExpenseTracker.UserProfile"
echo.
echo Backend process finished.
echo.
pause
goto menu

:run_frontend
echo.
echo Starting Frontend (Web Interface)...
echo.
cd /d "d:\Minor project\Personal_Expense_Tracker\frontend"
call npm run dev
echo.
echo Frontend process finished.
echo.
pause
goto menu

:run_db_test
echo.
echo Running Database Test...
echo.
cd /d "d:\Minor project\Personal_Expense_Tracker\backend"
call mvn exec:java -D"exec.mainClass"="com.PersonalExpenseTracker.DatabaseTest"
echo.
echo Database test finished.
echo.
pause
goto menu

:run_both
echo.
echo Starting both Backend and Frontend...
echo Note: You'll need to open two separate command prompts for this
echo.
echo First, start the backend in this window:
echo Navigate to the backend folder and run:
echo mvn exec:java -D"exec.mainClass"="com.PersonalExpenseTracker.UserProfile"
echo.
echo Then, open a new command prompt and start the frontend:
echo cd frontend
echo npm run dev
echo.
echo Press any key to continue...
pause >nul
goto menu

:exit
echo.
echo Thank you for using Personal Expense Tracker!
echo.
pause
exit