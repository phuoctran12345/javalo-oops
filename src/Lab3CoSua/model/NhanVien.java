/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3CoSua.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public  class NhanVien implements Comparable<NhanVien>{
    protected int id;
    protected String ten;
    protected int tuoi;
    protected Date ngaySinh;
    protected int soNgayLamViec;

    public NhanVien(int id, String ten, int tuoi, String ngaySinh, int soNgayLamViec) throws ParseException  {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
      setNgaySinh(ngaySinh);
        this.soNgayLamViec = soNgayLamViec;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public Date getNgaySinh() {
       
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) throws ParseException  {
         SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");        
        this.ngaySinh = date.parse(ngaySinh);
    }
    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }
    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinhFormatted = dateFormat.format(ngaySinh);
        return   "id=" + id + ", ten=" + ten + ", tuoi=" + tuoi + ", ngaySinh=" + ngaySinhFormatted + ", soNgayLamViec=" + soNgayLamViec ;
    }

    @Override
    public int compareTo(NhanVien o) {
        return this.ten.compareTo(o.getTen());
    }
}
