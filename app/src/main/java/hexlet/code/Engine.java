package hexlet.code;

public final class Engine {
    private Engine() {
    }

    public static void playGame(String descriptionOfTheGame, String[] questions, String[] correctAnswers) {
        Cli.start();

        for (int i = 0; i < Util.ATTEMPTS_TO_WIN; i++) {
            //Вывод описания игры
            Util.describeGame(descriptionOfTheGame);

            //Вывод вопроса
            Util.askQuestion(questions[i]);

            //Получаю ответ пользователя
            String answer = Util.getAnswer();

            Util.compareAnswers(answer, correctAnswers[i]);
        }

        Util.userCongratulation();
    }
}
