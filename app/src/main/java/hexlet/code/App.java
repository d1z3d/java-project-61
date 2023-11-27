package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        User user = new User();
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
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
                //Even
                Even.start(user);
                break;
            case "3":
                //Calc
                Calculator.start(user);
            case "0":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Unexpected data");
                break;
        }
    }
}
