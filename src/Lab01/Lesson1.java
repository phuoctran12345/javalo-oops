package Lab01;

public class Lesson1 {
    public static String ptb2(double a, double b, double c) {
        if (a == 0) {
            return "Not a quadratic equation.";
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                return "The equation has 2 solutions: x1 = " + x1 + ", x2 = " + x2;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                return "The equation has a double solution: x1 = x2 = " + x;
            } else {
                return "The equation has no solution.";
            }
        }
    }
}
