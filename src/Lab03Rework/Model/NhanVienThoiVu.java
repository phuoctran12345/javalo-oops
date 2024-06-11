package Lab03Rework.Model;

public class NhanVienThoiVu extends NhanVien {
    private int soNgayLamViec;
    private double mucChietKhau;

    public NhanVienThoiVu(int id, String ho, String ten, int tuoi, String ngaySinh, int soNgayLamViec, double mucChietKhau) {
        super(id, ho, ten, tuoi, ngaySinh);
        this.soNgayLamViec = soNgayLamViec;
        this.mucChietKhau = mucChietKhau;
    }

    @Override
    public double tinhLuong() {
        return soNgayLamViec * 1000000 * 0.5;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Số ngày làm việc trong tháng: " + soNgayLamViec);
        System.out.println("Mức chiết khấu (đề cho 0.5): " + mucChietKhau);
    }
}
