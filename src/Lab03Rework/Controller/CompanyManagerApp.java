package Lab03Rework.Controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Lab03Rework.Model.NhanVien;
import Lab03Rework.Model.NhanVienThoiVu;
import Lab03Rework.Model.NhanVienChinhThuc;
import Lab03Rework.View.Validation;
import Lab03Rework.View.Menu;

public class CompanyManagerApp {
    private static ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();


    public static void main(String[] args) {
        boolean exit = false;
        do {
            Menu.displayMenu();
            int luaChon = Validation.getInt("Nhập lựa chọn của bạn: ", 1, 6);
            switch (luaChon) {
                case 1:
                    nhapDanhSachNhanVien();
                    break;
                case 2:
                    xuatDanhSachTheoLoai();
                    break;
                case 3:
                    sapXepVaXuatDanhSach();
                    break;
                case 4:
                    timVaXoaNhanVien();
                    break;
                case 5:
                    xuatMucLuongTrungBinh();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Ứng dụng kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (!exit);
    }

    //----------------------------------------------------------------------------------------------------------------------
    private static void nhapDanhSachNhanVien() {
        int soLuong = Validation.getInt("Nhập số lượng nhân viên cần thêm: ");
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            int loai = Validation.getInt("Chọn loại nhân viên (1 - Thời vụ, 2 - Chính thức): ", 1, 2);
            int id = Validation.getInt("Nhập ID: ");
            String ho = Validation.getString("Nhập họ: ");
            String ten = Validation.getString("Nhập tên: ");
            int tuoi = Validation.getInt("Nhập tuổi: ");
            String ngaySinh = Validation.getString("Nhập ngày sinh (dd/MM/yyyy): ", Validation.DATE_PATTERN);

            if (loai == 1) {
                int soNgayLamViec = Validation.getInt("Nhập số ngày làm việc trong tháng: ");
                double mucChietKhau = Validation.getFloat("Nhập mức chiết khấu: ");
                danhSachNhanVien.add(new NhanVienThoiVu(id, ho, ten, tuoi, ngaySinh, soNgayLamViec, mucChietKhau));
            } else if (loai == 2) {
                int soNgayLamViec = Validation.getInt("Nhập số ngày làm việc trong tháng: ");
                int soGioOT = Validation.getInt("Nhập số giờ OT: ");
                danhSachNhanVien.add(new NhanVienChinhThuc(id, ho, ten, tuoi, ngaySinh, soNgayLamViec, soGioOT));
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------
    private static void xuatDanhSachTheoLoai() {
        DecimalFormat df = new DecimalFormat("#,###.00");

        System.out.println("Danh sách nhân viên thời vụ:");
        for (NhanVien nv : danhSachNhanVien) {
            if (nv instanceof NhanVienThoiVu) { //  kiểm tra xem nv  có phải là một thể hiện của lớp NhanVienThoiVu hay không
                nv.hienThiThongTin(); // gọi phương thức hienThiThongTin() của object nv
                System.out.println("Lương: " + df.format(nv.tinhLuong()));
            }
        }

        System.out.println("\nDanh sách nhân viên chính thức:");
        for (NhanVien nv : danhSachNhanVien) {
            if (nv instanceof NhanVienChinhThuc) {
                nv.hienThiThongTin();
                System.out.println("Lương: " + df.format(nv.tinhLuong()));
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------
    private static void sapXepVaXuatDanhSach() {
        Collections.sort(danhSachNhanVien, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                return Double.compare(nv2.tinhLuong(), nv1.tinhLuong());
            }
        });
        DecimalFormat df = new DecimalFormat("#,###.00");


        for (NhanVien nv : danhSachNhanVien) {
            nv.hienThiThongTin();
            System.out.println("Lương: " + df.format(nv.tinhLuong()));
        }
    }


    //----------------------------------------------------------------------------------------------------------------------
    private static void timVaXoaNhanVien() {
        String ten = Validation.getString("Nhập tên nhân viên cần xóa: ");
        NhanVien nhanVienTimThay = null; // ép kiểu cho bằng null
        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getTen().equalsIgnoreCase(ten)) { //so sánh chữ cái mình nhập cs trùng tên nào trong arraylist hay không ; rồi truyền object
                nhanVienTimThay = nv;
                break;
            }
        }
        if (nhanVienTimThay != null) {
            danhSachNhanVien.remove(nhanVienTimThay);
            System.out.println("Nhân viên đã được xóa.");
        } else {
            System.out.println("Không tìm thấy nhân viên có tên " + ten);
        }
    }


    //----------------------------------------------------------------------------------------------------------------------
    public static void xuatMucLuongTrungBinh() {
        int countThoiVu = 0, countChinhThuc = 0;
        double sumThoiVu = 0, sumChinhThuc = 0;

        for (NhanVien nv : danhSachNhanVien) {
            if (nv instanceof NhanVienThoiVu) {
                sumThoiVu += nv.tinhLuong();
                countThoiVu++;
            } else if (nv instanceof NhanVienChinhThuc) {
                sumChinhThuc += nv.tinhLuong();
                countChinhThuc++;
            }
        }

        double avgThoiVu = countThoiVu == 0 ? 0 : sumThoiVu / countThoiVu;
        double avgChinhThuc = countChinhThuc == 0 ? 0 : sumChinhThuc / countChinhThuc;

        DecimalFormat df = new DecimalFormat("#,###.00");

        System.out.println("Lương trung bình nhân viên thời vụ: " + df.format(avgThoiVu));
        System.out.println("Lương trung bình nhân viên chính thức: " + df.format(avgChinhThuc));
    }
}
