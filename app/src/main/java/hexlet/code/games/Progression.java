package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.util.StringJoiner;

public class Progression {
    private static final String DESCRIPTION_OF_THE_GAME = "What number is missing in the progression?";
    private static final int MIN_LENGTH_OF_PROGRESSION = 5;
    private static final int MAX_LENGTH_OF_PROGRESSION = 11;

    public static void start() {
        String[][] questionsAndAnswers = new String[Engine.ATTEMPTS_TO_WIN][2];

        for (int i = 0; i < Engine.ATTEMPTS_TO_WIN; i++) {
            int lengthProgression = Util.getRandomNumber(MIN_LENGTH_OF_PROGRESSION, MAX_LENGTH_OF_PROGRESSION);
            int valueOfStartProgression = Util.getRandomNumber();
            int range = Util.getRandomNumber();
            int[] progression = createProgression(lengthProgression, valueOfStartProgression, range);
            int randomIndex = Util.getRandomNumber(progression.length - 1);
            StringJoiner joiner = new StringJoiner(" ");

            for (int j = 0; j < progression.length; j++) {
                if (j == randomIndex) {
                    joiner.add("..");
                } else {
                    joiner.add(Integer.toString(progression[j]));
                }
            }

            String question = joiner.toString();
            String correctAnswer = Integer.toString(progression[randomIndex]);
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
}
