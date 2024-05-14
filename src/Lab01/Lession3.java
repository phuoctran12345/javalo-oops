package Lab01;

import java.util.ArrayList;
import java.util.Scanner;

public class Lession3 {

    //Hàm khởi tạo trung gian in ra màn hình
    static void display(String title, ArrayList<String> al){
        System.out.println(title);
        System.out.println("\t-----------------");

        //duyệt qua từng phần tử
        for (int i = 0; i < al.size(); i++) {
            System.out.println((i+1) + ". " + al.get(i));
        }
        System.out.println("\t------------------");
    }

    // hàm dùng để lựa chọn từ menu
    static void execute(int ch){
        switch (ch){
            case 1:
                lession1.main(null);
            break;
            case 2:
                lession2.main(null);
                break;
            case 3: System.exit(0); break;
            default: System.out.println("Invalid option!"); break; // chọn k hợp lệ thì thoát
        }
    }

    // hàm dùng để chạy chương trình
    // lấy lựa chọn từ người dùng nằm trong khoảng al và ch được đẩy lên hàm execute; nếu nhập k hợp lệ -> invalid
    static void run(String title, ArrayList<String> al){
        while (true){
            int ch = getSelected(title, al);
            if (ch <= al.size()) {
                execute(ch);
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    // hàm lấy lựa chọn từ người dùng
    static int getSelected(String title, ArrayList<String> al){
        display(title, al); // menu được in ra nhờ dòng ni
        System.out.println("Enter your choice: ");
        return new Scanner(System.in).nextInt();
        // tạo một đối tượng  scanner để đọc dữ liệu là số NGUYÊN vào bàn phím -> trả về  getSelected ; dữ liệu từ đây -> lên hàm run
    }

    // Phương thức main để chạy chương trình
    // đẩy data lên hàm run để thực thi chương trình
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Execute Lesson 1"); // thực thi lession 1 thông qua array list al
        al.add("Execute Lesson 2");
        al.add("Exit");
        run("---------------Menu-------------", al);
    }
}
