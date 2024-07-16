package DeLopQuocLong.Controller;

import DeLopQuocLong.Model.Company;
import DeLopQuocLong.Model.Customer;
import DeLopQuocLong.View.Menu;
import DeLopQuocLong.View.Validation;
import java.util.List;

public class CompanyManagerApp {
    private Company company;

    public CompanyManagerApp() {
        company = new Company();
    }

    public void run() {
        while (true) {
            Menu.displayMenu();
            int choice = Validation.getInt("Choose an option: ", 1, 6);

            switch (choice)
            {
                case 1:
                    displayAllCustomers();
                    break;
                case 2:
                    searchCustomer();
                    break;
                case 3:
                    addNewCustomer();
                    break;
                case 4:
                    customerStatistics();
                    break;
                case 5:
                    changePhoneNumber();
                    break;
                case 6:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayAllCustomers() {
        company.printCustomers(company.getCustomers());
    }

    private void searchCustomer() {
        while (true) { // always true
            Menu.displaySearchMenu();
            int choice = Validation.getInt("Choose an option: ", 1, 3);

            switch (choice) {
                case 1:
                    int id = Validation.getInt("Enter customer ID: ");
                    Customer customerByID = company.searchCustomerByID(id);
                    if (customerByID != null) {
                        System.out.println(customerByID);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 2:
                    String name = Validation.chuanHoaTen(Validation.getString("Enter customer name: "));
                    List<Customer> customersByName = company.searchCustomerByName(name);
                    if (!customersByName.isEmpty()) {
                        company.printCustomers(customersByName);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNewCustomer() {
        int id = Validation.getInt("Enter new customer ID: ");
        String name = Validation.chuanHoaTen(Validation.getString("Enter customer name: "));
        String phone = Validation.getString("Enter customer phone: ");
        String dob = Validation.getString("Enter customer date of birth (dd/MM/yyyy): ", Validation.DATE_PATTERN);
        String address = Validation.getString("Enter customer address: ");
        Customer newCustomer = new Customer(id, name, phone, dob, address);
        company.addCustomer(newCustomer);
        System.out.println("Customer added successfully.");
    }

    private void customerStatistics() {
        int year = Validation.getInt("Enter year of birth: ");
        List<Customer> customersByYear = company.getCustomersByYear(year);
        if (!customersByYear.isEmpty()) {
            company.printCustomers(customersByYear);
        } else {
            System.out.println("No customers found for the given year.");
        }
    }

    private void changePhoneNumber() {
        int id = Validation.getInt("Enter customer ID: ");
        Customer customer = company.searchCustomerByID(id);
        if (customer != null) {
            String oldPhone = Validation.getString("Enter old phone number: ");
            String newPhone = Validation.getString("Enter new phone number: ");
            customer.changePhone(oldPhone, newPhone);
            System.out.println("Phone number updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public static void main(String[] args) {
        new CompanyManagerApp().run();
    }
}
