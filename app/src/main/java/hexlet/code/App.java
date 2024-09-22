package hexlet.code;


import hexlet.code.games.ArithmeticProgressionGame;
import hexlet.code.games.Calculator;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCD;
import hexlet.code.games.Greeting;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class App {
    private static final int EXIT = 0;
    private static final int GREETING_GAME = 1;
    private static final int EVEN_NUMBER_GAME = 2;
    private static final int CALCULATOR_GAME = 3;
    private static final int GCD_GAME = 4;
    private static final int ARITHMETIC_PROGRESSION_GAME = 5;
    private static final int PRIME_NUMBER_GAME = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вывод списка игр
        chooseGames();

        // Чтение выбора пользователя
        int choice = scanner.nextInt();
        scanner.nextLine();
        // Обработка выбора пользователя
        switch (choice) {
            case EXIT:
                // Выход из программы
                System.out.println("Goodbye!");
                break;
            case GREETING_GAME:
                // Запуск игры Greet
                Greeting.start();
                break;
            case EVEN_NUMBER_GAME:
                // Запуск игры Even
                EvenGame.start();
                break;
            case CALCULATOR_GAME:
                // Запуск игры Calculator
                Calculator.start();
                break;
            case GCD_GAME:
                // Запуск игры GCD
                GCD.start();
                break;
            case ARITHMETIC_PROGRESSION_GAME:
                // Запуск игры Progression
                ArithmeticProgressionGame.start();
                break;
            case PRIME_NUMBER_GAME:
                // Запуск игры Prime
                PrimeGame.start();
                break;
            default:
                // Сообщение об ошибке при неверном вводе
                System.out.println("Invalid choice. Please try again.");
        }
        scanner.close();
    }

    public static void chooseGames() {
        System.out.println("Please enter the game number and press Enter:");
        System.out.println(GREETING_GAME + " - Greet");
        System.out.println(EVEN_NUMBER_GAME + " - Even");
        System.out.println(CALCULATOR_GAME + " - Calc");
        System.out.println(GCD_GAME + " - GCD");
        System.out.println(ARITHMETIC_PROGRESSION_GAME + " - Progression");
        System.out.println(PRIME_NUMBER_GAME + " - Prime");
        System.out.println(EXIT + " - Exit");
        System.out.print("Your choice: ");
    }

}
