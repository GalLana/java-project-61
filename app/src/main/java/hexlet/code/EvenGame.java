package hexlet.code;

import java.util.Random;
import java.util.Scanner;


public class EvenGame {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void start() {
        User user = Greeting.greetAndReturmUser();
        showRules();
        var correctAnswers = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        while (correctAnswers < 3) {
            int number = random.nextInt(1001);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().trim().toLowerCase();
            boolean isEven = number % 2 == 0;
            String correctAnswer = isEven ? YES : NO;

            if (answer.equals(correctAnswer)) {
                correctAnswers++;
            } else {
                gameFailed(answer, user);
                return;
            }
        }
        gameSuccessful(user);
    }

    private static void showRules() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private static void gameFailed(String wrongAnswer, User user) {
        String correctAnswer = YES.equals(wrongAnswer) ? NO : YES;
        System.out.println("'" + wrongAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + user.getUserName() + "!");
    }

    private static void gameSuccessful(User user) {
        System.out.println("Congratulations, " + user.getUserName() + "!");
    }
}
