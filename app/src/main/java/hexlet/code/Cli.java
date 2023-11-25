package hexlet.code;

import hexlet.code.models.User;

import java.util.Scanner;

public class Cli {

    public static void start(User user) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May i have your name? ");

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            user.setName(scanner.nextLine());
            System.out.println("Hello, " + user.getName() + "!");
        } else {
            System.out.println("Name was not entered. Goodbye!");
        }
    }
}
