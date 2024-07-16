package PT1Qlong.Model;



import PT1Qlong.View.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library  {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
        initializeBooks();
    }

    private void initializeBooks() {
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", LocalDate.of(2024, 4, 10), 10.99));
        books.add(new Book(2, "1984", "George Orwell", LocalDate.of(2022, 6, 8), 8.99));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee", LocalDate.of(2021, 7, 11), 7.99));
        books.add(new Book(4, "The Catcher in the Rye", "J.D. Salinger", LocalDate.of(2022, 7, 16), 6.99));
        books.add(new Book(5, "Pride and Prejudice", "Jane Austen", LocalDate.of(2000, 1, 28), 5.99));
        books.add(new Book(6, "The Hobbit", "J.R.R. Tolkien", LocalDate.of(2022, 9, 21), 12.99));
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void addNewBook() {
        int bookID = Integer.parseInt(Utils.getValue("Enter ID: "));
        String bookTitle = Utils.getValue("Enter Book Title: ");
        String author = Utils.getValue("Enter Author: ");
        LocalDate datePublished = LocalDate.parse(Utils.getValue("Enter Date Published (YYYY-MM-DD): "));
        double price = Double.parseDouble(Utils.getValue("Enter Price: "));

        Book newBook = new Book(bookID, bookTitle, author, datePublished, price);
        addBook(newBook);
        System.out.println("Book added successfully.");
    }

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getBookID() == book.getBookID()) {
                System.out.println("Book ID already exists. Cannot add duplicate.");
                return;
            }
        }
        books.add(book);
    }

    public void sortBooksByPrice() {
        Collections.sort(books, Comparator.comparingDouble(Book::getPrice));
    }

    public void sortBooksByDate() {
        Collections.sort(books, Comparator.comparing(Book::getDatePublished));
    }

    public void searchBooksByAge() {
        int age = Integer.parseInt(Utils.getValue("Enter age to search for: "));
        List<Book> booksByAge = searchBooksByAge(age);
        if (booksByAge.isEmpty()) {
            System.out.println("No books found with the specified age.");
        } else {
            for (Book book : booksByAge) {
                System.out.println(book);
            }
        }
    }

    public List<Book> searchBooksByAge(int age) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookAge() == age) {
                result.add(book);
            }
        }
        return result;
    }
}


