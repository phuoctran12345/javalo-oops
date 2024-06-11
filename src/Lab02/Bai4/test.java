package Lab02.Bai4;

import Lab02.Bai3.Person;
import Lab02.Bai3.Untils;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        ArrayList<Person> danhSachNguoi = new ArrayList<>();

        // Khởi tạo 2 đối tượng của lớp Person
        Person person1 = new Person(1, "Nguyen Van Nam", true);
        Person person2 = new Person(2, "Nguyen Van Na", false);

        // Thêm người vào danh sách
        danhSachNguoi.add(person1);
        danhSachNguoi.add(person2);

        // Cho phép người dùng nhập dữ liệu cho hai đối tượng Person khác
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter detail of person [" + (i + 3) + "]");
            danhSachNguoi.add(scanfInfo());
        }

        bubbleSort(danhSachNguoi);

        // In ra danhSachNguoi
        System.out.println("\nThe persons in the arrays: ");
        for (Person person : danhSachNguoi) {
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
        System.out.printf("| %2d | %-20s | %s |\n", p.getId(), p.getName(), p.isGender() ? "Male" : "Female");
    }

    public static Person scanfInfo() {
        int id = Integer.parseInt(Lab02.Bai3.Untils.getValue("Enter id: "));
        String name = Lab02.Bai3.Untils.getValue("Enter name: ");
        String genderInput = Untils.getValue("Enter gender (male/female): ").toLowerCase();
        boolean gender = "male".equals(genderInput);
        return new Person(id, name, gender);
    }

    public static boolean timKiemTenTrongDanhSachNguoi(ArrayList<Person> danhSachNguoi, String nameSearch) {
        for (Person person : danhSachNguoi) {
            if (person.getName().equalsIgnoreCase(nameSearch)) {
                return true;
            }
        }
        return false;
    }

    public static void bubbleSort(ArrayList<Person> danhSachNguoi) {
        int n = danhSachNguoi.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (danhSachNguoi.get(j).getName().compareTo(danhSachNguoi.get(j + 1).getName()) > 0) {
                    // Hoán đổi danhSachNguoi[j] với danhSachNguoi[j+1]
                    Person temp = danhSachNguoi.get(j);
                    danhSachNguoi.set(j, danhSachNguoi.get(j + 1));
                    danhSachNguoi.set(j + 1, temp);
                }
            }
        }
    }
}
