package hexlet.code.games;

import hexlet.code.Engine;

public class Calculator {
    private static final String ADDITION = " + ";
    private static final String MINUS = " - ";
    private static final String MULTIPLY = " * ";

    private static final int SEED_FOR_FIRST_NUMBER_GENERATION = 30;
    private static final int SEED_FOR_SECOND_NUMBER_GENERATION = 35;
    private static final int SEED_FOR_OPERATION_GENERATION = 3;


    public static void start(Engine engine) {
        engine.greetUser();
        engine.explainGame();
        var roundCount = 0;
        int number1;
        int number2;
        int operation;

        int correctAnswer = 0;
        String expression = "";

        while (roundCount < Engine.ROUNDS_AMOUNT) {
            number1 = engine.generateGameData(SEED_FOR_FIRST_NUMBER_GENERATION);
            number2 = engine.generateGameData(SEED_FOR_SECOND_NUMBER_GENERATION);
            operation = engine.generateGameData(SEED_FOR_OPERATION_GENERATION);

            switch (operation) {
                case 0:
                    correctAnswer = number1 + number2;
                    expression = number1 + ADDITION + number2;
                    break;
                case 1:
                    correctAnswer = number1 - number2;
                    expression = number1 + MINUS + number2;
                    break;
                case 2:
                    correctAnswer = number1 * number2;
                    expression = number1 + MULTIPLY + number2;
                    break;
                default:
                    System.out.println("No such operation");
            }

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
