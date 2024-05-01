package PE3BOOK;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public static int displayMenuAndGetChoice() {
        System.out.println("/****************************************/");
        System.out.println("1. Load data books.");
        System.out.println("2. Add new book.");
        System.out.println("3. Delete book.");
        System.out.println("4. Display list books.");
        System.out.println("5. Save to File.");
        System.out.println("6. Exit.");
        System.out.println("/****************************************/");
        System.out.print("Enter your choice: ");
        return Validation.getInt(1, 6);
    }
}
