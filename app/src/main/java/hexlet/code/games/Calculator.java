package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.User;

public class Calculator {
    public static void start(User user) {
        new Engine(user);

        while (Engine.getSuccessAttempts() > 0) {
            Engine.describeGame("What is the result of the expression?");

            int firstValue = Engine.getRandomNumber(101);
            int secondValue = Engine.getRandomNumber(101);
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
