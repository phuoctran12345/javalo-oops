/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Testlap4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author OS
 */
public class Testlap4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Nhap so luong hoc sinh: ");
        int n = sc.nextInt();
        String[] tenHocSinh = new String[n];
        double[] diemHocSinh = new double[n];

        sc.nextLine(); // Doc ky tu xuong dong con lai
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ten hoc sinh " + (i + 1) + ": ");
            tenHocSinh[i] = sc.nextLine();
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
                .replaceAll("\\s+", " ")
                .replaceAll("[^a-zA-Z\\s]", "");
        String[] subTen = name.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : subTen) {
            if (!s.isEmpty()) {
                sb.append(s.substring(0, 1).toUpperCase());
                sb.append(s.substring(1).toLowerCase());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

}

