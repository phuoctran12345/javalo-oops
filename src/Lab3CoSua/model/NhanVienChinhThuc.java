
package Lab3CoSua.model;

import java.text.ParseException;



public class NhanVienChinhThuc extends NhanVien{
    private int soGioOT;

    public NhanVienChinhThuc( int id, String ten, int tuoi, String ngaySinh, int soNgayLamViec,int soGioOT) throws ParseException {
        super(id, ten, tuoi, ngaySinh, soNgayLamViec);
        this.soGioOT = soGioOT;
    }

   

    public int getSoGioOT() {
        return soGioOT;
    }

    public void setSoGioOT(int soGioOT) {
        this.soGioOT = soGioOT;
    }
    
    public long tinhLuong() {
        return (long) soNgayLamViec * 1000000 + soGioOT * 100000;
    }

    @Override
    public String toString() {
        return "NhanVienChinhThuc " + super.toString() + ", so gio OT=" + soGioOT + ", so luong = " + tinhLuong() + '}';
    }
        
}
