package PT1BOOKHCN.model;



import PT1BOOKHCN.utils.Validation;
import PT1BOOKHCN.utils.LibraryFullException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Predicate;

public class Library extends ArrayList<Book> {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public Library() {
        super();
        try{
            this.add(new Book("B0001", "Java Programming", "Jonh Horstman", formatter.parse("12/05/2021"), 10));
            this.add(new Book("B0002", "Web development with Java", "John Smith", Validation.checkValidDate( "01/08/2018"), 8));
            this.add(new Book("B0003", "Java Programming", "Jonh Horstman", formatter.parse("12/05/2021"), 10));
            this.add(new Book("B0004", "Web development with Java", "John Smith", Validation.checkValidDate( "01/08/2018"), 8));
            this.add(new Book("B0005", "Java Programming", "Jonh Horstman", formatter.parse("12/05/2022"), 10));
            this.add(new Book("B0006", "Web development with Java", "John Smith", Validation.checkValidDate( "01/08/2013"), 8));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void listAllBooks() {
        this.listAllBooks(this);
    }
    public void listAllBooks(ArrayList<Book> list){
        int total = list.size();
        if (total <= 0) {
            System.err.println("Sorry. Nothing to print.");
            return;
        }
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getBookID().compareToIgnoreCase(o2.getBookID());
            }
        });
        System.out.println("List all books");
        System.out.println("--------------------------------");
//        for (var book : list) {
//            System.out.println(book);
//        }
        list.forEach(System.out::println);
        System.out.println("--------------------------------");
        System.out.println("Total: " + total + " books.");
    }
    public void addNewBook() throws LibraryFullException {
        if (this.size() >= 10000) {
            throw new LibraryFullException("The library can only hold 10,000 books and is full.");
        }
        System.out.println("Add new book");
        System.out.println("--------------------------------");
        String newBookID = null;
        String newBookTitle = null;
        String newAuthor = null;
        while (true) {
            newBookID = Validation.getString("Enter Book ID (st. ID B0000): ", "[bB][\\d]{4}");
            if (!this.isBookIDDuplicated(newBookID)) {
                break;
            }
        }
        newBookTitle = Validation.getString("Enter Book Title: ");
        newAuthor = Validation.getString("Enter Author: ");
        Date newYearPublished = Validation.checkValidDate(Validation.getString("Enter Year Published: "));
        float newPrice = Validation.getFloat("Enter Price: ");
        this.add(new Book(newBookID, newBookTitle, newAuthor, newYearPublished, newPrice));
    }

    private boolean isBookIDDuplicated(String bookID) {
        bookID = bookID.trim().toUpperCase();
        for (Book book : this) {
            if (book.getBookID().equalsIgnoreCase(bookID)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Book> search(Predicate<Book> predicate) {
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : this) {
            if (predicate.test(book)) {
                list.add(book);
            }
        }
        if (list.isEmpty()) {
            System.err.println("Can not not found.");
        }
        return list;
    }
    public void listBooksSameAge() {
        ArrayList<Book> list = this;
        ArrayList<ArrayList<Book>> ageList = new ArrayList<>();
        list.forEach(book -> {
            boolean addedToGroup = false;
            for (ArrayList<Book> ageGroup : ageList) {
                if (!ageGroup.isEmpty() && ageGroup.get(0).calAge() == book.calAge()) {
                    ageGroup.add(book);
                    addedToGroup = true;
                    break;
                }
            }
            if (!addedToGroup) {
                ArrayList<Book> newAgeList = new ArrayList<>();
                newAgeList.add(book);
                ageList.add(newAgeList);
            }
        });
        Collections.sort(ageList, new Comparator<ArrayList<Book>>() {
            @Override
            public int compare(ArrayList<Book> list1, ArrayList<Book> list2) {
                return Integer.compare(list1.get(0).calAge(), list2.get(0).calAge());
            }
        });
        System.out.println("List all books with same age:");
        System.out.println("--------------------------------");
        ageList.forEach(age ->{
            System.out.println("\nBooks with age " + age.get(0).calAge() + ":");
            age.forEach(System.out::println);
        });
        System.out.println("--------------------------------");
    }
}
