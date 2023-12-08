package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.GreatestCommonDivision;

import java.util.Scanner;

public final class App {
    public static void main(String[] args) {

        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                """);
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        System.out.println();

        switch (userInput) {
            case "1" -> Cli.start();
            case "2" -> Even.start();
            case "3" -> Calculator.start();
            case "4" -> GreatestCommonDivision.start();
            case "5" -> Progression.start();
            case "6" -> Prime.start();
            case "0" -> System.out.println("Goodbye!");
            default -> System.out.println("Unexpected data");
        }
    }
}
