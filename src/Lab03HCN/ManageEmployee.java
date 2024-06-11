package Lab03HCN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ManageEmployee {
    ArrayList<Employee> employees = new ArrayList<>();
    int numberOfFullTimeEmployee, numberOfPartTimeEmployee;
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public void addEmployee(){
        System.out.println("enter number of parttime employee: ");
        numberOfPartTimeEmployee = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfPartTimeEmployee; i++) {
            System.out.println("information employee parttime number " + i + " : ");
            System.out.print("ID: ");
            int ptId = scanner.nextInt();
            System.out.print("First Name: ");
            String ptFirstName = scanner.next();
            System.out.print("Last Name: ");
            String ptLastName = scanner.next();
            System.out.print("Age: ");
            int ptAge = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Date of Birth: ");
            String ptDateOfBirthString = scanner.nextLine();

            Date ptDateOfBirth = null;
            try {
                ptDateOfBirth = dateFormat.parse(ptDateOfBirthString);
            } catch (ParseException e) {
                System.out.println("invalid");
                System.exit(0);
            }

            System.out.print("Days Worked: ");
            int ptDaysWorked = scanner.nextInt();
            System.out.print("Discount Rate: ");
            double ptDiscountRate = scanner.nextDouble();
            scanner.nextLine();
            PartTimeEmployee partTimeEmployee = new PartTimeEmployee(ptId, ptFirstName, ptLastName, ptAge, ptDateOfBirth, ptDaysWorked, ptDiscountRate);
            employees.add(partTimeEmployee);
        }
        System.out.println("enter number of fulltime employee: ");
        numberOfFullTimeEmployee = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfFullTimeEmployee; i++) {
            System.out.println("information employee fulltime number " + i + " : ");
            System.out.print("ID: ");
            int ftId = scanner.nextInt();
            System.out.print("First Name: ");
            String ftFirstName = scanner.next();
            System.out.print("Last Name: ");
            String ftLastName = scanner.next();
            System.out.print("Age: ");
            int ftAge = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Date of Birth: ");
            String ftDateOfBirthString = scanner.nextLine();

            Date ftDateOfBirth = null;
            try {
                ftDateOfBirth = dateFormat.parse(ftDateOfBirthString);
            } catch (ParseException e) {
                System.out.println("invalid");
                System.exit(0);
            }

            System.out.print("Days Worked: ");
            int ftDaysWorked = scanner.nextInt();
            System.out.print("Overtime Hours: ");
            int ftOvertimeHours = scanner.nextInt();
            scanner.nextLine();
            FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(ftId, ftFirstName, ftLastName, ftAge, ftDateOfBirth, ftDaysWorked, ftOvertimeHours);
            employees.add(fullTimeEmployee);
        }
    }

    public void typeEmployeeList(){
        System.out.println("\nEmployee List by Type:");
        for (Employee employee : employees) {
            if (employee instanceof PartTimeEmployee) {
                System.out.println("\nPart-Time Employee:");
            } else if (employee instanceof FullTimeEmployee) {
                System.out.println("\nFull-Time Employee:");
            }
            employee.displayInfo();
        }
    }
    public void sortEmployee() {
        System.out.println("\nSorted Employee List by Salary (Descending):");
        Collections.sort(employees, (Employee employee1, Employee employee2) -> {
            double salary1 = employee1.calculateSalary();
            double salary2 = employee2.calculateSalary();
            return Double.compare(salary2, salary1);
        });
        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }
    public void removeEmployee(){
        System.out.print("\nEnter the name of the employee you want to remove: ");
        String nameToRemove = scanner.next();
        boolean removed = false;
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.firstName.equalsIgnoreCase(nameToRemove) || employee.lastName.equalsIgnoreCase(nameToRemove)) {
                employees.remove(i);
                removed = true;
            }
        }
        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
        scanner.nextLine();
    }
    public void calculateSalary(){
        long partTimeSalarySum = 0;
        long fullTimeSalarySum = 0;
        int partTimeCount = 0;
        int fullTimeCount = 0;
        for (Employee employee : employees) {
            if (employee instanceof PartTimeEmployee) {
                partTimeSalarySum += employee.calculateSalary();
                partTimeCount++;
            } else if (employee instanceof FullTimeEmployee) {
                fullTimeSalarySum += employee.calculateSalary();
                fullTimeCount++;
            }
        }
        long partTimeAverageSalary = partTimeSalarySum / partTimeCount;
        long fullTimeAverageSalary = fullTimeSalarySum / fullTimeCount;
        System.out.println("\nAverage Salary for Each Employee Type:");
        System.out.println("Part-Time Employee: " + partTimeAverageSalary);
        System.out.println("Full-Time Employee: " + fullTimeAverageSalary);
    }
    public int menu(){
        System.out.println("\nEmployee Management System");
        System.out.println("1. Enter employee information");
        System.out.println("2. Display employee list by type");
        System.out.println("3. Sort employees by salary (descending) and display");
        System.out.println("4. Find and remove employee by name");
        System.out.println("5. Calculate average salary for each employee type");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

}
