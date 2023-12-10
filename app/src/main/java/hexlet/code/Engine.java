package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final int ATTEMPTS_TO_WIN = 3;

    public static void playGame(String descriptionOfTheGame, String[][] questionsAndAnswers) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = "";

        if (scanner.hasNextLine()) {
            userName = scanner.nextLine();
            System.out.println("Hello, " + userName + "!");
        } else {
            System.out.println("Name was not entered. Goodbye!");
        }

        for (int i = 0; i < ATTEMPTS_TO_WIN; i++) {
            System.out.println(descriptionOfTheGame);
            System.out.printf("Question: %s\n", questionsAndAnswers[i][0]);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(questionsAndAnswers[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer '%s'\n", answer, questionsAndAnswers[i][1]);
                System.out.printf("Let's try again, %s!\n", userName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!\n", userName);
    }
}
