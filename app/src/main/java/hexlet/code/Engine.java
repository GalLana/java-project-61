package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public final class Engine {
    public static final String GREETING = "GREETING";
    public static final String EVEN = "EVEN";
    public static final String CALC = "CALCULATOR";
    public static final String GCD = "GCD";
    public static final String PROGRESSION = "PROGRESSION";
    public static final String PRIME = "PRIME";

    public static final int ROUNDS_AMOUNT = 3;
    public static final int QUESTION_POSITION = 0;
    public static final int ANSWER_POSITION = 1;
    public static final int GAME_DATA_LENGTH = 2;

    private String userName;
    private Scanner scanner = new Scanner(System.in);

    public void gameFailed(String wrongAnswer, String correctAnswer) {
        System.out.println("'" + wrongAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.\nLet's try again, " + this.userName + "!");
    }

    public int generateGameData(int seed) {
        Random random = new Random(System.nanoTime());
        int k = random.nextInt(seed);
        return k;
    }

    public String roundCommunication(String expression) {
        System.out.print("Question: " + expression + "\nYour answer: ");
        return this.scanner.nextLine().trim().toLowerCase();
    }

    private void greetUser() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        this.userName = scanner.nextLine().trim();
        System.out.println("Hello, " + this.userName + "!");
    }

    public void playGame(String game, String gameRules, String[][] gameData) {
        greetUser();

        if (!GREETING.equals(game)) {
            System.out.println(gameRules);
            for (int round = 0; round < ROUNDS_AMOUNT; round++) {

                String userAnswer = roundCommunication(gameData[round][QUESTION_POSITION]);

                if (userAnswer.equals(gameData[round][ANSWER_POSITION])) {
                    System.out.println("Correct!");
                } else {
                    gameFailed(userAnswer, gameData[round][ANSWER_POSITION]);
                    return;
                }
            }
            System.out.println("Congratulations, " + this.userName + "!");
        }

        this.scanner.close();
    }
}
