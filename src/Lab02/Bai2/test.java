package Lab02.Bai2;

public class test {
    public static void main(String[] args) {
        Person p;
        test t = new test();
        p = t.scanfInfo();
        System.out.print("");
        printInfo(p);

        //c1: (chưa được tối ưu)
       //  Person p = new Person();
        /*scanfInfo(p); // gọi thông qua đối tượng của lớp test
        printInfo(p); */

    }

    public static void printInfo(Person p) {
        System.out.println("--------------------------------");
        System.out.println("| ID | Name | Male |");
        System.out.printf("| %d | %s | %b |\n", p.getId(), p.getName(), p.isGender());
    }

    // nhớ luôn cách dùng hàm nhập ni
    public static Person scanfInfo() {
        int id = Integer.parseInt(Untils.getValue("Enter id: "));
        String name = Untils.getValue("Enter name: ");
        String genderInput = Untils.getValue("Enter gender (male/female): ").toLowerCase();
        boolean gender = genderInput.equals("male");
        return new Person(id, name, gender);


        /*chưa được tối ưu
        p.setId(Integer.parseInt(Untils.getValue("Enter Id:")));
        p.setName(Untils.getValue("Enter Name:"));
        p.setGender(Boolean.getBoolean(Untils.getValue("Enter Gender :")));
        */
    }
}
