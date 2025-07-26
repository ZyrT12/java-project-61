package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {

    private static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100;

    public static void startGame() {
        String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] gameData = new String[Engine.COUNT_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int number = RANDOM.nextInt(MAX_NUMBER) + 1;
            String question = Integer.toString(number);
            String correctAnswer = isPrime(number) ? "yes" : "no";

            gameData[i][0] = question;
            gameData[i][1] = correctAnswer;
        }

        Engine.startGame(description, gameData);
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
