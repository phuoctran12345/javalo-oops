package Lab02.Bai4;


import Lab02.Bai3.Person;
import Lab02.Bai3.Untils;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        ArrayList<Person>  danhSachNguoi = new ArrayList<>();

        // Khởi tạo 2 đối tượng của lớp Person
        Lab02.Bai3.Person person1 = new Person(1, "Nguyen Van Nam", true);
        Lab02.Bai3.Person person2 = new Person(2, "Nguyen Van Na", false);

        //thêm người vào danh sách
        danhSachNguoi.add(0,person1);
        danhSachNguoi.add(1,person2);

        // Cho phép người dùng nhập dữ liệu cho hai đối tượng Person khác
        for ( int i = 2; i <= 3; i++ ) {
            System.out.println("Enter detail of person [" + (i+1) + "]");
            danhSachNguoi.add(scanfInfo());
        }

        bubbleSort(danhSachNguoi);

        //In ra danhSachNguoi
        System.out.println("\nThe persons in the arrays: ");
        for (Person person  : danhSachNguoi) {
            printInfo(person);
        }

        // Kiểm tra xem giá trị đã nhập có trong ArrayList hay không và thông báo kết quả tìm kiếm
        String nameSearch = Untils.getValue("Enter name searching: ");
        if (timKiemTenTrongDanhSachNguoi(danhSachNguoi, nameSearch)) {
            System.out.println("Có phần tử " + nameSearch + " trong arrList.");
        } else {
            System.out.println("Không tìm thấy phần tử " + nameSearch + " trong arrList.");
        }


    }

    public static void printInfo(Lab02.Bai3.Person p) {
        System.out.println("--------------------------------");
        System.out.println("| ID | Name | Male |");
        System.out.printf("| %d | %s | %b |\n", p.getId(), p.getName(), p.isGender());
    }


    public static Person scanfInfo() {
        int id = Integer.parseInt(Lab02.Bai3.Untils.getValue("Enter id: "));
        String name = Lab02.Bai3.Untils.getValue("Enter name: ");
        String genderInput = Untils.getValue("Enter gender (male/female): ").toLowerCase();

        boolean gender = "male".equals(genderInput);

        return new Person(id, name, gender);
    }

    public static boolean timKiemTenTrongDanhSachNguoi(ArrayList<Person> danhSachNguoi  , String nameSearch) {
        for (int i = 0; i < danhSachNguoi.size(); i++) {
            // Lấy tên của đối tượng Person tại vị trí i
            String personName = danhSachNguoi.get(i).getName();
            // So sánh tên với chuỗi tìm kiếm
            if (personName.equals(nameSearch)) {
                return true;
            }
        }
        return false;
    }


    public static  void bubbleSort(ArrayList<Person> danhSachNguoi) {
        int n = danhSachNguoi.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (danhSachNguoi.get(j).getName().compareTo(danhSachNguoi.get(j + 1).getName()) > 0) {
                    // hoán đổi  danhSachNguoi[j] với danhSachNguoi[j+1]
                    Person temp = danhSachNguoi.get(i);
                    danhSachNguoi.set(j, danhSachNguoi.get(j + 1));
                    danhSachNguoi.set(j + 1, temp);
                }
            }
        }
    }
}
