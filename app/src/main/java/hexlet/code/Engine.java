package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int COUNT_ROUNDS = 3;
    public static void startGame(String condition, String[][] allGameParams) {
        String answer;
        System.out.println("\nWelcome to the Brain games!");
        System.out.print("May I have your name? ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");

        System.out.println(condition);
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            System.out.println("Question: " + allGameParams[i][0]);
            System.out.print("Your answer: ");
            answer = in.nextLine();
            if (allGameParams[i][1].equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + allGameParams[i][1] + "'.\nLet's try again, " + name + "!");
                in.close();
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
