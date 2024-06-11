package DeLopQuocLong.Model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Customer> customers;

    public Company() {
        customers = new ArrayList<>();
        initializeCustomers();
    }

    private void initializeCustomers() {
        customers.add(new Customer(201, "Nguyen Van A", "0901234567", "15/01/1990", "123 Nguyen Trai, Hanoi"));
        customers.add(new Customer(202, "Tran Thi B", "0912345678", "23/11/1990", "456 Le Loi, Ho Chi Minh"));
        customers.add(new Customer(203, "Le Van C", "0987654321", "10/03/1975", "789 Tran Hung Dao, Da Nang"));
        customers.add(new Customer(204, "Pham Thi D", "0923456789", "22/07/1990", "101 Vo Thi Sau, Hue"));
        customers.add(new Customer(205, "Hoang Van E", "0934567890", "05/05/1995", "202 Bach Dang, Hai Phong"));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer searchCustomerByID(int id) {
        for (Customer customer : customers) {
            if (customer.getCustomerID() == id) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> searchCustomerByName(String name) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                result.add(customer);
            }
        }
        return result;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomersByYear(int year) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            String[] dobParts = customer.getDob().split("/");
            int birthYear = Integer.parseInt(dobParts[2]);
            if (birthYear == year) {
                result.add(customer);
            }
        }
        return result;
    }

    public void printCustomers(List<Customer> customers) { // duyệt danh sách Customer
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
