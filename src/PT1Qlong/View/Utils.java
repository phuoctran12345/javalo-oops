package PT1Qlong.View;

import java.util.Scanner;

public class Utils {
    public static String getValue(String input) {
        Scanner sc = new Scanner(System.in);
        System.out.print(input);
        return sc.nextLine();
    }
}