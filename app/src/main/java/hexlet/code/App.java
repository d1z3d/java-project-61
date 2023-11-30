package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.GreatestCommonDivision;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        User user = new User();
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        System.out.println();

        switch (userInput) {
            case "1":
                Cli.start(user);
                break;
            case "2":
                Even.start(user);
                break;
            case "3":
                Calculator.start(user);
                break;
            case "4":
                GreatestCommonDivision.start(user);
                break;
            case "5":
                Progression.start(user);
                break;
            case "6":
                Prime.start(user);
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
