package hexlet.code.games;

import hexlet.code.Engine;

public class Calculator {
    private static final String addition = " + ";
    private static final String minus = " - ";
    private static final String multiply = " * ";


    public static void start(Engine engine) {
        engine.greetUser();
        engine.explainGame();
        var roundCount = 0;
        int number1, number2, operation;
        int correctAnswer = 0;
        String expression = "";
        while (roundCount < Engine.ROUNDS_AMOUNT) {
            number1 = engine.generateGameData(30);
            number2 = engine.generateGameData(35);
            operation = engine.generateGameData(3);

            switch (operation) {
                case 0:
                    correctAnswer = number1 + number2;
                    expression = number1 + addition + number2;
                    break;
                case 1:
                    correctAnswer = number1 - number2;
                    expression = number1 + minus + number2;
                    break;
                case 2:
                    correctAnswer = number1 * number2;
                    expression = number1 + multiply + number2;
                    break;
                default:
                    System.out.println("No such operation");
            }

            String a = engine.roundCommunication(expression);
            int answer = Integer.parseInt(a);
            if (answer == correctAnswer) {
                roundCount++;
            } else {
                engine.gameFailed(String.valueOf(answer), String.valueOf(correctAnswer));
                return;
            }
        }
        engine.gameSuccessful();
    }
}
