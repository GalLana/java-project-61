package hexlet.code.games;

import hexlet.code.Engine;

public class Calculator {
    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static final String GAME_RULES = "What is the result of the expression?";
    private static final int SEED_FOR_FIRST_NUMBER_GENERATION = 30;
    private static final int SEED_FOR_SECOND_NUMBER_GENERATION = 35;
    private static final int SEED_FOR_OPERATION_GENERATION = 3;

    private static int getCorrectOperationResult(int number1, int number2, int operation) {
        int result = 0;

        switch (operation) {
            case 0:
                result = number1 + number2;
                break;
            case 1:
                result = number1 - number2;
                break;
            case 2:
                result = number1 * number2;
                break;
            default:
                System.out.println("No such operation");
        }
        return result;
    }

    public static void start() {
        Engine engine = new Engine();

        // Генерим данные для игры и сразу вычисляем правильные ответы
        String[] gameData = new String[Engine.ROUNDS_AMOUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_AMOUNT];

        for (int i = 0; i < Engine.ROUNDS_AMOUNT; i++) {
            int number1 = engine.generateGameData(SEED_FOR_FIRST_NUMBER_GENERATION);
            int number2 = engine.generateGameData(SEED_FOR_SECOND_NUMBER_GENERATION);
            int operation = engine.generateGameData(SEED_FOR_OPERATION_GENERATION);

            gameData[i] = number1 + OPERATIONS[operation] + number2;
            int correctAnswer = getCorrectOperationResult(number1, number2, operation);
            correctAnswers[i] = String.valueOf(correctAnswer);
        }
        // Запуск игрового процесса
        engine.playGame(Engine.CALC, GAME_RULES, gameData, correctAnswers);
    }
}
