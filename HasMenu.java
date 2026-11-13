import java.util.Scanner;

/** Anything in the bank that shows a menu and runs a loop for it. */
interface HasMenu {
    // Shared by every class. Interface fields are static, so this is never serialized.
    Scanner input = new Scanner(System.in);

    String menu();

    void start();
}
