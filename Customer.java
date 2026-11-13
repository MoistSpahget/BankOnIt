public class Customer extends User {
    private static final long serialVersionUID = 1L;

    private CheckingAccount checking;
    private SavingsAccount savings;

    public Customer(String userName, String PIN) {
        super(userName, PIN);
        checking = new CheckingAccount();
        savings = new SavingsAccount();
    }

    public CheckingAccount getChecking() { return checking; }
    public SavingsAccount getSavings()   { return savings; }

    public String getReport() {
        return "User: " + getUserName()
                + ", Checking: " + checking
                + ", Savings: " + savings;
    }

    public String menu() {
        System.out.println();
        System.out.println("Customer Menu");
        System.out.println();
        System.out.println("0) Exit");
        System.out.println("1) Manage Checking Account");
        System.out.println("2) Manage Savings Account");
        System.out.println("3) Change PIN");
        System.out.println();
        System.out.print("Action (0-3): ");
        return input.nextLine().trim();
    }

    public void start() {
        String choice = menu();
        while (!choice.equals("0")) {
            if (choice.equals("1")) {
                accountMenu(checking, "Checking Account");
            } else if (choice.equals("2")) {
                accountMenu(savings, "Savings Account");
            } else if (choice.equals("3")) {
                changePIN();
            } else {
                System.out.println("Please enter a number from 0 to 3.");
            }
            choice = menu();
        }
    }

    private void accountMenu(CheckingAccount account, String name) {
        System.out.println(name);
        String choice = "";
        while (!choice.equals("0")) {
            System.out.println();
            System.out.println("Account menu");
            System.out.println();
            System.out.println("0) Quit");
            System.out.println("1) Check balance");
            System.out.println("2) Make a deposit");
            System.out.println("3) Make a withdrawal");
            System.out.println("4) View transaction history"); // EXTENSION
            System.out.println();
            System.out.print("Please enter 0-4: ");
            choice = input.nextLine().trim();

            if (choice.equals("1")) {
                System.out.println("Balance: " + account);
            } else if (choice.equals("2")) {
                double amount = readAmount();
                if (amount >= 0) account.deposit(amount);
            } else if (choice.equals("3")) {
                double amount = readAmount();
                if (amount >= 0) account.withdraw(amount);
            } else if (choice.equals("4")) {
                account.printHistory();
            } else if (!choice.equals("0")) {
                System.out.println("Please enter a number from 0 to 4.");
            }
        }
    }

    /** Returns the amount typed, or -1 if it was not a number. */
    private double readAmount() {
        System.out.print("Amount: $");
        try {
            return Double.parseDouble(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("That is not a valid amount.");
            return -1;
        }
    }

    private void changePIN() {
        System.out.print("Current PIN: ");
        String old = input.nextLine().trim();
        if (!old.equals(getPIN())) {
            System.out.println("Incorrect PIN. PIN not changed.");
            return;
        }
        System.out.print("New 4-digit PIN: ");
        String fresh = input.nextLine().trim();
        if (!isValidPIN(fresh)) {
            System.out.println("A PIN must be exactly four digits. PIN not changed.");
            return;
        }
        setPIN(fresh);
        System.out.println("PIN changed.");
    }
}
