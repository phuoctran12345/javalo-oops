/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUA
 */
public class Company {
    private List<Customer> customerList;

    public Company() {
        customerList = new ArrayList<>();
        initializeCustomers();
    }

    private void initializeCustomers() {
        customerList.add(new Customer("201", "Nguyen Van A", "0901234567", "12/31/1990", "123 Nguyen Trai, Hanoi"));
        customerList.add(new Customer("202", "Tran Thi B", "0912345678", "08/21/1991", "456 Le Loi, Ho Chi Minh"));
        customerList.add(new Customer("203", "Le Van C", "0987654321", "05/13/1992", "789 Tran Hung Dao, Da Nang"));
        customerList.add(new Customer("204", "Pham Thi D", "0923456789", "11/22/1993", "101 Vo Thi Sau, Hue"));
        customerList.add(new Customer("205", "Hoang Van E", "0934567890", "07/18/1994", "202 Bach Dang, Hai Phong"));
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customerList.remove(customer);
    }
}
