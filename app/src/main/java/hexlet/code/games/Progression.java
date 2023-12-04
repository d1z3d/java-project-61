package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.util.Arrays;

public class Progression {
    private static final String DESCRIPTION_OF_THE_GAME = "What number is missing in the progression?";
    private static final int DEFAULT_NUMBER_OF_PROGRESSION = 21;
    private static final int MIN_LENGTH_OF_PROGRESSION = 5;
    private static final int MAX_LENGTH_OF_PROGRESSION = 11;
    private static final String[] QUESTIONS = new String[Util.ATTEMPTS_TO_WIN];
    private static final String[] CORRECT_ANSWERS = new String[Util.ATTEMPTS_TO_WIN];

    public static void start() {
        //Подготовка данных
        for (int i = 0; i < Util.ATTEMPTS_TO_WIN; i++) {
            int range = Util.getRandomNumber();
            int[] progression = createProgression(range);
            int indexOfUnknownElementProgression = Util.getRandomNumber(progression.length);

            String question = getQuestion(progression, indexOfUnknownElementProgression);
            QUESTIONS[i] = question;

            String correctAnswer = Integer.toString(progression[indexOfUnknownElementProgression]);
            CORRECT_ANSWERS[i] = correctAnswer;
        }

        //Старт игры
        Engine.playGame(DESCRIPTION_OF_THE_GAME, QUESTIONS, CORRECT_ANSWERS);
    }

    private static int[] createProgression(int range) {
        int valueOfStartProgression = Util.getRandomNumber(DEFAULT_NUMBER_OF_PROGRESSION);
        int lengthProgression = Util.getRandomNumber(MIN_LENGTH_OF_PROGRESSION, MAX_LENGTH_OF_PROGRESSION);
        int[] progression = new int[lengthProgression];

        progression[0] = valueOfStartProgression;

        for (int i = 1; i < lengthProgression; i++) {
            progression[i] = progression[i - 1] + range;
        }

        return progression;
    }

    private static String getQuestion(int[] progression, int index) {
        String result = "";
        String[] temp = Arrays.toString(progression)
                .replace("[", "")
                .replace("]", "")
                .split(", ");
        temp[index] = "..";

        for (String item : temp) {
            result = result + item + " ";
        }

        return result;
    }
}
