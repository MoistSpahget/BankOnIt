import java.io.*;

/**
 * The application. Holds one Admin and a list of Customers, runs the main menu,
 * and saves/loads customers with object serialization.
 */
public class BankOnIt implements HasMenu {

    private static final String FILE_NAME = "customers.ser";
    // Set to true for ONE run after changing a serializable class, then set back to false.
    private static final boolean REFRESH_DATA = false;

    private Admin admin = new Admin();
    private CustomerList customers = new CustomerList();

    public static void main(String[] args) {
        new BankOnIt();
    }

    public BankOnIt() {
        if (REFRESH_DATA) {
            loadSampleCustomers();
            saveCustomers();
        }
        loadCustomers();
        start();
        saveCustomers();
    }

    // ---------- main menu ----------

    public String menu() {
        System.out.println();
        System.out.println("Bank Menu");
        System.out.println();
        System.out.println("0) Exit system");
        System.out.println("1) Login as admin");
        System.out.println("2) Login as customer");
        System.out.println();
        System.out.print("Action: ");
        return input.nextLine().trim();
    }

    public void start() {
        String choice = menu();
        while (!choice.equals("0")) {
            if (choice.equals("1")) {
                System.out.println("Admin login");
                if (admin.login()) {
                    startAdmin();
                }
            } else if (choice.equals("2")) {
                customerLogin();
            } else {
                System.out.println("Please enter a number from 0 to 2.");
            }
            choice = menu();
        }
        System.out.println("Thank you for banking with us. Goodbye!");
    }

    // ---------- admin ----------

    public void startAdmin() {
        String choice = admin.menu();
        while (!choice.equals("0")) {
            if (choice.equals("1")) {
                fullCustomerReport();
            } else if (choice.equals("2")) {
                addUser();
            } else if (choice.equals("3")) {
                applyInterest();
            } else {
                System.out.println("Please enter a number from 0 to 3.");
            }
            choice = admin.menu();
        }
    }

    public void fullCustomerReport() {
        System.out.println("Full customer report");
        for (Customer c : customers) {
            System.out.println(c.getReport());
        }
    }

    public void addUser() {
        System.out.println("Add User");
        System.out.print("Name: ");
        String name = input.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be blank. User not added.");
            return;
        }
        for (Customer c : customers) { // EXTENSION: no duplicate user names
            if (c.getUserName().equalsIgnoreCase(name) || name.equalsIgnoreCase(admin.getUserName())) {
                System.out.println("That user name is already taken. User not added.");
                return;
            }
        }
        System.out.print("PIN: ");
        String pin = input.nextLine().trim();
        if (!User.isValidPIN(pin)) {
            System.out.println("A PIN must be exactly four digits. User not added.");
            return;
        }
        customers.add(new Customer(name, pin));
        System.out.println("Customer " + name + " created.");
    }

    public void applyInterest() {
        System.out.println("Apply interest");
        for (Customer c : customers) {
            c.getSavings().calcInterest();
        }
    }

    // ---------- customer login ----------

    public void customerLogin() {
        System.out.println("Customer login");
        System.out.print("User name: ");
        String name = input.nextLine().trim();
        System.out.print("PIN: ");
        String pin = input.nextLine().trim();

        Customer currentCustomer = null;
        for (Customer c : customers) {
            if (c.login(name, pin)) {
                currentCustomer = c;
                break;
            }
        }

        if (currentCustomer == null) {
            System.out.println("Login failed. Check your user name and PIN.");
        } else {
            System.out.println("Welcome, " + currentCustomer.getUserName() + "!");
            currentCustomer.start();
            saveCustomers(); // save after each session so nothing is lost
        }
    }

    // ---------- data ----------

    public void loadSampleCustomers() {
        customers = new CustomerList();

        Customer alice = new Customer("Alice", "1111");
        alice.getChecking().deposit(1000);
        alice.getSavings().deposit(1000);

        customers.add(alice);
        customers.add(new Customer("Bob", "2222"));
        customers.add(new Customer("Cindy", "3333"));
    }

    public void saveCustomers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(customers);
        } catch (IOException e) {
            System.out.println("Could not save customers: " + e.getMessage());
        }
    }

    public void loadCustomers() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved data found. Creating sample customers.");
            loadSampleCustomers();
            saveCustomers();
            return;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            customers = (CustomerList) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Saved data could not be read (" + e.getMessage() + "). Resetting to sample data.");
            loadSampleCustomers();
            saveCustomers();
        }
    }
}
