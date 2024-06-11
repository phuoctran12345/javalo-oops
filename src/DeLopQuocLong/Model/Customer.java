package DeLopQuocLong.Model;

public class Customer {
    private int customerID;
    private String name;
    private String phone;
    private String dob;
    private String address;

    public Customer(int customerID, String name, String phone, String dob, String address) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void changePhone(String oldPhone, String newPhone) {
        if (this.phone.equals(oldPhone)) {
            this.phone = newPhone;
        } else {
            System.out.println("Old phone number does not match.");
        }
    }


    @Override
    public String toString() {
        return String.format("| %-12s | %-20s | %-15s | %-12s | %-30s |", // định dạng cái table
                customerID, name, phone, dob, address);
    }

}
