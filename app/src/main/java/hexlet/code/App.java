package hexlet.code;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");

        //Пользователь вводит имя и происходит его приветствие
        Cli.getUserNameAndGreeting(scanner);
    }
}
