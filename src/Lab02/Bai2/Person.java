package Lab02.Bai2;

public class Person {
    private int id;
    private String name;
    private boolean gender;;



    public void scanfInfPer() {
        this.id = Integer.parseInt(Untils.getValue("Enter Id:"));
        this.name = Untils.getValue("Enter Id:");
        this.gender= Boolean.getBoolean(Untils.getValue("Enter Id:"));
    }

    public Person(int id , String name , boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
