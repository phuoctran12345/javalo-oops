package Lab03Rework.Model;

public class NhanVienChinhThuc extends NhanVien {
    private int soNgayLamViec;
    private int soGioOT;

    public NhanVienChinhThuc(int id, String ho, String ten, int tuoi, String ngaySinh, int soNgayLamViec, int soGioOT) {
        super(id, ho, ten, tuoi, ngaySinh);
        this.soNgayLamViec = soNgayLamViec;
        this.soGioOT = soGioOT;
    }

    @Override
    public double tinhLuong() {
        return soNgayLamViec * 1000000 + soGioOT * 100000;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Số ngày làm việc trong tháng: " + soNgayLamViec);
        System.out.println("Số giờ OT: " + soGioOT);
    }
}
