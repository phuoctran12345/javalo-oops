import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước của mảng từ bàn phím
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int size = scanner.nextInt();

        // Khởi tạo mảng với kích thước được nhập từ bàn phím
        int[] arr = new int[size];

        // Nhập giá trị cho mảng từ bàn phím
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < size; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Hiển thị mảng trước khi thay đổi
        System.out.println("Mảng trước khi thay đổi:");
        hienThiMang(arr);

        // Thay đổi giá trị của mảng
        thayDoiMang(arr);

        // Hiển thị mảng sau khi thay đổi
        System.out.println("Mảng sau khi thay đổi:");
        hienThiMang(arr);

        scanner.close();
    }

    // Hàm thay đổi giá trị của mảng
    public static void thayDoiMang(int[] array) {
        // Thực hiện các thay đổi mong muốn trên mảng
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2; // Ví dụ: Nhân đôi giá trị của mỗi phần tử trong mảng
        }
    }

    // Hàm hiển thị các phần tử của mảng
    public static void hienThiMang(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
