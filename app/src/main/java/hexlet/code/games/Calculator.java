package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;


public class Calculator {
    private static final String DESCRIPTION_OF_THE_GAME = "What is the result of the expression?";
    private static final String[] QUESTIONS = new String[Util.ATTEMPTS_TO_WIN];
    private static final String[] CORRECT_ANSWERS = new String[Util.ATTEMPTS_TO_WIN];
    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void start() {
        //Подготовка данных
        for (int i = 0; i < Util.ATTEMPTS_TO_WIN; i++) {
            String question = prepareQuestion();
            String correctAnswer = calculate(question);

            QUESTIONS[i] = question;
            CORRECT_ANSWERS[i] = correctAnswer;
        }

        //Старт игры
        Engine.playGame(DESCRIPTION_OF_THE_GAME, QUESTIONS, CORRECT_ANSWERS);
    }


    private static String getRandomOperation() {
        int randomIndex = Util.getRandomNumber(OPERATIONS.length);
        return OPERATIONS[randomIndex];
    }

    private static String prepareQuestion() {
        String firstOperand = Integer.toString(Util.getRandomNumber());
        String secondOperand = Integer.toString(Util.getRandomNumber());
        String operation = getRandomOperation();

        return String.format("%s %s %s", firstOperand, operation, secondOperand);
    }

    private static String calculate(String question) {
        String[] questionByItem = question.split(" ");

        int firstOperand = Integer.parseInt(questionByItem[0]);
        int secondOperand = Integer.parseInt(questionByItem[2]);
        String operation = questionByItem[1];

        switch (operation) {
            case "+" -> {
                return Integer.toString(firstOperand + secondOperand);
            }
            case "-" -> {
                return Integer.toString(firstOperand - secondOperand);
            }
            case "*" -> {
                return Integer.toString(firstOperand * secondOperand);
            }
            default -> {
                return "";
            }
        }
    }

}
