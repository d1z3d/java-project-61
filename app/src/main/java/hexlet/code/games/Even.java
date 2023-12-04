package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Even {
    private static final String DESCRIPTION_OF_THE_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String[] QUESTIONS = new String[Util.ATTEMPTS_TO_WIN];
    private static final String[] CORRECT_ANSWERS = new String[Util.ATTEMPTS_TO_WIN];

    public static void start() {
        //Подготовка данных
        for (int i = 0; i < Util.ATTEMPTS_TO_WIN; i++) {
            int randomNumber = Util.getRandomNumber();
            QUESTIONS[i] = Integer.toString(randomNumber);

            boolean isEven = isEven(randomNumber);
            String correctAnswer = Util.getCorrectAnswer(isEven);
            CORRECT_ANSWERS[i] = correctAnswer;
        }

        //Старт игры
        Engine.playGame(DESCRIPTION_OF_THE_GAME, QUESTIONS, CORRECT_ANSWERS);
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }


}
