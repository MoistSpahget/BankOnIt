import java.util.Scanner;

interface HasMenu {
    Scanner input = new Scanner(System.in);

    String menu();

    void start();
}

public class BankOnIt implements HasMenu {

    public static void main(String[] args) {
        BankOnIt bank = new BankOnIt();
        bank.start();
    }

    public String menu() {
        System.out.println();
        System.out.println("Customer Menu");
        System.out.println();
        System.out.println("0) Exit");
        System.out.println("1) Manage Checking Account");
        System.out.println("2) Manage Savings Account");
        System.out.println("3) change PIN");
        System.out.println();
        System.out.print("Action (0-3): ");
        String choice = input.nextLine();
        return choice;
    }

    public void start() {
        String choice = menu();
        while (!choice.equals("0")) {
            if (choice.equals("1")) {
                accountMenu("Checking Account");
            } else if (choice.equals("2")) {
                accountMenu("Savings Account");
            } else if (choice.equals("3")) {
                System.out.println("Changing PIN...");
            } else {
                System.out.println("Please enter a number from 0 to 3.");
            }
            choice = menu();
        }
    }

    public void accountMenu(String name) {
        System.out.println(name);
        String choice = "";
        while (!choice.equals("0")) {
            System.out.println();
            System.out.println("Account menu");
            System.out.println();
            System.out.println("0) quit");
            System.out.println("1) check balance");
            System.out.println("2) make a deposit");
            System.out.println("3) make a withdrawal");
            System.out.println();
            System.out.print("Please enter 0-3: ");
            choice = input.nextLine();

            if (choice.equals("1")) {
                System.out.println("Checking balance...");
            } else if (choice.equals("2")) {
                System.out.println("Making a deposit...");
            } else if (choice.equals("3")) {
                System.out.println("Making a withdrawal...");
            } else if (!choice.equals("0")) {
                System.out.println("Please enter a number from 0 to 3.");
            }
        }
    }
}
