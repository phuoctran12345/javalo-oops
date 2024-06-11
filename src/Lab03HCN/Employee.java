package Lab03HCN;

import java.util.Date;

public class Employee {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected Date dateOfBirth;
    protected int daysWorked;
    public Employee(int id, String firstName, String lastName, int age, Date dateOfBirth, int daysWorked) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.daysWorked = daysWorked;
    }
    public double calculateSalary() {
        return 0;
    }
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Date of Birth (dd/MM/yyyy): " + dateOfBirth);
        System.out.println("Days Worked: " + daysWorked);
    }
}
