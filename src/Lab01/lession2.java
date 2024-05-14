package Lab01;

import java.util.Scanner;

public class lession2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month electricity usage: ");
        double monthElectric = scanner.nextDouble();

        double bill;
        if (monthElectric > 0 && monthElectric <= 50 ) {
            bill  =  monthElectric * 1000 ;
        } else if (monthElectric > 50) {
           bill = (50 * 1000) + ( (monthElectric - 50) * 1200);
        } else {
            System.out.println("Try again! ");
            return;
        }

        System.out.println("Electric bill: " + bill);
    }
}
