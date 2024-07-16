package PT1Qlong.Model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private LocalDate datePublished;
    private double price;

    public Book(int bookID, String title, String author, LocalDate datePublished, double price) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
        this.price = price;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public double getPrice() {
        return price;
    }

    public int getBookAge() {
        return (int) ChronoUnit.YEARS.between(datePublished, LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-20s | %-15s | %-12s | %-30s |", // định dạng cái table
                bookID, title, author, datePublished, price);
    }
}