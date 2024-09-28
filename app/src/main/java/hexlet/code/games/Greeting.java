package hexlet.code.games;

import hexlet.code.Engine;

public class Greeting {
    private static final String GAME_RULES = "NO_RULES";
    private static final String[][] GAME_DATA = null;

    public static void start() {
        Engine engine = new Engine();
        engine.playGame(Engine.GREETING, GAME_RULES, GAME_DATA);
    }
}
