package Lab03HCN;

public class Test {
    public static void main(String[] args) {
        ManageEmployee manageEmployee = new ManageEmployee();
        while (true){
            switch (manageEmployee.menu()){
                case 1 -> manageEmployee.addEmployee();
                case 2 -> manageEmployee.typeEmployeeList();
                case 3 -> manageEmployee.sortEmployee();
                case 4 -> manageEmployee.removeEmployee();
                case 5 -> manageEmployee.calculateSalary();
                case 0 -> {
                    System.out.println("\nOut");
                    System.exit(0);
                }
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}
