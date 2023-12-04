package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void start() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            App.setUserName(scanner.nextLine());
            System.out.println("Hello, " + App.getUserName() + "!");
        } else {
            System.out.println("Name was not entered. Goodbye!");
        }
    }
}
