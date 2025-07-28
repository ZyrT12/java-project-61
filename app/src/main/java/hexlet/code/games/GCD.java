package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void startGame() {
        String description = "Find the greatest common divisor of given numbers.";
        String[][] gameData = new String[Engine.COUNT_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int num1 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);
            int num2 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);
            String question = num1 + " " + num2;
            String answer = String.valueOf(findGCD(num1, num2));

            gameData[i][0] = question;
            gameData[i][1] = answer;
        }

        Engine.startGame(description, gameData);
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
