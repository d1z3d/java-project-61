package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void getUserNameAndGreeting(Scanner scanner) {
        System.out.print("May i have your name? ");
        String userName = scanner.nextLine();
        System.out.printf("Hello, %s!\n", userName);
    }
}
