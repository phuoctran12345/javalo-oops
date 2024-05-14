package Lab01;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khởi tạo các mảng
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Tiêu thụ ký tự newline

        String[] names = new String[n];
        double[] grades = new double[n];

        // Bước 2: Nhập tên và điểm số từ bàn phím
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập tên sinh viên thứ " + (i + 1) + ": ");
            names[i] = normalizeName(scanner.nextLine());
            System.out.print("Nhập điểm số sinh viên thứ " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            scanner.nextLine(); // Tiêu thụ ký tự newline
        }
        // Bước 3: Xuất các mảng dựa trên khả năng học tập
        String[] abilities = new String[n];
        for (int i = 0; i < n; i++) {
            if (grades[i] < 5) {
                abilities[i] = "Yếu";
            } else if (grades[i] < 6.5) {
                abilities[i] = "Trung bình";
            } else if (grades[i] < 7.5) {
                abilities[i] = "Khá";
            } else if (grades[i] < 9) {
                abilities[i] = "Giỏi";
            } else {
                abilities[i] = "Xuất sắc";
            }
        }

        // Bước 4: Sắp xếp danh sách sinh viên theo điểm số giảm dần
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grades[i] < grades[j]) {
                    double tempGrade = grades[i];
                    grades[i] = grades[j];
                    grades[j] = tempGrade;

                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;

                    String tempAbility = abilities[i];
                    abilities[i] = abilities[j];
                    abilities[j] = tempAbility;
                }
            }
        }
        System.out.println("Thông tin sinh viên và điểm số:");
        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên " + (i + 1) + ": " + names[i] + " - Điểm số: " + grades[i]);
        }
    }

    public static String normalizeName(String name) {
        String[] parts = name.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                char firstChar = part.charAt(0);
                if (Character.isLetter(firstChar)) {
                    String normalizedPart = Character.toUpperCase(firstChar) + part.substring(1).toLowerCase();
                    result.append(normalizedPart).append(" ");
                }
            }
        }
        return result.toString().trim();
    }
}