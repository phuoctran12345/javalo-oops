package Lab01.Lesson4LamLai;

import java.util.Random;

public class NhapHocSinhTuBanPhim {

    /*
    public static void main(String[] args) {
        Random rand = new Random();

        int n  = Integer.parseInt(Untils.getValue("Nhập số lượng học sinh: "));
        String[] tenHocSinh = new String[n];
        double[] diemHocSinh = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ten hoc sinh " + (i + 1) + ": ");
            tenHocSinh[i] =  Untils.getValue("Nhập tên học sinh: " + (i + 1) + ": ");
            diemHocSinh[i] = 1 + rand.nextDouble() * 9;
        }

        System.out.println("\nThong tin hoc sinh:");
        for (int i = 0; i < n; i++) {
            String hocLuc = xepLoaiHocLuc(diemHocSinh[i]);
            System.out.printf("Ho va ten: %s, Diem: %.2f, Hoc luc: %s%n", chuanHoaTen(tenHocSinh[i]), diemHocSinh[i], hocLuc);
        }

        sapXepHocSinh(tenHocSinh, diemHocSinh); //giam dan

        System.out.println("\nHoc sinh co diem cao nhat:");
        System.out.printf("Ho va ten: %s, Diem: %.2f%n", chuanHoaTen(tenHocSinh[0]), diemHocSinh[0]);

        double diemTrungBinh = tinhDiemTrungBinh(diemHocSinh);
        System.out.printf("\nDiem trung binh cua hoc sinh: %.2f%n", diemTrungBinh);

        System.out.println("\nTen hoc sinh da chuan hoa:");
        for (int i = 0; i < n; i++) {
            System.out.println(chuanHoaTen(tenHocSinh[i]));
        }
    }
    */

    public static String xepLoaiHocLuc(double diem) {
        if (diem < 5) return "Yeu";
        else if (diem < 6.5) return "Trung binh";
        else if (diem < 7.5) return "Kha";
        else if (diem < 9) return "Gioi";
        else return "Xuat Sac";
    }

    public static void sapXepHocSinh(String[] ten, double[] diem) {
        // Bubble Sort
        for (int i = 0; i < diem.length - 1; i++) {
            for (int j = 0; j < diem.length - 1 - i; j++) {
                if (diem[j] < diem[j + 1]) {
                    double tmpDiem = diem[j];
                    diem[j] = diem[j + 1];
                    diem[j + 1] = tmpDiem;

                    String tmpTen = ten[j];
                    ten[j] = ten[j + 1];
                    ten[j + 1] = tmpTen;
                }
            }
        }
    }

    public static double tinhDiemTrungBinh(double[] diem) {
        double tong = 0;
        for (double d : diem) {
            tong += d;
        }
        return tong / diem.length;
    }



    public static String chuanHoaTen(String name) {
        name = name.trim()
                .replaceAll("\\s+", " ") // xử lý các khoảng trống vd: ("           ") -> (" ")
                .replaceAll("[^a-zA-Z\\s]", ""); // nhận các ký tự từ a -> z và A -> Z
        String[] subTen = name.split(" ");
        StringBuilder sb = new StringBuilder(); //sử dụng để tạo và quản lý chuỗi một cách hiệu quả hơn so với việc sử dụng các chuỗi thông thường.

        for (String s : subTen) { // duyệt qua từng phần tử của mảng subTen
            if (!s.isEmpty()) { // nếu chuỗi ni không rỗng thì thực hiện cái cục bên trong // isEmpty là từ khoá trong thư viện java -> trả về tập hợp rỗng
                sb.append(s.substring(0, 1).toUpperCase());
                sb.append(s.substring(1).toLowerCase());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int n = 0;
        String[] tenHocSinh = null;
        double[] diemHocSinh = null;

        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Nhập thông tin học sinh");
            System.out.println("2. Hiển thị thông tin học sinh");
            System.out.println("3. Sắp xếp học sinh theo điểm");
            System.out.println("4. Hiển thị học sinh có điểm cao nhất");
            System.out.println("5. Tính điểm trung bình của học sinh");
            System.out.println("6. Hiển thị tên học sinh đã chuẩn hoá");
            System.out.println("7. Thoát chương trình");

            int choice = Integer.parseInt(Untils.getValue("Nhập lựa chọn của bạn: "));

            switch (choice) {
                case 1:
                    n = Integer.parseInt(Untils.getValue("Nhập số lượng học sinh: "));
                    tenHocSinh = new String[n];
                    diemHocSinh = new double[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập tên học sinh " + (i + 1) + ": ");
                        tenHocSinh[i] = Untils.getValue("");
                        diemHocSinh[i] = 1 + rand.nextDouble() * 9;
                    }
                    break;
                case 2:
                    if (n == 0) {
                        System.out.println("Chưa có thông tin học sinh!");
                    } else {
                        System.out.println("\nThông tin học sinh:");
                        for (int i = 0; i < n; i++) {
                            String hocLuc = xepLoaiHocLuc(diemHocSinh[i]);
                            System.out.printf("Họ và tên: %s, Điểm: %.2f, Học lực: %s%n", chuanHoaTen(tenHocSinh[i]), diemHocSinh[i], hocLuc);
                        }
                    }
                    break;
                case 3:
                    if (n == 0) {
                        System.out.println("Chưa có thông tin học sinh!");
                    } else {
                        sapXepHocSinh(tenHocSinh, diemHocSinh); // giảm dần
                        System.out.println("Đã sắp xếp học sinh theo điểm!");
                    }
                    break;
                case 4:
                    if (n == 0) {
                        System.out.println("Chưa có thông tin học sinh!");
                    } else {
                        System.out.printf("Học sinh có điểm cao nhất: %s, Điểm: %.2f%n", chuanHoaTen(tenHocSinh[0]), diemHocSinh[0]);
                    }
                    break;
                case 5:
                    if (n == 0) {
                        System.out.println("Chưa có thông tin học sinh!");
                    } else {
                        double diemTrungBinh = tinhDiemTrungBinh(diemHocSinh);
                        System.out.printf("Điểm trung bình của học sinh: %.2f%n", diemTrungBinh);
                    }
                    break;
                case 6:
                    if (n == 0) {
                        System.out.println("Chưa có thông tin học sinh!");
                    } else {
                        System.out.println("\nTên học sinh đã chuẩn hoá:");
                        for (int i = 0; i < n; i++) {
                            System.out.println(chuanHoaTen(tenHocSinh[i]));
                        }
                    }
                    break;
                case 7:
                    exit = true;
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

}
