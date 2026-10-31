package lab1;

class BisectionSolver {

    public double f(double x) {
        return 2 * x + 3;
    }

    public void solve(double a, double b, double eps) {
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
        System.out.printf("Значення y(x) = %.2f%n%n", f(c));
    }
}

public class Main {
    public static void main(String[] args) {
        BisectionSolver solver = new BisectionSolver();
        solver.solve(-1000.0, 1000.0, 0.01);
    }
}