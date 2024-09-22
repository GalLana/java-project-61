package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final int SEED_FOR_FIRST_NUMBER_GENERATION = 30;
    private static final int SEED_FOR_SECOND_NUMBER_GENERATION = 35;
    private static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    private static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static void start() {
        Engine engine = new Engine();

        // Генерим данные для игры и сразу вычисляем правильные ответы
        String[] gameData = new String[Engine.ROUNDS_AMOUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_AMOUNT];

        for (int i = 0; i < Engine.ROUNDS_AMOUNT; i++) {
            int number1 = engine.generateGameData(SEED_FOR_FIRST_NUMBER_GENERATION);
            int number2 = engine.generateGameData(SEED_FOR_SECOND_NUMBER_GENERATION);

            gameData[i] = number1 + " " + number2;
            int correctAnswer = gcd(number1, number2);
            correctAnswers[i] = String.valueOf(correctAnswer);
        }
        // Запуск игрового процесса
        engine.playGame(Engine.GCD, GAME_RULES, gameData, correctAnswers);
    }
}
