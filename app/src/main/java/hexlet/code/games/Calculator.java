package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.User;

public class Calculator {
    public static void start(User user) {
        Cli.start(user);

        while (Engine.getSuccessAttempts() > 0) {
            Engine.describeGame("What is the result of the expression?");

            int firstValue = Engine.getRandomNumber(Engine.getDefaultRange());
            int secondValue = Engine.getRandomNumber(Engine.getDefaultRange());
            String operation = Engine.getRandomOperation();

            String correctAnswer = Engine.calculate(firstValue, secondValue, operation);

            //Вопрос
            Engine.askQuestion(firstValue, secondValue, operation);

            //Ввод пользователя
            String answer = Engine.getAnswer();

            //Сравнение ответов
            Engine.compareAnswers(user, answer, correctAnswer);

            //Поздравление пользователя, если осталось 0 попыток до победы
            if (Engine.getSuccessAttempts() == 0) {
                Engine.userCongratulation(user);
            }
        }
    }
}
