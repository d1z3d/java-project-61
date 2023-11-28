package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.User;
import org.apache.commons.lang3.ArrayUtils;

public class Prime {
    public static void start(User user) {
        new Engine(user);

        int[] primeNumbers = Engine.calculatePrimeArray(102);

        while (Engine.getSuccessAttempts() > 0) {
            Engine.describeGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

            int randomNumber = Engine.getRandomNumber(102);
            boolean isContains = ArrayUtils.contains(primeNumbers, randomNumber);
            String correctAnswer = Engine.getCorrectAnswer(isContains);

            Engine.askQuestion(Integer.toString(randomNumber));

            String answer = Engine.getAnswer();

            Engine.compareAnswers(user, answer, correctAnswer);

            if (Engine.getSuccessAttempts() == 0) {
                Engine.userCongratulation(user);
            }
        }
    }
}
