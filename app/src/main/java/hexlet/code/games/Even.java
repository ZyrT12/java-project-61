package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Even {

    private static final Random RANDOM = new Random();
    private static final int COUNT_ROUNDS = Engine.COUNT_ROUNDS;
    private static final int MAX_RANDOM = 100;

    public static String getGameDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static void startGame() {
        String[][] gameData = new String[COUNT_ROUNDS][2];

        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int number = RANDOM.nextInt(MAX_RANDOM);
            String question = Integer.toString(number);
            String correctAnswer = (number % 2 == 0) ? "yes" : "no";

            gameData[i][0] = question;
            gameData[i][1] = correctAnswer;
        }

        Engine.startGame(getGameDescription(), gameData);
    }
}
