/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.view;

import java.util.Scanner;

/**
 *
 * @author ASUA
 */
public class Utils {
    public static String getValue(String input) {
        System.out.print(input);
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static String getChoice() {
        return Utils.getValue("Choose an option: ");
    }
}
