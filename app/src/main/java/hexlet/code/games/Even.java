package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Even {
    private static final String DESCRIPTION_OF_THE_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start() {
        String[][] questionsAndAnswers = new String[Engine.ATTEMPTS_TO_WIN][Engine.ATTEMPTS_TO_WIN];

        for (int i = 0; i < Engine.ATTEMPTS_TO_WIN; i++) {
            int randomNumber = Util.getRandomNumber();
            String question = Integer.toString(randomNumber);

            boolean isEven = isEven(randomNumber);
            String correctAnswer = isEven ? "yes" : "no";

            for (int j = 0; j < 2; j++) {
                questionsAndAnswers[i][j] = question;
                questionsAndAnswers[i][j] = correctAnswer;

            }
        }

        Engine.playGame(DESCRIPTION_OF_THE_GAME, questionsAndAnswers);
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
