package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class GreatestCommonDivision {
    private static final String DESCRIPTION_OF_THE_GAME = "Find the greatest common divisor of given numbers.";

    public static void start() {
        String[][] questionsAndAnswers = new String[Engine.ATTEMPTS_TO_WIN][2];

        for (int i = 0; i < Engine.ATTEMPTS_TO_WIN; i++) {
            int numberOne = Util.getNumberForGCD(Util.getRandomNumber());
            System.out.println(numberOne);
            int numberTwo = Util.getNumberForGCD(Util.getRandomNumber());
            System.out.println(numberTwo);

            String question = String.format("%d %d", numberOne, numberTwo);
            System.out.println(question);

            String correctAnswer = Integer.toString(calculateGCD(numberOne, numberTwo));
            System.out.println(correctAnswer);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.playGame(DESCRIPTION_OF_THE_GAME, questionsAndAnswers);
    }

    private static int calculateGCD(int value1, int value2) {
        int maxValue = Math.max(value1, value2);
        int minValue = Math.min(value1, value2);

        int result = maxValue % minValue;

        return result == 0 ? minValue : calculateGCD(minValue, result);
    }
}
