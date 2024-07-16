/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AssN7B.view;

import java.util.Scanner;

/**
 *
 * @author OS
 */
public class Utils {
    public static String getValue(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }
}

