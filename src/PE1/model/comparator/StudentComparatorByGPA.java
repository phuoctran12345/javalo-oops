package PE1.model.comparator;

import PE1.model.Student;

import java.util.Comparator;

public class StudentComparatorByGPA  implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getGPA(), o2.getGPA());
    }
}
