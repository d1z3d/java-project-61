package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Prime {
    private static final String DESCRIPTION_THE_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void start() {
        String[][] questionsAndAnswers = new String[Engine.ATTEMPTS_TO_WIN][2];

        for (int i = 0; i < Engine.ATTEMPTS_TO_WIN; i++) {
            int randomNumber = Util.getRandomNumber(2, Util.DEFAULT_RANGE);
            String question = Integer.toString(randomNumber);
            String correctAnswer = isPrime(randomNumber) ? "yes" : "no";
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.playGame(DESCRIPTION_THE_GAME, questionsAndAnswers);
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
