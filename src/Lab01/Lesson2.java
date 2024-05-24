package Lab01;

import java.util.Scanner;

public class Lesson2 {
    public static double tinhTienDien(double monthlyElectric) {

        if (monthlyElectric > 0 && monthlyElectric <= 50 ) {
            return monthlyElectric * 1000 ;
        } else if (monthlyElectric > 50) {
           return (50 * 1000) + ( (monthlyElectric - 50) * 1200);
        } else {
            return -1; // số ảo
        }
    }
}
