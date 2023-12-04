package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class Util {
    private static final Random RANDOM = new Random();
    public static final int ATTEMPTS_TO_WIN = 3;
    private static final int DEFAULT_RANGE = 101;


    public static int getRandomNumber(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int getRandomNumber(int origin, int bound) {
        return RANDOM.nextInt(origin, bound);
    }

    public static int getRandomNumber() {
        return getRandomNumber(DEFAULT_RANGE);
    }

    public static void compareAnswers(String answer, String correctAnswer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer '%s'\n", answer, correctAnswer);
            System.out.printf("Let's try again, %s!\n", App.getUserName());
            System.exit(0);
        }
    }

    public static void describeGame(String description) {
        System.out.println(description);
    }

    public static void askQuestion(String question) {
        System.out.printf("Question: %s\n", question);
    }

    public static String getAnswer() {
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void userCongratulation() {
        System.out.printf("Congratulations, %s!\n", App.getUserName());
    }

    public static String getCorrectAnswer(boolean isCorrect) {
        return isCorrect ? "yes" : "no";
    }
}
