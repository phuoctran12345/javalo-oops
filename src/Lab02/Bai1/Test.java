package Lab02.Bai1;

import Lab02.Bai2.Untils;

public class Test {
    public static void main(String[] args) {
        Person p = scanfInfo();
        printInfo(p);
    }


    public static void printInfo(Person p) {
        System.out.println("--------------------------------");
        System.out.println("| ID | Name | Male |");
        System.out.printf("| %d | %s | %b |\n", p.getId(), p.getName(), p.isGender());
    }

    // nhớ luôn cách dùng hàm nhập ni
    public static  Person scanfInfo() {
        int id = Integer.parseInt(Lab02.Bai2.Untils.getValue("Enter id: "));
        String name = Lab02.Bai2.Untils.getValue("Enter name:");
        boolean gender = Boolean.getBoolean(Untils.getValue("Enter gender:"));

        return new Person(id , name , gender);
    }

}
