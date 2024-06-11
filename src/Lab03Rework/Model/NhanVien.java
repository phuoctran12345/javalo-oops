package Lab03Rework.Model;

/* NhanVien -> xem NhanVienChinhThuc và NhanVienThoiVu có những tính chất gì chung
   NhanVienChinhThuc -> có số lương thưởng OT riêng
   NhanVienThoiVu -> có mục chiết khấu 

   Ứng dụng GUI là gì ? -> kéo thả cái gì gì đó

Model:

Chứa các lớp dữ liệu và logic nghiệp vụ của ứng dụng.
Các lớp này đại diện cho dữ liệu được sử dụng trong ứng dụng và các phương thức để xử lý dữ liệu đó.
Ví dụ: NhanVien, NhanVienThoiVu, NhanVienChinhThuc.

View:

Chứa các lớp liên quan đến giao diện người dùng (UI).
Các lớp này hiển thị dữ liệu cho người dùng và nhận đầu vào từ người dùng.
Ví dụ: Menu, Validation.

Controller:

Chứa các lớp điều phối các yêu cầu từ View đến Model và trả lại kết quả từ Model đến View.
Chịu trách nhiệm xử lý luồng công việc của ứng dụng.
Tập tin chính của ứng dụng với phương thức main thường nằm trong phần này.
Ví dụ: CompanyManagerApp.

* */

import java.text.DecimalFormat;

public  class NhanVien {
    protected int id;
    protected String ho;
    public String ten;
    protected int tuoi;
    protected String ngaySinh;

    public NhanVien(int id, String ho, String ten, int tuoi, String ngaySinh) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.tuoi = tuoi;
        this.ngaySinh = ngaySinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public double tinhLuong() {
        return 0;
    }

    // hàm in ra thông in bằng decimall format
    public void hienThiThongTin() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("ID: " + id);
        System.out.println("Họ và tên: " + ho + " " + ten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Ngày sinh: " + ngaySinh);

    }
}
