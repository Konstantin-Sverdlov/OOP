package lab2;

class Employee {
    private String fullName;
    private String position;
    private double baseSalary;
    private double bonus;

    public Employee(String fullName, String position, double baseSalary) {
        this.fullName = fullName;
        this.position = position;
        this.baseSalary = baseSalary;
        this.bonus = 0.0;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    public void displayInfo() {
        System.out.printf("Робітник: %-26s | Посада: %-22s | Оклад: %8.2f грн | Премія: %7.2f грн | Разом: %8.2f грн%n",
                fullName, position, baseSalary, bonus, calculateTotalSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрація роботи з даними робітників ===\n");

        Employee emp1 = new Employee("Іваненко Петро Олексійович", "Інженер-програміст", 45000.0);
        Employee emp2 = new Employee("Коваленко Марія Сергіївна", "Тестувальник ПЗ", 35000.0);
        Employee emp3 = new Employee("Сидоренко Олег Васильович", "Системний адміністратор", 30000.0);

        emp1.setBonus(5000.0);
        emp2.setBonus(4200.0);
        emp3.setBonus(2500.0);

        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();

        double totalFund = emp1.calculateTotalSalary() + emp2.calculateTotalSalary() + emp3.calculateTotalSalary();
        System.out.printf("\nЗагальний фонд нарахування зарплати: %.2f грн%n", totalFund);
    }
}