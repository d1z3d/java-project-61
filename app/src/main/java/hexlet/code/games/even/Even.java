package hexlet.code.games.even;

import hexlet.code.Cli;
import hexlet.code.models.User;

import java.util.Random;
import java.util.Scanner;

public class Even {
    private static int successAttempts = 3;
    private static Random random = new Random();

    public static void start(User user) {
        if (user.getName() == null) {
            Cli.start(user);
        }

        while (successAttempts > 0) {

            int randomNumber = getRandomNumber(0, 101);
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            System.out.println("Question: " + randomNumber);

            //Получение ответа от пользователя
            String answer = getAnswer();

            //Четное ли число
            boolean isEven = isEven(randomNumber);

            //Определение правильного ответа
            String correctAnswer = getCorrectAnswer(answer, isEven);

            //Сравнение ответов
            compareAnswers(user, answer, correctAnswer, isEven);

            if (successAttempts == 0) {
                System.out.printf("Congratulations, %s!\n", user.getName());
            }
        }
    }

    private static String getCorrectAnswer(String answer, boolean isEven) {
        String correctAnswer = isEven && answer.equalsIgnoreCase("yes") ? "yes"
                : !isEven && answer.equalsIgnoreCase("yes") ? "no"
                : isEven && answer.equalsIgnoreCase("no") ? "yes"
                : "no";
        return correctAnswer;
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }

    private static void compareAnswers(User user, String answer, String correctAnswer, boolean isEven) {
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
            if (isEven && answer.equalsIgnoreCase("yes")) {
                System.out.println("Correct!");
                successAttempts--;
            } else if (!isEven && answer.equalsIgnoreCase("no")) {
                System.out.println("Correct!");
                successAttempts--;
            } else {
                //Должно быть 3 подряд успешных ответа.
                successAttempts = 3;
                System.out.printf("'%s' is wrong answer ;(. Correct answer '%s'\n", answer, correctAnswer);
                System.out.printf("Let's try again, %s!\n", user.getName());
            }
        } else {
            successAttempts = 3;
            System.out.println("Say 'yes' or 'no'!");
        }
    }
    public static String getAnswer() {
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static int getRandomNumber(int from, int to) {
        return random.nextInt(from, to);
    }

}
