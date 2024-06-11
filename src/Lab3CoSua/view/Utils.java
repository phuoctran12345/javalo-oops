package Lab3CoSua.view;


import java.util.Scanner;
// chua cac ham tien ich se su dung lai cho nhieu bai toan khac

public class Utils {

    public static String getValue(String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println(input);
        return sc.nextLine();
    }

    public static int checkInt(String s) {
        int num=0;
        while(true) {
            try {
               num =Integer.parseInt(getValue(s));
              if(num>0) return num;
                      
            } catch (Exception e) {
                System.err.println("Input invalid number");

            }
        }

    }

    public static void main(String[] args) {
        int n = checkInt("Enter a number");
    }
}
