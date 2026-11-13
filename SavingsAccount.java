public class SavingsAccount extends CheckingAccount {
    private static final long serialVersionUID = 1L;
    private static final double INTEREST_RATE = 0.05; // 5% per application

    public SavingsAccount() { super(); }

    public SavingsAccount(double startingBalance) { super(startingBalance); }

    public void calcInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        record("Interest " + money(interest));
        System.out.println("New balance: " + money(balance));
    }
}
