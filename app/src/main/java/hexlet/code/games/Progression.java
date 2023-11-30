package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.User;

public class Progression {
    private static int counter;
    public static void start(User user) {
        Cli.start(user);

        for (int i = 0; i < Engine.getAttemptsToWin(); i++) {
            Engine.describeGame("What number is missing in the progression?");

            int range = Engine.getRandomNumber(Engine.getDefaultRange());
            //Получаю прогрессию с рандомным диапазоном
            int[] progression = Engine.createProgression(range);

            //Беру рандомный индекс, который будет замаскирован
            int indexOfUnknownElementProgression = Engine.getRandomNumber(progression.length);

            //Получаю правильный ответ
            String correctAnswer = Integer.toString(progression[indexOfUnknownElementProgression]);

            Engine.askQuestion(progression, indexOfUnknownElementProgression);

            String answer = Engine.getAnswer();

            Engine.compareAnswers(user, answer, correctAnswer);
        }

        Engine.userCongratulation(user);
    }
}
