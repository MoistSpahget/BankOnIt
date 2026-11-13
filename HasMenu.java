import java.util.Scanner;

interface HasMenu {
    Scanner input = new Scanner(System.in);

    String menu();

    void start();
}
