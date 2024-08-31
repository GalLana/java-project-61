package hexlet.code;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Вывод списка игр
        System.out.println("Please enter the game number and press Enter:");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        // Чтение выбора пользователя
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Обработка выбора пользователя
        switch (choice) {
            case 0:
                // Выход из программы
                System.out.println("Goodbye!");
                scanner.close();
                return;
            case 1:
                // Запуск игры Greet
                Greeting.start();
                break;
            case 2:
                // Запуск игры Even
                EvenGame.start();
                break;
            default:
                // Сообщение об ошибке при неверном вводе
                System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }

}
