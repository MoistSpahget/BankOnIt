# Bank On It Java Lab

Part 1 and 2 Java Lab Bank on it

## Algorithm

# HasMenu
* Every class with a menu has to have:
* menu() that shows options and gives back what the user picked
* start() that runs the menu over and over
* User
* Keep a user name and a PIN
* Login with a name and PIN:
* if the name and PIN both match, say yes
* else say no
* Login by asking:
* ask the user for their name
* ask the user for their PIN
* check them with the login above
* if it did not match, say "Login failed."
* Check a PIN:
* it is good only if it is exactly 4 digits


# CheckingAccount
* Start with a balance of 0
* Deposit:
* if the amount is 0 or less, say it has to be more than $0.00
* else add it to the balance
* save it in the history
* say the new balance
* Withdraw:
* if the amount is 0 or less, say it has to be more than $0.00
* else if the amount is more than the balance, say "Insufficient funds."
* else subtract it from the balance
* save it in the history
* say the new balance
* Show history:
* print every line in the history list


# SavingsAccount
* Is a checking account that can also earn interest
* Calculate interest:
* interest = balance times 0.05
* add the interest to the balance
* save it in the history
* say the new balance


# Customer
* Has a checking account and a savings account
* Report:
* give back "User: name, Checking: $x, Savings: $y"
* Make the customer menu:
* show the options
* ask the user to pick a number
* give back what they picked
* customer menu:
* pick = show the customer menu
* while pick is not 0:
* if pick is 1, go to the account menu for checking
* else if pick is 2, go to the account menu for savings
* else if pick is 3, change the PIN
* else say "Please enter a number from 0 to 3."
* pick = show the customer menu again


# Account menu
* say the account name
* pick = nothing yet
* while pick is not 0
* show options
* ask the user to pick a number
* 1, say the balance
* 2, ask for an amount, then make a deposit
* 3, ask for an amount, then make a withdrawal
* 4, show the history
* not 0, say "Please enter a number from 0 to 4"
* Change PIN
* ask for the current PIN
* if it is wrong, say "Incorrect PIN." and stop
* ask for the new PIN
* if it is not 4 digits, say so and stop
* set the new PIN and say "PIN changed."


# Admin
* Is a user with the name "admin" and the PIN "0000"
* Make the admin menu:
* show the options
* ask the user to pick a number
* give back what they picked
* start() stays empty because the bank does the admin work
* Report:
* give back the admin name and PIN


# CustomerList
* Is just a list of customers
* It is its own class so it can be saved and loaded with no warning


# BankOnIt
* Has one admin and a list of customers
* Start the bank:
* if there is no saved file, make the sample customers and save them
* else load the customers from the file
* run the bank menu
* save the customers when it ends
* Bank menu:
* pick = show the bank menu
* while pick is not 0:
* if pick is 1, ask the admin to login, and if it works go to the admin menu
* else if pick is 2, login as a customer
* else say "Please enter a number from 0 to 2."
* pick = show the bank menu again
* Admin menu loop:
* pick = show the admin menu
* while pick is not 0:
* if pick is 1, show the full customer report
* else if pick is 2, add a user
* else if pick is 3, apply interest
* else say "Please enter a number from 0 to 3."
* pick = show the admin menu again
* Full customer report:
* go through every customer
* print their report
* Add user:
* ask for a name
* if the name is blank or already used, say so and stop
* ask for a PIN
* if it is not 4 digits, say so and stop
* make a new customer and add them to the end of the list
* Apply interest:
* go through every customer
* calculate interest on their savings account
* Customer login:
* ask for a user name and a PIN
* currentCustomer = nobody
* go through every customer
* if the name and PIN match, currentCustomer = that customer
* if currentCustomer is still nobody, say "Login failed."
* else start that customer's menu, then save
* Sample customers:
* Alice, PIN 1111, $1000 in checking and $1000 in savings
* Bob, PIN 2222
* Cindy, PIN 3333
* Save:
* write the customer list to customers.ser
* Load:
* read the customer list from customers.ser
* if that does not work, go back to the sample customers