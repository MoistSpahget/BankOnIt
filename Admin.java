/** The bank administrator. The real admin work happens in BankOnIt.startAdmin(). */
public class Admin extends User {
    private static final long serialVersionUID = 1L;

    public Admin() {
        super("admin", "0000");
    }

    public String menu() {
        System.out.println();
        System.out.println("Admin Menu");
        System.out.println();
        System.out.println("0) Exit this menu");
        System.out.println("1) Full customer report");
        System.out.println("2) Add user");
        System.out.println("3) Apply interest to savings accounts");
        System.out.println();
        System.out.print("Action: ");
        return input.nextLine().trim();
    }

    /** Intentionally empty: the bank manages admin duties. */
    public void start() {
    }

    public String getReport() {
        return "Admin: " + getUserName() + ", PIN: " + getPIN();
    }
}
