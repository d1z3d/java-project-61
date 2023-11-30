package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.User;
import org.apache.commons.lang3.ArrayUtils;

public class Prime {
    public static void start(User user) {
        Cli.start(user);

        int[] primeNumbers = Engine.calculatePrimeArray();

        for (int i = 0; i < Engine.getAttemptsToWin(); i++) {
            Engine.describeGame("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

            int randomNumber = Engine.getRandomNumber(primeNumbers[primeNumbers.length - 1]);
            boolean isContains = ArrayUtils.contains(primeNumbers, randomNumber);
            String correctAnswer = Engine.getCorrectAnswer(isContains);

            Engine.askQuestion(Integer.toString(randomNumber));

            String answer = Engine.getAnswer();

            Engine.compareAnswers(user, answer, correctAnswer);
        }

        Engine.userCongratulation(user);
    }
}
