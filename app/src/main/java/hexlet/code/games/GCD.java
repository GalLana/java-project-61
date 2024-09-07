package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static void start(Engine engine) {
        engine.greetUser();
        engine.explainGame();

        var roundCount = 0;
        int number1;
        int number2;
        int correctAnswer;
        String expression;

        while (roundCount < Engine.ROUNDS_AMOUNT) {
            number1 = engine.generateGameData(30);
            number2 = engine.generateGameData(35);
            expression = number1 + " " + number2;

            correctAnswer = gcd(number1, number2);

            String a = engine.roundCommunication(expression);
            int answer = Integer.parseInt(a);
            if (answer == correctAnswer) {
                roundCount++;
                engine.roundSuccessful();
            } else {
                engine.gameFailed(String.valueOf(answer), String.valueOf(correctAnswer));
                return;
            }
        }
        engine.gameSuccessful();
    }
}
