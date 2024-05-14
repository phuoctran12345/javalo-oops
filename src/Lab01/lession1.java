package Lab01;

import java.util.Scanner;

public class lession1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;


        while (continueInput) {
            System.out.println("Enter a: ");
            double a = scanner.nextDouble();
            System.out.println("Enter b: ");
            double b = scanner.nextDouble();
            System.out.println("Enter c: ");
            double c = scanner.nextDouble();


            if (a == 0) {
                if (b == 0) {
                    System.out.println("The equation is not valid.");
                } else {
                    double x = -c / b;
                    System.out.println("The equation is linear, and the solution is: " + x);
                }
            } else {
                double delta = b*b - 4 * (a * c);

                if (delta > 0) {
                    double x1 =  (-b + Math.sqrt(delta)  ) /  (2 * a);
                    double x2 =  (-b - Math.sqrt(delta)  ) /  (2 * a);
                    System.out.println("The solution of quaratic solution is: " + x1 + " and " + x2);
                } else if (delta == 0) {
                    double  x =  - b /( 2 * a) ;
                    System.out.println("The solution of quaratic solution is: " + x); // ptrinh có nghiệm kép
                } else {
                    System.out.println("None solution ");
                }
            }
            System.out.println("Do you want to continue? (yes/no)");
            String input = scanner.next();
            continueInput = input.equalsIgnoreCase("yes");
        }

    }
}
