import java.util.Scanner;

public class Main {
    static int grado = 0;
    static double[] coeficientes;
    static double a = 0.0;
    static double b = 0.0;
    static double erpMax = 0.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Proporcione el grado de la ecuación: ");
        grado = sc.nextInt();
        coeficientes = new double[grado + 1];

        for (int i = 0; i <= grado; i++) {
            if ((grado - i) != 0) {
                System.out.print("Ingrese el coeficiente de x^" + (grado - i) + ": ");
            } else {
                System.out.print("Ingrese el término independiente: ");
            }
            coeficientes[i] = sc.nextDouble();
        }

        System.out.print("Ingrese el valor de a: ");
        a = sc.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        b = sc.nextDouble();
        System.out.print("Ingrese el valor máximo de error (Erp): ");
        erpMax = sc.nextDouble();

        int iteracion = 1;
        double x;
        double erp;

        System.out.println("\ni   a       (a+b)/2        b       f(a)       f((a+b)/2)       f(b)       erp");

        do {
            x = (a + b) / 2;
            erp = Math.abs((b - a) / 2);

            System.out.printf("%d   %.5f   %.5f   %.5f   %.5f   %.5f   %.5f   %.5f%n", iteracion, a, x, b, f(a), f(x), f(b), erp);

            if (f(a) * f(x) < 0) {
                b = x;
            } else {
                a = x;
            }

            iteracion++;
        } while (erp > erpMax);

        System.out.println("\nResultado aproximado: x = " + x);
    }

    public static double f(double x) {
        double f_x = 0.0;
        for (int i = 0; i <= grado; i++) {
            f_x += coeficientes[i] * Math.pow(x, grado - i);
        }
        return f_x;
    }
}
