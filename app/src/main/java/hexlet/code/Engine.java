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

    private String userName;
    private Scanner scanner = new Scanner(System.in);

    public void gameSuccessful() {
        System.out.println("Congratulations, " + this.userName + "!");
    }
    public void roundSuccessful() {
        System.out.println("Correct!");
    }
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

    public void playGame(String game, String gameRules, String[] gameData, String[] correctAnswers) {
        greetUser();

        if (!GREETING.equals(game)) {
            System.out.println(gameRules);
            for (int round = 0; round < ROUNDS_AMOUNT; round++) {

                String userAnswer = roundCommunication(gameData[round]);

                if (userAnswer.equals(correctAnswers[round])) {
                    roundSuccessful();
                } else {
                    gameFailed(userAnswer, correctAnswers[round]);
                    return;
                }
            }
            gameSuccessful();
        }

        this.scanner.close();
    }
}
