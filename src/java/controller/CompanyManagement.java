package java.controller;

import java.model.Company;
import java.model.Customer;
import java.util.ArrayList;

import java.util.List;
import java.view.Menu;
import java.view.Utils;

public class CompanyManagement {
    private Company company;

    public CompanyManagement() {
        company = new Company();
    }

    public void run() {
        while (true) {
            Menu.printMenu();
            String choice = Utils.getChoice();

            switch (choice) {
                case "1":
                    displayAllCustomers();
                    break;
                case "2":
                    searchCustomer();
                    break;
                case "3":
                    addNewCustomer();
                    break;
                case "4":
                    changeCustomerPhone();
                    break;
                case "5":
                    removeCustomerByName();
                    break;
                case "6":
                    statisticsByYearOfBirth();
                    break;
                case "7":
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayAllCustomers() {
        List<Customer> customers = company.getCustomerList();// lấy từ danh sách customer
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void searchCustomer() {
        String criteria;
        do {
            try {
                criteria = Utils.getValue("Enter search criteria (Customer ID or Name): ");
                List<Customer> customers = company.getCustomerList();
                for (Customer customer : customers) {
                    if (customer.getCustomerID().equalsIgnoreCase(criteria) || customer.getName().equalsIgnoreCase(criteria)) {
                        System.out.println(customer);
                    }
                }
                // Thoát vòng lặp nếu nhập đúng
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (true);
    }

    private void addNewCustomer() {

        do {
            try {
                String customerID = Utils.getValue("Enter Customer ID: ");
                String name = Utils.getValue("Enter Name: ");
                String phone = Utils.getValue("Enter Phone: ");
                String dob = Utils.getValue("Enter Date of Birth (MM/DD/YYYY): ");
                String address = Utils.getValue("Enter Address: ");
                Customer newCustomer = new Customer(customerID, name, phone, dob, address);
                company.addCustomer(newCustomer);
                System.out.println("Customer added successfully.");
                // Thoát vòng lặp nếu nhập đúng
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please try again.");
            }
        } while (true);
    }

    private void changeCustomerPhone() {
        do {
            try {
                String customerID = Utils.getValue("Enter Customer ID to change phone: ");
                String oldPhone = Utils.getValue("Enter old phone number: ");
                String newPhone = Utils.getValue("Enter new phone number: ");
                List<Customer> customers = company.getCustomerList();
                for (Customer customer : customers) {
                    if (customer.getCustomerID().equals(customerID)) {
                        customer.changePhone(oldPhone, newPhone);
                        System.out.println("Phone number updated successfully.");
                        return;
                    }
                }
                System.out.println("Customer not found or old phone number does not match.");
                // Thoát vòng lặp nếu thay đổi thành công hoặc không tìm thấy khách hàng
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please try again.");
            }
        } while (true);
    }

    private void removeCustomerByName() {
    // Hiển thị danh sách trước khi xóa
    System.out.println("List before deletion: ");
    displayAllCustomers();

    // Nhập tên để tìm và xóa
    String nameToRemove;
    while (true) {
        try {
            nameToRemove = Utils.getValue("Enter name to remove: ");
            break; // Thoát khỏi vòng lặp khi nhập dữ liệu hợp lệ
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    // Tạo danh sách để lưu trữ các khách hàng cần xóa
    ArrayList<Customer> customersToRemove = new ArrayList<>();
    List<Customer> customers = company.getCustomerList();
    for (Customer customer : customers) {
        if (customer.getName().equalsIgnoreCase(nameToRemove)) {
            customersToRemove.add(customer);
        }
    }

    // Kiểm tra nếu không có khách hàng nào phù hợp
    if (customersToRemove.isEmpty()) {
        System.out.println("No customer with the given name found.");
    } else {
        // Xóa các khách hàng khỏi danh sách
        customers.removeAll(customersToRemove);

        // Hiển thị danh sách sau khi xóa
        System.out.println("List after deletion: ");
        displayAllCustomers();
    }
}


    private void statisticsByYearOfBirth() {
        String year;
        do {
            try {
                year = Utils.getValue("Enter year of birth (YYYY): ");
                List<Customer> customers = company.getCustomerList();
                for (Customer customer : customers) {
                    if (customer.getDob().endsWith(year)) {
                        System.out.println(customer);
                    }
                }
                // Thoát vòng lặp nếu nhập đúng
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Please try again.");
            }
        } while (true);
    }

    public static void main(String[] args) {
        CompanyManagement management = new CompanyManagement();
        management.run();
    }
}
