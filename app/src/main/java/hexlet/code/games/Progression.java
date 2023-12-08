package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.util.Arrays;

public class Progression {
    private static final String DESCRIPTION_OF_THE_GAME = "What number is missing in the progression?";
    private static final int DEFAULT_NUMBER_OF_PROGRESSION = 21;
    private static final int MIN_LENGTH_OF_PROGRESSION = 5;
    private static final int MAX_LENGTH_OF_PROGRESSION = 11;

    public static void start() {
        String[][] questionsAndAnswers = new String[Engine.ATTEMPTS_TO_WIN][2];

        for (int i = 0; i < Engine.ATTEMPTS_TO_WIN; i++) {
            int lengthProgression = Util.getRandomNumber(MIN_LENGTH_OF_PROGRESSION, MAX_LENGTH_OF_PROGRESSION);
            int valueOfStartProgression = Util.getRandomNumber(DEFAULT_NUMBER_OF_PROGRESSION);
            int range = Util.getRandomNumber();

            int[] progression = createProgression(lengthProgression, valueOfStartProgression, range);
            int indexOfUnknownElementProgression = Util.getRandomNumber(progression.length);

            String question = getQuestion(progression, indexOfUnknownElementProgression);
            String correctAnswer = Integer.toString(progression[indexOfUnknownElementProgression]);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.playGame(DESCRIPTION_OF_THE_GAME, questionsAndAnswers);
    }

    private static int[] createProgression(int lengthProgression, int valueOfStartProgression, int range) {

        int[] progression = new int[lengthProgression];

        for (int i = 0; i < lengthProgression; i++) {
            progression[i] = valueOfStartProgression + range * i;
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
