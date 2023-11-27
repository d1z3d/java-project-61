package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final Random RANDOM = new Random();
    private static final String[] OPERATIONS = {"+", "-", "*", "/"};
    private static int successAttempts = 3;

    public Engine(User user) {
        Cli.start(user);
    }

    public static int getSuccessAttempts() {
        return successAttempts;
    }

    public static void setSuccessAttempts(int successAttempts) {
        Engine.successAttempts = successAttempts;
    }

    public static void decrementSuccessAttempts() {
        successAttempts--;
    }

    public static void describeGame(String description) {
        System.out.println(description);
    }

    public static void askQuestion(String value) {
        System.out.println("Question: " + value);
    }

    public static void askQuestion(int firstValue, int secondValue, String operation) {
        System.out.printf("Question: %d %s %d\n", firstValue, operation, secondValue);
    }

    public static String getAnswer() {
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getCorrectAnswer(boolean isCorrect) {
        return isCorrect ? "yes" : "no";
    }

    public static String calculate(int firstValue, int secondValue, String operation) {
        switch (operation) {
            case "+":
                return Integer.toString(firstValue + secondValue);
            case "-":
                return Integer.toString(firstValue - secondValue);
            case "*":
                return Integer.toString(firstValue * secondValue);
            case "/":
                if (firstValue != 0 && secondValue != 0) {
                    return Integer.toString(firstValue / secondValue);
                } else {
                    return "You can't divide by 0";
                }
            default:
                return "";
        }
    }

    public static void userCongratulation(User user) {
        System.out.printf("Congratulations, %s!\n", user.getName());
    }

    public static int getRandomNumber(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static void compareAnswers(User user, String answer, String correctAnswer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct!");
            Engine.decrementSuccessAttempts();
        } else {
            //Должно быть 3 подряд успешных ответа.
            Engine.setSuccessAttempts(3);
            System.out.printf("'%s' is wrong answer ;(. Correct answer '%s'\n", answer, correctAnswer);
            System.out.printf("Let's try again, %s!\n", user.getName());
        }
    }

    public static String getRandomOperation() {
        int randomIndex = getRandomNumber(OPERATIONS.length);
        return OPERATIONS[randomIndex];
    }
}
