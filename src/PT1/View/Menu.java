package PT1.View;

import java.util.Scanner;

public class Menu {
    public static int displayMenuAndGetChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLibrary Management System:");
        System.out.println("1. Display all books");
        System.out.println("2. Add new book");
        System.out.println("3. Sort books by price");
        System.out.println("4. Sort books by date published");
        System.out.println("5. Search book by age");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
