package hexlet.code;

import java.util.Scanner;

public class Greeting {
    public static void start() {
        welcomeGames();
        User user = getUser();
        sayHello(user.getUserName());
    }

    public static User greetAndReturmUser() {
        welcomeGames();
        User user = getUser();
        sayHello(user.getUserName());
        return user;
    }

    public static void welcomeGames() {
        System.out.println("Welcome to the Brain Games!");
    }

    public static User getUser() {
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine().trim();
        User user = new User(userName);
        return  user;
    }

    public static void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
