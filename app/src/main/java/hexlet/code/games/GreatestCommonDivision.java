package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.User;

public class GreatestCommonDivision {
    public static void start(User user) {
        Cli.start(user);

        for (int i = 0; i < Engine.getAttemptsToWin(); i++) {
            Engine.describeGame("Find the greatest common divisor of given numbers.");

            int numberOne = Engine.getRandomNumber(Engine.getDefaultRange());
            int numberTwo = Engine.getRandomNumber(Engine.getDefaultRange());
            int correctAnswer = Engine.calculateGCD(numberOne, numberTwo);

            Engine.askQuestion(numberOne, numberTwo);

            String answer = Engine.getAnswer();

            Engine.compareAnswers(user, answer, Integer.toString(correctAnswer));
        }

        Engine.userCongratulation(user);
    }
}
