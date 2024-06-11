package DeLopQuocLong.View;

import java.util.Scanner;

public class Validation {

    public static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        return getInt(null, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(int minRange, int maxRange) {
        return getInt(null, minRange, maxRange);
    }

    public static int getInt(String msg) {
        return getInt(msg, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getInt(String msg, int minRange, int maxRange) {
        if (minRange > maxRange) {
            int temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        int value = Integer.MIN_VALUE;

        do {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }

                value = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Please enter again...");
            }
        } while (value < minRange || value > maxRange);

        return value;
    }

    public static float getFloat() {
        return getFloat(null, Float.MIN_VALUE, Float.MAX_VALUE);
    }

    public static float getFloat(float minRange, float maxRange) {
        return getFloat(null, minRange, maxRange);
    }

    public static float getFloat(String msg) {
        return getFloat(msg, Float.MIN_VALUE, Float.MAX_VALUE);
    }

    public static float getFloat(String msg, float minRange, float maxRange) {
        if (minRange > maxRange) {
            float temp = minRange;
            minRange = maxRange;
            maxRange = temp;
        }

        float value = Float.MIN_VALUE;

        do {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }

                value = Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Please enter again...");
            }
        } while (value < minRange || value > maxRange);

        return value;
    }

    public static String getString(String msg, String pattern) {
        String value = null;

        do {
            value = getString(msg);
        } while (!value.matches(pattern));

        return value;
    }

    public static String getString(String msg) {
        String value = null;

        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            value = scanner.nextLine().replaceAll("\\s+", " ").trim();

            if (!value.isEmpty() && !value.isBlank()) {
                break;
            }

            System.err.println("Please enter again...");
        }

        return value;
    }

    //hàm xử lý input nhập đầu vào là ngày tháng năm sinh dd/xx/yyyy
    //Trước tiên, thêm mẫu regex cho ngày sinh:
    public static final String DATE_PATTERN = "\\d{2}/\\d{2}/\\d{4}";  // Định dạng: dd/MM/yyyy

    public static String chuanHoaTen(String name) {
        name = name.trim()
                .replaceAll("\\s+", " ") // xử lý các khoảng trống vd: ("           ") -> (" ")
                .replaceAll("[^a-zA-Z\\s]", ""); // nhận các ký tự từ a -> z và A -> Z
        String[] subTen = name.split(" ");
        StringBuilder sb = new StringBuilder(); //sử dụng để tạo và quản lý chuỗi một cách hiệu quả hơn so với việc sử dụng các chuỗi thông thường.

        for (String s : subTen) { // duyệt qua từng phần tử của mảng subTen
            if (!s.isEmpty()) { // nếu chuỗi ni không rỗng thì thực hiện cái cục bên trong
                sb.append(s.substring(0, 1).toUpperCase());
                sb.append(s.substring(1).toLowerCase());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}