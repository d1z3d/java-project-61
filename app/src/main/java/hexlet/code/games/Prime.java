package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;
import org.apache.commons.lang3.ArrayUtils;

public class Prime {
    private static final String DESCRIPTION_THE_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String[] QUESTIONS = new String[Util.ATTEMPTS_TO_WIN];
    private static final String[] CORRECT_ANSWERS = new String[Util.ATTEMPTS_TO_WIN];
    private static final int[] PRIME_NUMBERS = calculatePrimeArray();
    private static final int MIN_DIVIDERS = 2;
    private static final int MAX_DIVIDERS = 3;
    private static int dividers = 1;
    public static void start() {
        //Подготовка данных
        for (int i = 0; i < Util.ATTEMPTS_TO_WIN; i++) {
            int randomNumber = Util.getRandomNumber(PRIME_NUMBERS[PRIME_NUMBERS.length - 1]);

            String question = Integer.toString(randomNumber);
            QUESTIONS[i] = question;

            boolean isContains = ArrayUtils.contains(PRIME_NUMBERS, randomNumber);
            String correctAnswer = Util.getCorrectAnswer(isContains);
            CORRECT_ANSWERS[i] = correctAnswer;
        }

        //Старт игры
        Engine.playGame(DESCRIPTION_THE_GAME, QUESTIONS, CORRECT_ANSWERS);
    }

    private static int[] calculatePrimeArray() {
        int attempts = Util.getRandomNumber();

        int lengthArray = calculateLengthArrayForPrimeGame(attempts) - 1;
        int[] result = new int[lengthArray];
        int indexToInsert = 0;

        for (int i = 2; i <= attempts; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    dividers++;
                }
            }
            if (dividers <= MIN_DIVIDERS) {
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

        for (int i = 2; i <= number; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    dividers++;
                }
            }
            if (dividers < MAX_DIVIDERS) {
                lengthArray++;
            }
            dividers = 1;
        }
        return lengthArray;
    }
}
