package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 20;
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void startGame() {
        String description = "What is the result of the expression?";
        String[][] gameData = new String[Engine.COUNT_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int num1 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);
            int num2 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);
            String operator = getRandomOperator();
            String question = num1 + " " + operator + " " + num2;
            String answer = String.valueOf(calculate(num1, num2, operator));

            gameData[i][0] = question;
            gameData[i][1] = answer;
        }

        Engine.startGame(description, gameData);
    }

    private static String getRandomOperator() {
        int index = Utils.generateNumber(0, OPERATORS.length - 1);
        return OPERATORS[index];
    }

    private static int calculate(int a, int b, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                throw new IllegalStateException("Unexpected operator: " + operator);
        }
        return result;
    }
}
