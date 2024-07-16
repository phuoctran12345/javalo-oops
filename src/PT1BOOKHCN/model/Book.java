package PT1BOOKHCN.model;



import java.util.Calendar;
import java.util.Date;

public final class Book {
    private String bookID;
    private String bookTitle;
    private String author;
    private Date datePublished;
    private float price;

    public Book(String bookID, String bookTitle, String author, Date datePublished, float price) {
        super();
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.author = author;
        this.datePublished = datePublished;
        this.price = price;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int calAge(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.datePublished);
        Calendar calendar1 = Calendar.getInstance();
        int age = calendar1.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
        return (calendar1.get(Calendar.DAY_OF_YEAR) >= calendar.get(Calendar.DAY_OF_YEAR)) ? age : age--;
    }
    @Override
    public String toString() {
        return String.format("| %-30s | %-30s | %-30s | %-30s | %-30s |", // định dạng cái table
                bookID, bookTitle , author, datePublished , price);
    }
}
