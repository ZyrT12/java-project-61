package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int COUNT_ROUNDS = 3;

    public static void startGame(String condition, String[][] allGameParams) {
        System.out.println("\nWelcome to the Brain games!");
        System.out.print("May I have your name? ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(condition);

        int round = 0;
        for (String[] questionAndAnswer : allGameParams) {
            if (round >= COUNT_ROUNDS) {
                break;
            }
            String question = questionAndAnswer[0];
            String correctAnswer = questionAndAnswer[1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = in.nextLine();

            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.\nLet's try again, " + name + "!");
                in.close();
                return;
            }
            round++;
        }

        System.out.println("Congratulations, " + name + "!");
        in.close();
    }
}
