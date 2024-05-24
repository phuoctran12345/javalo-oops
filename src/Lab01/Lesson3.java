package Lab01;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(! exit){
            System.out.println("------------Menu-----------");
            System.out.println("1. The quadratic equation 2");
            System.out.println("2. Calculate electricity bill");
            System.out.println("3. Exit ");
            System.out.println("---------------------------");
            System.out.print("Choose function: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    System.out.println("Enter a: ");
                    double a = sc.nextDouble();
                    System.out.println("Enter b: ");
                    double b = sc.nextDouble();
                    System.out.println("Enter c: ");
                    double c = sc.nextDouble();
                    String result = Lesson1.ptb2(a , b, c);
                    System.out.println(result);
                    break;
                case 2 :
                    System.out.println("Enter monthly electricity  usage: ");
                    double monthElectric = sc.nextDouble();
                    double bill = Lesson2.tinhTienDien(monthElectric);
                    System.out.println("Electricity Bill: " + bill );
                    break;
                case 3 :
                    exit = true;
                    System.out.println("Goodbye");
                    break;
                default :
                    System.out.println("Please choose again!!!");
            }
        }
        sc.close();
    }
}
