package hexlet.code;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final Random RANDOM = new Random();
    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static int successAttempts = 3;

    public Engine(User user) {
        Cli.start(user);
    }

    public static int getSuccessAttempts() {
        return successAttempts;
    }

    private static void setSuccessAttempts(int successAttempts) {
        Engine.successAttempts = successAttempts;
    }

    private static void decrementSuccessAttempts() {
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

    public static void askQuestion(int firstValue, int secondValue) {
        System.out.printf("Question: %d %d\n", firstValue, secondValue);
    }

    public static void askQuestion(int[] progression, int index) {
        String[] temp = Arrays.toString(progression)
                .replace("[", "")
                .replace("]", "")
                .split(", ");
        temp[index] = "..";

        System.out.print("Question: ");
        for (String item : temp) {
            System.out.print(item + " ");
        }
        System.out.println();
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
            default:
                return "";
        }
    }

    public static int calculateGCD(int value1, int value2) {
        int maxValue = Math.max(value1, value2);
        int minValue = Math.min(value1, value2);

        int result = maxValue % minValue;

        return result == 0 ? minValue : calculateGCD(minValue, result);
    }

    public static int[] calculatePrimeArray(int range) {
        int attempts = getRandomNumber(range);

        int lengthArray = calculateLengthArrayForPrimeGame(attempts) - 1;
        int[] result = new int[lengthArray];
        int indexToInsert = 0;

        int dividers = 1;

        for (int i = 2; i <= attempts; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    dividers++;
                }
            }
            if (dividers <= 2) {
                result[indexToInsert] = i;
                indexToInsert++;
            }
            dividers = 1;
        }

        return result;
    }

    private static int calculateLengthArrayForPrimeGame(int number) {
        //Считаю, что каждое каждое число можем делить на 1, поэтому начинаю массив с числа 2
        int lengthArray = 1;
        int dividers = 1;

        for (int i = 2; i <= number; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    dividers++;
                }
            }
            if (dividers < 3) {
                lengthArray++;
            }
            dividers = 1;
        }
        return lengthArray;
    }

    public static void userCongratulation(User user) {
        System.out.printf("Congratulations, %s!\n", user.getName());
    }

    public static int getRandomNumber(int origin, int bound) {
        return RANDOM.nextInt(origin, bound);
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

    public static int[] createProgression(int range) {
        int valueOfStartProgression = getRandomNumber(21);
        int lengthProgression = getRandomNumber(5, 11);
        int[] progression = new int[lengthProgression];

        progression[0] = valueOfStartProgression;

        for (int i = 1; i < lengthProgression; i++) {
            progression[i] = progression[i - 1] + range;
        }

        return progression;
    }
}
