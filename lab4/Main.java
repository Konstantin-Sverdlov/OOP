package lab4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (true) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Лабораторна робота 1");
            System.out.println("2. Лабораторна робота 2");
            System.out.println("3. Лабораторна робота 3");
            System.out.println("4. Вийти");
            System.out.print("Ваш вибір: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> lab1.Main.main(args);
                case 2 -> lab2.Main.main(args);
                case 3 -> lab3.Main.main(args);
                case 4 -> {
                    System.out.println("Програма завершена.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Неправильний вибір опції. Будь ласка, спробуйте знову.");
            }
        }
    }
}