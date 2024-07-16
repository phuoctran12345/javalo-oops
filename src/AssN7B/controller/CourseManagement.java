package AssN7B.controller;



import AssN7B.model.User;
import AssN7B.view.CourseMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseManagement {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        initializeUsers();
        if (login()) {
            String[] mchon = {"Display Course", "Add", "Total amount of all courses", "Total amount of each course by year", "Delete Course by title", "Find Course by title", "Total Course Largest Quantity", "Save to file", "Exit"};
            CourseMenu bookMenu = new CourseMenu("=== Menu ===", mchon);
            bookMenu.run();
        } else {
            System.out.println("Exceeded login attempts. Exiting...");
        }
    }

    //lớp khởi tạo tài khoản và mật khẩu
    private static void initializeUsers() {
        users.add(new User("de180577", "0123456789"));
        users.add(new User("user2", "pass2"));
        users.add(new User("user3", "pass3"));
        users.add(new User("user4", "pass4"));
        users.add(new User("user5", "pass5"));
    }

    private static boolean login() {
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        
        while (attempts < 3) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            // dùng euqal để so sánh chuỗi nhập có đúng với hàm initializeUsers() khởi tạo hay không
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Login successful!");
                    return true;
                }
            }

            attempts++;
            System.out.println("Invalid username or password. Please try again.");
        }

        return false;
    }
}
