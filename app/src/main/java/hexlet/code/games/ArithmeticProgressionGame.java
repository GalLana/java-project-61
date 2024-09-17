package hexlet.code.games;

import hexlet.code.Engine;

public class ArithmeticProgressionGame {

    public static void start(Engine engine) {
        engine.greetUser();
        engine.explainGame();

        var roundCount = 0;
        int minProgressionLength = 5;
        int maxProgressionLength = 10;
        int numsAmount;
        int missedPosition;
        int commonDifference;
        int correctAnswer;
        int firstElem;
        String expression;


        while (roundCount < Engine.ROUNDS_AMOUNT) {
            numsAmount = engine.generateGameData(maxProgressionLength - minProgressionLength) + minProgressionLength;
            firstElem = engine.generateGameData(100);
            missedPosition = generateMissedPosition(engine, numsAmount);
            commonDifference = generateCommonDifference(engine);
            correctAnswer = firstElem + (missedPosition - 1) * commonDifference;
            expression = generateProgression(numsAmount, firstElem, commonDifference, missedPosition);

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

    private static String generateProgression(int amount, int firstElem, int commonDifference, int missedPosition) {
        String result = "";
        for (int i = 1; i <= amount; i++) {
            if (i == missedPosition) {
                result += "..";
            } else {
                result += (firstElem + (i - 1) * commonDifference);
            }
            if (i != amount) {
                result += " ";
            }
        }

        return result;
    }
}
