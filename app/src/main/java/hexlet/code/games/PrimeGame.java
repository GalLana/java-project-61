package hexlet.code.games;

import hexlet.code.Engine;

public class PrimeGame {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static  void start(Engine engine) {
        engine.greetUser();
        engine.explainGame();
        var roundCount = 0;
        int number;
        while (roundCount < Engine.ROUNDS_AMOUNT) {
            number = engine.generateGameData(100);
            String correctAnswer = isPrime(number);

            String answer = engine.roundCommunication(String.valueOf(number));
            if (answer.equals(correctAnswer)) {
                roundCount++;
                engine.roundSuccessful();
            } else {
                engine.gameFailed(answer, correctAnswer);
                return;
            }
        }
        engine.gameSuccessful();
    }

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
}
