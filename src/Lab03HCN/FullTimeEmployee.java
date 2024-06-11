package Lab03HCN;

import java.util.Date;
public class FullTimeEmployee extends Employee{
    private int overtimeHours;
    public FullTimeEmployee(int id, String firstName, String lastName, int age, Date dateOfBirth, int daysWorked, int overtimeHours) {
        super(id, firstName, lastName, age, dateOfBirth, daysWorked);
        this.overtimeHours = overtimeHours;
    }
    @Override
    public double calculateSalary() {
        return daysWorked * 1000000 + overtimeHours * 100000;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Overtime Hours: " + overtimeHours);
        System.out.println("Salary: " + calculateSalary());
    }
}
