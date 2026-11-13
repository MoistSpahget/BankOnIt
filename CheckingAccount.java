import java.io.Serializable;
import java.util.ArrayList;

public class CheckingAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    protected double balance;
    // EXTENSION: every account keeps a transaction history
    protected ArrayList<String> history = new ArrayList<>();

    public CheckingAccount() {
        this(0.0);
    }

    public CheckingAccount(double startingBalance) {
        this.balance = startingBalance;
        record("Opened with " + money(startingBalance));
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit must be greater than $0.00.");
            return;
        }
        balance += amount;
        record("Deposit " + money(amount));
        System.out.println("Deposited " + money(amount) + ". New balance: " + money(balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be greater than $0.00.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Balance: " + money(balance));
        } else {
            balance -= amount;
            record("Withdrawal " + money(amount));
            System.out.println("Withdrew " + money(amount) + ". New balance: " + money(balance));
        }
    }

    public void printHistory() {
        System.out.println("Transaction history:");
        for (String line : history) {
            System.out.println("  " + line);
        }
    }

    protected void record(String text) {
        history.add(text);
    }

    public static String money(double amount) {
        return String.format("$%.2f", amount);
    }

    public String toString() {
        return money(balance);
    }
}
