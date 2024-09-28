package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeGame {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int SEED_FOR_NUMBER_GENERATION = 100;
    private static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static boolean isPrime(int num) {
        // Простые числа должны быть больше 1
        if (num < 1) {
            return false;
        }

        // Проверяем делимость числа на все числа от 2 до числа - 1
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void start() {
        Engine engine = new Engine();

        // Генерим данные для игры и сразу вычисляем правильные ответы
        String[][] gameData = new String[Engine.ROUNDS_AMOUNT][Engine.GAME_DATA_LENGTH];

        for (int i = 0; i < Engine.ROUNDS_AMOUNT; i++) {
            int number = engine.generateGameData(SEED_FOR_NUMBER_GENERATION);

            gameData[i][Engine.QUESTION_POSITION] = String.valueOf(number);
            gameData[i][Engine.ANSWER_POSITION] = isPrime(number) ? YES : NO;
        }
        // Запуск игрового процесса
        engine.playGame(Engine.PRIME, GAME_RULES, gameData);
    }
}
