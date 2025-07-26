package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {

    private static final Random RANDOM = new Random();
    private static final int MIN_START = 1;
    private static final int MAX_START = 50;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    public static void startGame() {
        String description = "What number is missing in the progression?";
        String[][] gameData = new String[Engine.COUNT_ROUNDS][2];

        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int start = getRandomNumber(MIN_START, MAX_START);
            int step = getRandomNumber(MIN_STEP, MAX_STEP);
            int length = getRandomNumber(MIN_LENGTH, MAX_LENGTH);
            int hiddenIndex = RANDOM.nextInt(length);

            int[] progression = generateProgression(start, step, length);
            String correctAnswer = Integer.toString(progression[hiddenIndex]);
            StringBuilder questionBuilder = new StringBuilder();

            for (int j = 0; j < length; j++) {
                if (j == hiddenIndex) {
                    questionBuilder.append(".. ");
                } else {
                    questionBuilder.append(progression[j]).append(" ");
                }
            }

            gameData[i][0] = questionBuilder.toString().trim();
            gameData[i][1] = correctAnswer;
        }

        Engine.startGame(description, gameData);
    }

    private static int[] generateProgression(int start, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }

    private static int getRandomNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
