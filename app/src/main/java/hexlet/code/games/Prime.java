package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;
import org.apache.commons.lang3.ArrayUtils;

public class Prime {
    private static final String DESCRIPTION_THE_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int[] PRIME_NUMBERS = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                                                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
                                                101, 103, 107, 109, 113, 127, 131, 137, 139, 149,
                                                151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
                                                199, 211, 223, 227, 229, 233, 239, 241, 251, 257,
                                                263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
                                                317, 331, 337, 347, 349, 353, 359, 367, 373, 379,
                                                383, 389, 397, 401, 409, 419, 421, 431, 433, 439,
                                                443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
                                                503, 509, 521, 523, 541, 547, 557};

    public static void start() {
        String[][] questionsAndAnswers = new String[Engine.ATTEMPTS_TO_WIN][2];

        for (int i = 0; i < Engine.ATTEMPTS_TO_WIN; i++) {
            int randomNumber = Util.getRandomNumber(PRIME_NUMBERS[PRIME_NUMBERS.length - 1]);

            String question = Integer.toString(randomNumber);

            boolean isContains = ArrayUtils.contains(PRIME_NUMBERS, randomNumber);
            String correctAnswer = isContains ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.playGame(DESCRIPTION_THE_GAME, questionsAndAnswers);
    }
}
