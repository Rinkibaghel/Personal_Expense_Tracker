import { useState } from 'react'
import './App.css'

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false)
  const [activeTab, setActiveTab] = useState('dashboard')
  const [expenses, setExpenses] = useState([])
  const [income, setIncome] = useState([])

  // Mock data for demonstration
  const mockExpenses = [
    { id: 1, description: 'Groceries', amount: 50.00, date: '2023-06-15', category: 'Food' },
    { id: 2, description: 'Gas', amount: 40.00, date: '2023-06-14', category: 'Transportation' },
    { id: 3, description: 'Movie tickets', amount: 30.00, date: '2023-06-12', category: 'Entertainment' }
  ]

  const mockIncome = [
    { id: 1, description: 'Salary', amount: 2500.00, date: '2023-06-01', category: 'Job' },
    { id: 2, description: 'Freelance work', amount: 500.00, date: '2023-06-10', category: 'Work' }
  ]

  const handleLogin = () => {
    setIsLoggedIn(true)
    setExpenses(mockExpenses)
    setIncome(mockIncome)
  }

  const handleLogout = () => {
    setIsLoggedIn(false)
    setActiveTab('dashboard')
  }

  const getTotalExpenses = () => {
    return expenses.reduce((total, expense) => total + expense.amount, 0)
  }

  const getTotalIncome = () => {
    return income.reduce((total, inc) => total + inc.amount, 0)
  }

  const getBalance = () => {
    return getTotalIncome() - getTotalExpenses()
  }

  if (!isLoggedIn) {
    return (
      <div className="login-container">
        <div className="login-form">
          <h2>Personal Expense Tracker</h2>
          <div className="form-group">
            <label>Email:</label>
            <input type="email" placeholder="Enter your email" />
          </div>
          <div className="form-group">
            <label>Password:</label>
            <input type="password" placeholder="Enter your password" />
          </div>
          <button onClick={handleLogin}>Login</button>
          <p>Don't have an account? <a href="#">Sign Up</a></p>
        </div>
      </div>
    )
  }

  return (
    <div className="app">
      <header>
        <h1>Personal Expense Tracker</h1>
        <button onClick={handleLogout}>Logout</button>
      </header>

      <nav>
        <button 
          className={activeTab === 'dashboard' ? 'active' : ''} 
          onClick={() => setActiveTab('dashboard')}
        >
          Dashboard
        </button>
        <button 
          className={activeTab === 'expenses' ? 'active' : ''} 
          onClick={() => setActiveTab('expenses')}
        >
          Expenses
        </button>
        <button 
          className={activeTab === 'income' ? 'active' : ''} 
          onClick={() => setActiveTab('income')}
        >
          Income
        </button>
        <button 
          className={activeTab === 'reports' ? 'active' : ''} 
          onClick={() => setActiveTab('reports')}
        >
          Reports
        </button>
      </nav>

      <main>
        {activeTab === 'dashboard' && (
          <div className="dashboard">
            <div className="summary-cards">
              <div className="card income-card">
                <h3>Total Income</h3>
                <p>${getTotalIncome().toFixed(2)}</p>
              </div>
              <div className="card expense-card">
                <h3>Total Expenses</h3>
                <p>${getTotalExpenses().toFixed(2)}</p>
              </div>
              <div className="card balance-card">
                <h3>Balance</h3>
                <p>${getBalance().toFixed(2)}</p>
              </div>
            </div>

            <div className="recent-transactions">
              <h2>Recent Transactions</h2>
              <table>
                <thead>
                  <tr>
                    <th>Description</th>
                    <th>Amount</th>
                    <th>Date</th>
                    <th>Category</th>
                  </tr>
                </thead>
                <tbody>
                  {[...expenses, ...income]
                    .sort((a, b) => new Date(b.date) - new Date(a.date))
                    .slice(0, 5)
                    .map(transaction => (
                      <tr key={transaction.id}>
                        <td>{transaction.description}</td>
                        <td className={transaction.amount > 0 ? 'income' : 'expense'}>
                          ${transaction.amount.toFixed(2)}
                        </td>
                        <td>{transaction.date}</td>
                        <td>{transaction.category}</td>
                      </tr>
                    ))}
                </tbody>
              </table>
            </div>
          </div>
        )}

        {activeTab === 'expenses' && (
          <div className="expenses">
            <h2>Expenses</h2>
            <button className="add-btn">Add Expense</button>
            <table>
              <thead>
                <tr>
                  <th>Description</th>
                  <th>Amount</th>
                  <th>Date</th>
                  <th>Category</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {expenses.map(expense => (
                  <tr key={expense.id}>
                    <td>{expense.description}</td>
                    <td className="expense">${expense.amount.toFixed(2)}</td>
                    <td>{expense.date}</td>
                    <td>{expense.category}</td>
                    <td>
                      <button>Edit</button>
                      <button>Delete</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}

        {activeTab === 'income' && (
          <div className="income">
            <h2>Income</h2>
            <button className="add-btn">Add Income</button>
            <table>
              <thead>
                <tr>
                  <th>Description</th>
                  <th>Amount</th>
                  <th>Date</th>
                  <th>Category</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {income.map(inc => (
                  <tr key={inc.id}>
                    <td>{inc.description}</td>
                    <td className="income">${inc.amount.toFixed(2)}</td>
                    <td>{inc.date}</td>
                    <td>{inc.category}</td>
                    <td>
                      <button>Edit</button>
                      <button>Delete</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}

        {activeTab === 'reports' && (
          <div className="reports">
            <h2>Reports</h2>
            <div className="report-section">
              <h3>Expense by Category</h3>
              <div className="chart-placeholder">
                Chart visualization would appear here
              </div>
            </div>
            <div className="report-section">
              <h3>Monthly Summary</h3>
              <div className="summary-details">
                <p>June 2023</p>
                <p>Total Income: ${getTotalIncome().toFixed(2)}</p>
                <p>Total Expenses: ${getTotalExpenses().toFixed(2)}</p>
                <p>Net Balance: ${getBalance().toFixed(2)}</p>
              </div>
            </div>
          </div>
        )}
      </main>
    </div>
  )
}

export default App