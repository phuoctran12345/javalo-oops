
package Lab3CoSua.model;

import java.text.ParseException;



public class NhanVienThoiVu extends NhanVien{
    public final double chietKhau = 0.5;

    public NhanVienThoiVu(int id, String ten, int tuoi, String ngaySinh, int soNgayLamViec) throws ParseException {
        super(id, ten, tuoi, ngaySinh, soNgayLamViec);
    }

   

    @Override
    public String toString() {
        return "NhanVienThoiVu{" + super.toString() +" ,so luong = " + tinhLuong();
    }

    
   
    public long tinhLuong() {
        return (long) (getSoNgayLamViec() * 1000000 * chietKhau);
    }
}
