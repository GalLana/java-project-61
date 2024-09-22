package hexlet.code.games;

import hexlet.code.Engine;

public class ArithmeticProgressionGame {

    private static final int MIN_LENGTH = 5; // Минимальная длина прогрессии
    private static final int MAX_LENGTH = 10; // Максимальная длина прогрессии
    private static final int SEED_FOR_FIRST_ELEMENT_GENERATION = 100;
    private static final int SEED_FOR_COMMON_DIFFERENCE_GENERATION = 30;
    private static final String GAME_RULES = "What number is missing in the progression?";

    private static int getCorrectHiddenObject(int firstElem, int hiddenIndex, int difference) {
        return firstElem + hiddenIndex * difference;
    }

    private static int generateCommonDifference(Engine engine) {
        int result = engine.generateGameData(SEED_FOR_COMMON_DIFFERENCE_GENERATION);

        while (result == 0) {
            result = engine.generateGameData(SEED_FOR_COMMON_DIFFERENCE_GENERATION);
        }
        return result;
    }

    private static String generateProgression(int amount, int firstElem, int difference, int hiddenIndex) {
        String result = "";
        for (int i = 0; i < amount; i++) {
            if (i == hiddenIndex) {
                result += "..";
            } else {
                result += (firstElem + i * difference);
            }
            if (i != (amount - 1)) {
                result += " ";
            }
        }

        return result;
    }

    public static void start() {
        Engine engine = new Engine();

        // Генерим данные для игры и сразу вычисляем правильные ответы
        String[] gameData = new String[Engine.ROUNDS_AMOUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_AMOUNT];

        for (int i = 0; i < Engine.ROUNDS_AMOUNT; i++) {
            int progressionLength = engine.generateGameData(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
            int firstElem = engine.generateGameData(SEED_FOR_FIRST_ELEMENT_GENERATION);
            int hiddenIndex = generateMissedPosition(engine, progressionLength);
            int difference = generateCommonDifference(engine);

            gameData[i] = generateProgression(progressionLength, firstElem, difference, hiddenIndex);
            int correctAnswer = getCorrectHiddenObject(firstElem, hiddenIndex, difference);
            correctAnswers[i] = String.valueOf(correctAnswer);
        }
        // Запуск игрового процесса
        engine.playGame(Engine.PROGRESSION, GAME_RULES, gameData, correctAnswers);
    }

    private static int generateMissedPosition(Engine engine, int progressionLength) {
        int result = engine.generateGameData(progressionLength);

        while (result < 1 || result > progressionLength) {
            result = engine.generateGameData(progressionLength);
        }
        return result;
    }
}
