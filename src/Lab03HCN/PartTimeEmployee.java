package Lab03HCN;
import java.util.Date;
public class PartTimeEmployee  extends Employee{
    private final double discountRate = 0.5;
    public PartTimeEmployee(int id, String firstName, String lastName, int age, Date dateOfBirth, int daysWorked, double discountRate) {
        super(id, firstName, lastName, age, dateOfBirth, daysWorked);
    }
    @Override
    public double calculateSalary() {
        return daysWorked * 1000000 * this.discountRate;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Salary: " + calculateSalary());
    }
}
