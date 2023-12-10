package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;


public class Calculator {
    private static final String DESCRIPTION_OF_THE_GAME = "What is the result of the expression?";
    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void start() {
        String[][] questionsAndAnswers = new String[Engine.ATTEMPTS_TO_WIN][2];

        for (int i = 0; i < Engine.ATTEMPTS_TO_WIN; i++) {
            int firstOperand = Util.getRandomNumber();
            int secondOperand = Util.getRandomNumber();
            int randomIndex = Util.getRandomNumber(OPERATIONS.length);
            String operation = OPERATIONS[randomIndex];
            String question = String.format("%s %s %s", firstOperand, operation, secondOperand);
            String correctAnswer = Integer.toString(calculate(firstOperand, secondOperand, operation));
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.playGame(DESCRIPTION_OF_THE_GAME, questionsAndAnswers);
    }

    private static int calculate(int firstOperand, int secondOperand, String operation) {
        switch (operation) {
            case "+" -> {
                return firstOperand + secondOperand;
            }
            case "-" -> {
                return firstOperand - secondOperand;
            }
            case "*" -> {
                return firstOperand * secondOperand;
            }
            default -> {
                return 0;
            }
        }
    }

}
