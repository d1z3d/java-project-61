package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class GreatestCommonDivision {
    private static final String DESCRIPTION_OF_THE_GAME = "Find the greatest common divisor of given numbers.";
    private static final String[] QUESTIONS = new String[Util.ATTEMPTS_TO_WIN];
    private static final String[] CORRECT_ANSWERS = new String[Util.ATTEMPTS_TO_WIN];

    public static void start() {
        //Подготовка данных
        for (int i = 0; i < Util.ATTEMPTS_TO_WIN; i++) {
            int numberOne = getNumberForGCD();
            System.out.println(numberOne);
            int numberTwo = getNumberForGCD();
            System.out.println(numberTwo);

            String question = String.format("%d %d", numberOne, numberTwo);
            System.out.println(question);
            QUESTIONS[i] = question;

            String correctAnswer = Integer.toString(calculateGCD(numberOne, numberTwo));
            System.out.println(correctAnswer);
            CORRECT_ANSWERS[i] = correctAnswer;
        }

        //Старт игры
        Engine.playGame(DESCRIPTION_OF_THE_GAME, QUESTIONS, CORRECT_ANSWERS);
    }

    private static int calculateGCD(int value1, int value2) {
        int maxValue = Math.max(value1, value2);
        int minValue = Math.min(value1, value2);

        int result = maxValue % minValue;

        return result == 0 ? minValue : calculateGCD(minValue, result);
    }

    private static int getNumberForGCD() {
        int result = Util.getRandomNumber();

        if (result == 0) {
            result++;
        }

        return result;
    }
}
