package Lab02.Bai3;


public class test {

    public static void main(String[] args) {

        // Khởi tạo 2 đối tượng của lớp Person
        Person person1 = new Person(1, "Nguyen Van Nam", true);
        Person person2 = new Person(2, "Nguyen Van Na", false);

        Person[] perArr  = new Person[4];
        perArr[0] = person1;
        perArr[1] = person2;

        for (int i = 2 ; i < perArr.length; i++ ){
            System.out.println("Enter detail of person [" + (i+1) + "]");
            perArr[i] = scanfInfo();
        }

        //in ra từng phần tử trong mảng
        System.out.println("\nThe persons in the arrays: ");
        for (Person person  : perArr) {
            printInfo(person);
        }
    }

    public static void printInfo(Person p) {
        System.out.println("--------------------------------");
        System.out.println("| ID | Name | Male |");
        System.out.printf("| %d | %s | %b |\n", p.getId(), p.getName(), p.isGender());
    }


    public static Person scanfInfo() {
        int id = Integer.parseInt(Untils.getValue("Enter id: "));
        String name = Untils.getValue("Enter name: ");
        String genderInput = Untils.getValue("Enter gender (male/female): ").toLowerCase();

        boolean gender = "male".equals(genderInput);

        return new Person(id, name, gender);
    }
}
