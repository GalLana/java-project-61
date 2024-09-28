package hexlet.code.games;

import hexlet.code.Engine;


public class EvenGame {
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int SEED_FOR_NUMBER_GENERATION = 100;
    private static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void start() {
        Engine engine = new Engine();
        // Генерим данные для игры и сразу вычисляем правильные ответы
        String[][] gameData = new String[Engine.ROUNDS_AMOUNT][Engine.GAME_DATA_LENGTH];

        for (int i = 0; i < Engine.ROUNDS_AMOUNT; i++) {
            int number = engine.generateGameData(SEED_FOR_NUMBER_GENERATION);
            gameData[i][Engine.QUESTION_POSITION] = String.valueOf(number);
            gameData[i][Engine.ANSWER_POSITION] = isEven(number) ? YES : NO;
        }
        // Запуск игрового процесса
        engine.playGame(Engine.EVEN, GAME_RULES, gameData);
    }


}
