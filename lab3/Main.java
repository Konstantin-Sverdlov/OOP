package lab3;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private final String name;
    private final String group;
    private final double averageGrade;

    public Student(String name, String group, double averageGrade) {
        this.name = name;
        this.group = group;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void display() {
        System.out.printf("Студент: %-15s | Група: %-8s | Середній бал: %.2f%n", name, group, averageGrade);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (true) {
            System.out.println("\nОберіть опцію (Лабораторна 3):");
            System.out.println("1. Внести дані про нового студента");
            System.out.println("2. Відобразити список усіх студентів");
            System.out.println("3. Сформувати список студентів із балом вище заданого");
            System.out.println("4. Знайти найуспішнішого студента");
            System.out.println("5. Повернутися до головного меню");
            System.out.print("Ваш вибір: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Введіть прізвище студента: ");
                    String name = scanner.next();
                    System.out.print("Введіть шифр групи (наприклад, ІПЗ-21): ");
                    String group = scanner.next();
                    System.out.print("Введіть середній бал (наприклад, 92,5): ");
                    double grade = scanner.nextDouble();

                    students.add(new Student(name, group, grade));
                    System.out.println("Дані про студента успішно додано.");
                }
                case 2 -> {
                    if (students.isEmpty()) {
                        System.out.println("Список студентів порожній.");
                    } else {
                        System.out.println("\n--- Загальний список студентів ---");
                        for (Student s : students) {
                            s.display();
                        }
                    }
                }
                case 3 -> {
                    if (students.isEmpty()) {
                        System.out.println("Список студентів порожній.");
                    } else {
                        System.out.print("Введіть мінімальний прохідний бал для формування списку: ");
                        double minGrade = scanner.nextDouble();
                        System.out.println("\n--- Список студентів із балом від " + minGrade + " ---");
                        boolean found = false;
                        for (Student s : students) {
                            if (s.getAverageGrade() >= minGrade) {
                                s.display();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Студентів із таким балом не знайдено.");
                        }
                    }
                }
                case 4 -> {
                    if (students.isEmpty()) {
                        System.out.println("Немає жодного студента в базі даних.");
                    } else {
                        Student bestStudent = students.get(0);
                        for (Student s : students) {
                            if (s.getAverageGrade() > bestStudent.getAverageGrade()) {
                                bestStudent = s;
                            }
                        }
                        System.out.println("\nНайуспішніший студент:");
                        bestStudent.display();
                    }
                }
                case 5 -> {
                    System.out.println("Вихід із лабораторної роботи 3...\n");
                    return;
                }
                default -> System.out.println("Неправильний вибір опції. Будь ласка, спробуйте знову.");
            }
        }
    }
}