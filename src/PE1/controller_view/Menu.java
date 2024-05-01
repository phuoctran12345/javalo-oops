package PE1.controller_view;

import PE1.until.Validation;

import java.util.ArrayList;

public abstract class Menu<T> { // một lớp tham chiếu với kiểu dữ liệu truyền vào là type
    private String title;
    private ArrayList<T> options;
    private boolean isStop;

    public Menu() {
        this.isStop = false;
    }

    public Menu(String title , String[] options) {
        this.title = title;

        this.options = new ArrayList<>();

        for (var option: options) {
            this.options.add((T) options) ; //thêm một đối tượng vào danh sách options
        }

        this.isStop = false;
    }

    public  void display() {
        System.out.println(this.title);


        System.out.println("---------------------------------------------");

        for (int i = 0; i < this.options.size(); i++) {
            System.out.println((i + 1) + ". " + this.options.get(i));
        }

        System.out.println("---------------------------------------------");
    }

    public int getSelected() {
        this.display();

        return Validation.getInt("Enter selection: " , 1, this.options.size());
        // requirement ngưởi dùng nhập lệnh là số nguyên từ bàn phím
    }

    public  abstract void execute( int choice);

    protected void stop() {
        this.isStop = true;
    }


    public void run() {
        while (!this.isStop) { // trong khi isStop không phải là true
            int choice = getSelected();
            // dòng này dùng phương thức getSelected dể -> lấy lựa chọn từ người dủng rồi gán vào biến choice


            this.execute(choice);

            if (choice > this.options.size()) {
                break;
            }
            // vòng lặp ni để xđịnh xem người dùng nhập vào choice có lớn hơn các lựa chọn có trong danh sách
            //this.option hay là không ?
            // đúng -> break -> đưa ra người dùng nhập ko hợp lệ và kết thúc chương trình
        }
    }


    //phương thức run -> lặp qua các hoạt động lấy lựa chọn từ người dùng
    //thực hiện các hành động tương ứng và dừng khi người dùng chọn một lựa chọn không hợp lệ
}






