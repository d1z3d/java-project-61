package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.User;

public class Progression {
    public static void start(User user) {
        Cli.start(user);

        while (Engine.getSuccessAttempts() > 0) {
            Engine.describeGame("What number is missing in the progression?");

            int range = Engine.getRandomNumber(12);
            //Получаю прогрессию с рандомным диапазоном
            int[] progression = Engine.createProgression(range);

            //Беру рандомный индекс, который будет замаскирован
            int indexOfUnknownElementProgression = Engine.getRandomNumber(progression.length);

            //Получаю правильный ответ
            String correctAnswer = Integer.toString(progression[indexOfUnknownElementProgression]);

            Engine.askQuestion(progression, indexOfUnknownElementProgression);

            String answer = Engine.getAnswer();

            Engine.compareAnswers(user, answer, correctAnswer);

            if (Engine.getSuccessAttempts() == 0) {
                Engine.userCongratulation(user);
            }
        }
    }
}
