package PE1REWORK.model.comparator;

import PE1.model.Student;

import java.util.Comparator;

public class StudentComparatorByID  implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        return o1.getID().compareToIgnoreCase(o2.getID());
    };

}
