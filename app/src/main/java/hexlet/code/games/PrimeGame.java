package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeGame {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int SEED_FOR_NUMBER_GENERATION = 100;
    private static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static String isPrime(int num) {
        // Простые числа должны быть больше 1
        if (num < 1) {
            return NO;
        }

        // Проверяем делимость числа на все числа от 2 до числа - 1
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return NO;
            }
        }
        return YES;
    }

    public static void start() {
        Engine engine = new Engine();

        // Генерим данные для игры и сразу вычисляем правильные ответы
        String[] gameData = new String[Engine.ROUNDS_AMOUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_AMOUNT];

        for (int i = 0; i < Engine.ROUNDS_AMOUNT; i++) {
            int number = engine.generateGameData(SEED_FOR_NUMBER_GENERATION);

            gameData[i] = String.valueOf(number);
            correctAnswers[i] = isPrime(number);
        }
        // Запуск игрового процесса
        engine.playGame(Engine.PRIME, GAME_RULES, gameData, correctAnswers);
    }
}
