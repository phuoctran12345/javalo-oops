/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3CoSua.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Company {

    private ArrayList<NhanVien> Emplist;

    public Company() throws ParseException {
        Emplist = new ArrayList();
        Emplist.add(new NhanVienChinhThuc(1, "Minh Thu", 10, "12/10/2000", 5, 5));
        Emplist.add(new NhanVienChinhThuc(2, "Anh Minh", 20, "12/10/2000", 5, 5));
        Emplist.add(new NhanVienThoiVu(3, "Bao Lan", 18, "12/10/2000", 5));
        Emplist.add(new NhanVienThoiVu(4, "Bao Chung", 7, "12/10/2000", 5));
    }

    public ArrayList<NhanVien> getEmplist() {
        return Emplist;
    }

    public void setEmplist(ArrayList<NhanVien> Emplist) {
        this.Emplist = Emplist;
    }

    
   public void sortByAge(){
      Emplist.sort(new Comparator<NhanVien>
              () {
          @Override
          public int compare(NhanVien o1, NhanVien o2) {
                  return Integer.compare(o1.getTuoi(), o2.getTuoi());
          }
              }
      );
       
       
   }

    public boolean isEmptyList() {
        return Emplist.isEmpty();
    }

    public void addNew(NhanVien nv) {
        Emplist.add(nv);

    }

    public boolean isEmployeeExist(int id) {
        if (Emplist == null) {
            return false;
        }
        for (NhanVien employee : Emplist) {
            if (employee.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void printListEmp(ArrayList<NhanVien> empList) {
        for (NhanVien employee : Emplist) {
            if (employee instanceof NhanVienThoiVu) {
                System.out.println((NhanVienThoiVu) employee);
            } else if (employee instanceof NhanVienChinhThuc) {
                System.out.println((NhanVienChinhThuc) employee);
            }

        }
    }

    public void compareSalary() {

    }

    public ArrayList<NhanVien> findEmployeeByName(String ten) {
        ArrayList<NhanVien> empList=new ArrayList<>();
        for (NhanVien employee : Emplist) {
            if (employee.getTen().equals(ten)) {
                empList.add(employee);
              
            }
        }
        return empList;
    }

  

    

    public void deleteEmployee(NhanVien employee) {

    } 
  
           
    
}
