# BankJava
CheckingAccount:
  - implements HasMenu
  - Holds template information for accounts

SavingsAccount:
  - extends CheckingAccount
  - Holds information for an interest rate

HasMenu:
  - Standard interface
  - public String menu() displays option and recieves input
  - public void start() loops and utilizes information

Main:
 - Currently holds account information in an ArrayList of Users
 - Performs sign ins

User:
  - implements HasMenu
  - Holds account username and PIN

Customer:
  - extends User
  - Holds operations and account data

Admin:
  - Witholds Ability to calc interest and peek into every account

Bank:
 - holds Admin account and Customer list
 - User interface for both Admin class and overall Bank
