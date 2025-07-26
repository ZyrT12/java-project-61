package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {

    private static final Random RANDOM = new Random();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void startGame() {
        String description = "Find the greatest common divisor of given numbers.";
        String[][] gameData = new String[Engine.COUNT_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int num1 = getRandomNumber();
            int num2 = getRandomNumber();
            String question = num1 + " " + num2;
            String answer = String.valueOf(findGCD(num1, num2));

            gameData[i][0] = question;
            gameData[i][1] = answer;
        }

        Engine.startGame(description, gameData);
    }

    private static int getRandomNumber() {
        return RANDOM.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
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
