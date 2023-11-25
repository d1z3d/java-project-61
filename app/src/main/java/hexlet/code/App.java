package hexlet.code;

import hexlet.code.games.even.Even;
import hexlet.code.models.User;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        User user = new User();
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        switch (userInput) {
            case "1":
                //Greet
                Cli.start(user);
                break;
            case "2":
                //EvenGame
                Even.start(user);
                break;
            case "0":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Unexpected data");
                break;
        }
    }
}
