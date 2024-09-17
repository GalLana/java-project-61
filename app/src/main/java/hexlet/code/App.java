package hexlet.code;


import hexlet.code.games.ArithmeticProgressionGame;
import hexlet.code.games.Calculator;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCD;
import hexlet.code.games.Greeting;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вывод списка игр
        chooseGames();

        // Чтение выбора пользователя
        int choice = scanner.nextInt();
        scanner.nextLine();
        // Класс с общими методами для всех игр
        Engine engine = new Engine();
        engine.setScanner(scanner);
        // Обработка выбора пользователя
        switch (choice) {
            case 0:
                // Выход из программы
                System.out.println("Goodbye!");
                break;
            case 1:
                // Запуск игры Greet
                engine.setGame(Engine.GREETING);
                Greeting.start(engine);
                break;
            case 2:
                // Запуск игры Even
                engine.setGame(Engine.EVEN);
                EvenGame.start(engine);
                break;
            case 3:
                // Запуск игры Calculator
                engine.setGame(Engine.CALC);
                Calculator.start(engine);
                break;
            case 4:
                // Запуск игры GCD
                engine.setGame(Engine.GCD);
                GCD.start(engine);
                break;
            case 5:
                // Запуск игры Progression
                engine.setGame(Engine.PROGRESSION);
                ArithmeticProgressionGame.start(engine);
                break;
            case 6:
                // Запуск игры Prime
                engine.setGame(Engine.PRIME);
                PrimeGame.start(engine);
                break;
            default:
                // Сообщение об ошибке при неверном вводе
                System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }

    public static void chooseGames() {
        System.out.println("Please enter the game number and press Enter:");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

}
