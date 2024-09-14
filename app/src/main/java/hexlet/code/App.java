package hexlet.code;


import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вывод списка игр
        chooseGames();

        // Чтение выбора пользователя
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Обработка выбора пользователя
        switch (choice) {
            case 0:
                // Выход из программы
                System.out.println("Goodbye!");
                break;
            case 1:
                // Запуск игры Greet
                Greeting.start(new Engine(Engine.GREETING, scanner));
                break;
            case 2:
                // Запуск игры Even
                EvenGame.start(new Engine(Engine.EVEN, scanner));
                break;
            case 3:
                // Запуск игры Calculator
                Calculator.start(new Engine(Engine.CALC, scanner));
                break;
            case 4:
                // Запуск игры GCD
                GCD.start(new Engine(Engine.GCD, scanner));
                break;
            case 5:
                // Запуск игры Progression
                ArithmeticProgressionGame.start(new Engine(Engine.PROGRESSION, scanner));
                break;
            case 6:
                // Запуск игры Prime
                PrimeGame.start(new Engine(Engine.PRIME, scanner));
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
