package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.User;

public class GreatestCommonDivision {
    public static void start(User user) {
        new Engine(user);

        while (Engine.getSuccessAttempts() > 0) {
            Engine.describeGame("Find the greatest common divisor of given numbers.");

            int numberOne = Engine.getRandomNumber(101);
            int numberTwo = Engine.getRandomNumber(101);
            int correctAnswer = Engine.calculateGCD(numberOne, numberTwo);

            Engine.askQuestion(numberOne, numberTwo);

            String answer = Engine.getAnswer();

            Engine.compareAnswers(user, answer, Integer.toString(correctAnswer));

            if (Engine.getSuccessAttempts() == 0) {
                Engine.userCongratulation(user);
            }
        }
    }
}
