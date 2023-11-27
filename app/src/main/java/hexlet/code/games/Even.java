package hexlet.code.games.even;

import hexlet.code.Engine;
import hexlet.code.models.User;

public class Even {


    public static void start(User user) {
        new Engine(user);

        while (Engine.getSuccessAttempts() > 0) {
            Engine.describeGame("Answer 'yes' if the number is even, otherwise answer 'no'.");

            int randomNumber = Engine.getRandomNumber(101);

            Engine.askQuestion(Integer.toString(randomNumber));

            //Получение ответа от пользователя
            String answer = Engine.getAnswer();

            //Четное ли число
            boolean isEven = isEven(randomNumber);

            //Определение правильного ответа
            String correctAnswer = Engine.getCorrectAnswer(isEven);

            //Сравнение ответов
            Engine.compareAnswers(user, answer, correctAnswer);

            //Поздравление пользователя, если осталось 0 попыток до победы
            if (Engine.getSuccessAttempts() == 0) {
                Engine.userCongratulation(user);
            }
        }
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}