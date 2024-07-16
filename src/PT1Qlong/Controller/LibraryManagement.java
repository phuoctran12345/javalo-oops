package PT1Qlong.Controller;


import PT1Qlong.Model.Library;
import PT1Qlong.View.Menu;

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        boolean exit = false;
        while (!exit) {
            int choice = Menu.displayMenuAndGetChoice();
            exit = handleMenuChoice(choice, library);
        }
    }

    private static boolean handleMenuChoice(int choice, Library library) {
        switch (choice) {
            case 1:
                library.printBooks();
                break;
            case 2:
                library.addNewBook();
                break;
            case 3:
                library.sortBooksByPrice();
                System.out.println("Books sorted by price.");
                break;
            case 4:
                library.sortBooksByDate();
                System.out.println("Books sorted by date published.");
                break;
            case 5:
                library.searchBooksByAge();
                break;
            case 0:
                System.out.println("\nExiting...");
                return true;
            default:
                System.out.println("\nInvalid choice. Please try again!");
        }
        return false;
    }
}
