package Lab01.Lesson4LamLai;

import java.util.Scanner;

public class Untils {

    //Phương thức này hiển thị một thông báo cho người dùng và đọc dữ liệu nhập từ bàn phím.
    public static  String getValue  (String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(input);
        return scanner.nextLine();
    }
    public boolean checkScore() {
        return false ;
    }
}
