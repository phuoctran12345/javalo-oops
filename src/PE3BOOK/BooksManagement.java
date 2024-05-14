package PE3BOOK;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

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

    //writing File in java -với bộ mã UTF-8
    private void saveTofile() {
        try{
            FileOutputStream fileOutput = new FileOutputStream("src/PE3BOOK/book.txt"); // tạo đối tượng để ghi dữ liệu đầu vào
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutput, "UTF-8"));
            //BufferedWriter -> bộ đệm ghi -> viết dữ liệu vào luồn đầu ra fileOut
            //OutputStreamWriter được sử dụng để chuyển đổi các ký tự đầu vào thành dữ liệu bytes dưới dạng UTF-8,
            // vì vậy mọi dữ liệu viết vào file sẽ được mã hóa theo UTF-8.


            int bookCount = 1;
            for (Books book : booksList.getBooks()) {
                writer.write(bookCount + ". Title: " + book.getTitle() + ", Price: " + book.getPrice() + "\n");
                bookCount++;
            }

            writer.close();
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
