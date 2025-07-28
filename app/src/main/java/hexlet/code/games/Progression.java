package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {

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
            int start = Utils.generateNumber(MIN_START, MAX_START);
            int step = Utils.generateNumber(MIN_STEP, MAX_STEP);
            int length = Utils.generateNumber(MIN_LENGTH, MAX_LENGTH);
            int hiddenIndex = Utils.generateNumber(0, length - 1);

            int[] progression = generateProgression(start, step, length);
            String[] progressionStr = convertToStringArray(progression);

            String correctAnswer = progressionStr[hiddenIndex];
            progressionStr[hiddenIndex] = "..";

            String question = String.join(" ", progressionStr);

            gameData[i][0] = question;
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

    private static String[] convertToStringArray(int[] numbers) {
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.toString(numbers[i]);
        }
        return result;
    }
}
