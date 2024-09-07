package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static final String GREETING = "GREETING";
    public static final String EVEN = "EVEN";
    public static final String CALC = "CALCULATOR";

    public static final String ROUNDS_AMOUBT

    private final String game;
    private String userName;
    private final Scanner scanner;

    public Engine(String game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }

    //public Scanner getScanner() {return scanner;}

    //public String getGame() {return game;}

    //public String getUserName() {return this.userName;}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void greetUser() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        setUserName(this.scanner.nextLine().trim());
        System.out.println("Hello, " + this.userName + "!");
    }

    public void explainGame() {
        switch (this.game) {
            case EVEN:
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                break;
            case CALC:
                System.out.println("What is the result of the expression?");
                break;
            default:
                break;
        }
    }

    public void gameSuccessful() {
        System.out.println("Congratulations, " + this.userName + "!");
    }

    public void gameFailed(String wrongAnswer, String correctAnswer) {
        System.out.println("'" + wrongAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.\nLet's try again, " + this.userName + "!");
    }

    public int generateGameData(int seed) {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(seed);
    }

    public String roundCommunication(String expression) {
        System.out.print("Question: " + expression + "\nYour answer: ");
        return this.scanner.nextLine().trim().toLowerCase();
    }
}
