/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3CoSua.controller;

import Lab3CoSua.model.Company;
import Lab3CoSua.model.NhanVienChinhThuc;
import Lab3CoSua.model.NhanVienThoiVu;
import Lab3CoSua.view.Menu;
import Lab3CoSua.view.Utils;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Collections;
public class CompanyManager {
    Company company;
    public CompanyManager() throws ParseException {
        company = new Company();
    }

    public void execute(int choice) {
        switch (choice) {
            case 1:
                try {
                scanfInfNhanvien();
            } catch (ParseException e) {
                System.err.println("Error: Failed to add new employee.");
            }
            break;
            case 2:
                company.printListEmp(company.getEmplist());
                break;
            case 3:
                Collections.sort(company.getEmplist());
                break;
            case 4:
                company.printListEmp(company.findEmployeeByName("A"));
                break;
            case 5:
                    company.sortByAge();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
        }
    }
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        CompanyManager manager = new CompanyManager();
        while (true) {
            Menu.printMainMenu();
            int choice = Integer.parseInt(Utils.getValue("Enter choice"));
            manager.execute(choice);
        }
    }
    public void scanfInfNhanvien() throws ParseException {
        Menu.printScanfMenu();
        int id = Integer.parseInt(Utils.getValue("Enter ID: "));
        String ten = Utils.getValue("Enter full name: ");
        int tuoi = 0;

        String ngaySinh = Utils.getValue("Enter date of birth (dd/MM/yyyy): ");
        int soNgayLamViec = Integer.parseInt(Utils.getValue("Enter number of working days in the month"));
        int typeEmployee = Integer.parseInt(Utils.getValue("Enter type employee: "));
        switch (typeEmployee) {
            case 1: {
                NhanVienThoiVu nhanVienThoiVu = new NhanVienThoiVu(id, ten, tuoi, ngaySinh, soNgayLamViec);
                company.getEmplist().add(nhanVienThoiVu);
            }
            break;
            case 2: {
                int soGioOT = Integer.parseInt(Utils.getValue("Enter the number of hours OT: "));
                NhanVienChinhThuc nhanVienChinhThuc = new NhanVienChinhThuc(id, ten, tuoi, ngaySinh, soNgayLamViec, soGioOT);
                company.getEmplist().add(nhanVienChinhThuc);
            }
            break;
        }

    }
}
