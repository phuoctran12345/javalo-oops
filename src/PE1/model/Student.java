package PE1.model;

public class Student extends PE1REWORK.model.Student {
    private String ID;
    private String name;
    private int old;
    private float GPA;

    public Student() { //cứ gọi ra vì đây như là hàm interface

    }

    public Student(String ID, String name, float GPA, int old) {
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
        this.old = old;
    }

    public Student(String newID, String newName, int newOld, float newGPA) {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public float getGPA() {
        return this.GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "%-15s%-25s%-8s%-5s".formatted(this.ID, this.name, this.old, this.GPA);
    }
}
