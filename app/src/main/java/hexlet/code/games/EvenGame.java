package hexlet.code.games;

import hexlet.code.Engine;


public class EvenGame {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void start(Engine engine) {
        engine.greetUser();
        engine.explainGame();
        var roundCount = 0;

        while (roundCount < 3) {
            int number = engine.generateGameData(100);
            boolean isEven = number % 2 == 0;
            String correctAnswer = isEven ? YES : NO;

            String answer = engine.roundCommunication(String.valueOf(number));

            if (answer.equals(correctAnswer)) {
                roundCount++;
            } else {
                engine.gameFailed(answer, correctAnswer);
                return;
            }
        }
        engine.gameSuccessful();
    }


}
