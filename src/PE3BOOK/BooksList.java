package PE3BOOK;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
//Thư viện "java.io.Serializable" trong Java là một giao diện (interface) được sử dụng để đánh dấu một lớp (class)
// là có thể tuần tự hóa (serialize) và giải tuần tự hóa (deserialize).

public class BooksList  implements Serializable {
    private static ArrayList<Books> books;



    public BooksList() {
        this.books = new ArrayList<>();
    }

    public ArrayList<Books> getBooks() {
        return books;
    }

    public void addBook(Books book) {
        books.add(book);

        System.out.println("Book added successfully.");
    }
    /*
    * public void addEmployee(){
        String code, name;
        int  salary;
        int index;
        boolean valid = true;
        System.out.println("Enter information");
        do{
            code = validation.getString("Enter code (Eddd) (d stands for digit)").toUpperCase();
            index = findCode(code);
            valid = code.matches("^E\\d{3}$"); // UTF-8
            if (index >= 0) {
                System.out.println("Duplicated code"); // mã trùng nhau
            }
        }while (index >= 0|| (!valid));
        name = validation.getString("Enter name:").toLowerCase();
        salary = validation.getInt("Enter salary");
        this.add(new Employee(code, name, salary));
        System.out.println("Add succesfully");
    }*/


    static void deleteBook(int index) {
        if (books != null && index >= 0 && index < books.size()) {
            books.remove(index);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }


    static void displayBook() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }
}



