package hexlet.code.games;

import hexlet.code.Engine;

public class ArithmeticProgressionGame {

    private static final int MIN_LENGTH = 5; // Минимальная длина прогрессии
    private static final int MAX_LENGTH = 10; // Максимальная длина прогрессии

    public static void start(Engine engine) {

        engine.greetUser();
        engine.explainGame();

        var roundCount = 0;
        int progressionLength;
        int hiddenIndex;
        int difference;
        int correctAnswer;
        int firstElem;
        String expression;


        while (roundCount < Engine.ROUNDS_AMOUNT) {
            progressionLength = engine.generateGameData(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
            firstElem = engine.generateGameData(100);
            hiddenIndex = generateMissedPosition(engine, progressionLength);
            difference = generateCommonDifference(engine);
            correctAnswer = firstElem + hiddenIndex * difference;
            expression = generateProgression(progressionLength, firstElem, difference, hiddenIndex);

            String userAnswer = engine.roundCommunication(expression);
            int answer = Integer.parseInt(userAnswer);

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

    private static int generateMissedPosition(Engine engine, int progressionLength) {
        int result = engine.generateGameData(progressionLength);

        while (result < 1 || result > progressionLength) {
            result = engine.generateGameData(progressionLength);
        }
        return result;
    }

    private static int generateCommonDifference(Engine engine) {
        int result = engine.generateGameData(30);

        while (result == 0) {
            result = engine.generateGameData(30);
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
}
