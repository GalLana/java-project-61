package hexlet.code.games;

import hexlet.code.Engine;

public class Greeting {
    private static final String GAME_RULES = "NO_RULES";
    private static String[] gameData = null;
    private static String[] correctAnswers = null;

    public static void start() {
        Engine engine = new Engine();
        engine.playGame(Engine.GREETING, GAME_RULES, gameData, correctAnswers);
    }
}
