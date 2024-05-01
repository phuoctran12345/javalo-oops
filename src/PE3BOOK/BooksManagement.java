package PE3BOOK;

import java.io.*;

public class BooksManagement {
    private BooksList booksList;
    private Menu menu;

    public BooksManagement() {
        this.booksList = new BooksList();
        this.menu = new Menu();
    }

    public void start() {
        boolean running = true;
        while (running) {
            int choice = Menu.displayMenuAndGetChoice();
            switch (choice) {
                case 1:
                    loadData();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    saveTofile();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private void loadData() {
        try {
            FileInputStream fileIn = new FileInputStream("src//PE3BOOK//book.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            booksList = (BooksList) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private void addBook() {
        String title = Validation.getString("Enter book title: "); //Validation.(lấy dữ liệu)
        double price = Validation.getFloat("Enter book price: ");
        booksList.addBook(new Books(title , price));
        System.out.println("Books Add successfully ");
    }

    private void deleteBook() {
        int index = Validation.getInt("Enter index or  book you want to delete: ");
        BooksList.deleteBook(index - 1);
    }

    // hàm này đã được xử lý bên file BooksList
    private void displayBooks() {
        if (booksList != null) {
            booksList.displayBook();
        } else {
            System.out.println("Error: Books list is not initialized.");
        }
    }

    private void saveTofile() {
        try{
            FileOutputStream fileOutput = new FileOutputStream("src/PE3BOOK/book.txt"); // tạo đối tượng để ghi dữ liệu đầu vào
            ObjectOutputStream out = new ObjectOutputStream(fileOutput);
            //ObjectOutputStream được sử dụng để tuần tự hóa các đối tượng và ghi chúng vào luồng
            //Trong trường hợp này, đối tượng out sẽ ghi dữ liệu vào tệp tin "book.txt" thông qua luồng fileOutput.
            out.writeObject(booksList);
            out.close();
            fileOutput.close();
            System.out.println("Data save to file successfully! ");
        } catch(IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BooksManagement management = new BooksManagement();
        management.start();
    }
}
