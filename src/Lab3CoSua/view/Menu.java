/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3CoSua.view;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
//    private String title;
//    private String[] arr;
    
     public static void printMainMenu() {
        System.out.println("\n--------QUẢN LÍ NHÂN VIÊN---------------------\n");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. In thông tin nhân viên");
        System.out.println("3. Sắp xếp giảm dần theo lương");
        System.out.println("4. Tìm và xóa nhân viên theo tên");
        System.out.println("5. In mức lương trung bình của từng loại nhân viên");
        System.out.println("0. Exit");
    }
//----------------------------------------------------   
 public static void printScanfMenu() {
        System.out.println("\n--------------------------------LOAI NHÂN VIÊN---------------------\n");
        System.out.println("1. Nhân viên chính thuc");
        System.out.println("2. Nhân viên thoi vu");
        System.out.println("0. Exit");
    }   
}

