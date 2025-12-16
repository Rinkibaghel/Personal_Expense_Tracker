📦🗄️ Database: Expense_Tracker

      1️⃣ User Profile Table
        
            🔐 Login & Signup ke liye
            👉 Is table ka use
                ‍💼 User ka name
                📧 Email ID (login ke liye)
                📱 Contact number 
                🔒 App lock password (secure / encrypted form)
                📅 Account banne ki date
        
      🔗 Relationship
            
            ➕ Ek user ke multiple bank accounts ho sakte hain
            ➕ Ek user ke multiple loan accounts ho sakte hain
        
      🏦 2️⃣ Bank Accounts Table
        
            💳 User ke bank accounts store karne ke liye
            👉 Is table me store hoga
                👤 Kaunsa user owner hai
                🏦 Bank ka naam
                🔢 Account number
                💰 Current balance
                ⏱️ Last update date & time
    
      🔗 Relationship
        
            ➕ Ek bank account se multiple expenses / income ho sakte hain
        
      💸 3️⃣ Expenses / Transactions Table
        
            📊 Actual spending aur income tracking ke liye
            👉 Is table me store hoga
                🏦 Kaunsa bank account use hua
                💵 Amount
                🔄 Expense ya Income
                🗂️ Category (Food, Rent, Travel, EMI, etc.)
                📆 Date & Time
                📝 Short note (optional)
                📈 Is table se tum nikaal sakte ho
                📅 Daily / Monthly expense
                🗂️ Category-wise expense
                🏦 Bank-wise expense
    
      💳 4️⃣ Loan Accounts Table
        
            📄 Loan related details ke liye
            👉 Is table me store hoga
                👤 Kaunsa user ne loan liya
                🏠 Loan type (Home, Education, Personal,business)
                💰 Total loan amount
                📊 Interest rate
                ⏳ Tenure (months)
                💸 EMI amount
                ✅ Loan status (Active / Closed)
                🔮 Future scope
                📆 EMI tracking
                📉 Remaining balance calculation
    
      🔗 Simple Relationship (Normal Language)
        
            👤 Ek User
            ➡️ 🏦 Multiple Bank Accounts
            ➡️ 💳 Multiple Loan Accounts
            🏦 Ek Bank Account
            ➡️ 💸 Multiple Expenses / Income Records