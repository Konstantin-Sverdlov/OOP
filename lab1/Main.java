package lab1;

public class Main {

    public static double f(double x) {
        return 2 * x + 3;
    }

    public static void main(String[] args) {
        double a = -1000.0;
        double b = 1000.0;
        double eps = 0.01;

        if (f(a) * f(b) > 0) {
            System.out.println("На заданому відрізку функція не змінює знак.");
            return;
        }

        double c;
        while ((b - a) / 2.0 > eps) {
            c = (a + b) / 2.0;

            if (f(c) == 0.0) {
                break;
            } else if (f(a) * f(c) < 0) {
                b = c;
            } else {
                a = c;
            }
        }

        c = (a + b) / 2.0;
        System.out.printf("Наближений розв'язок x = %.2f%n", c);
        System.out.printf("Значення y(x) = %.2f%n", f(c));
    }
}
