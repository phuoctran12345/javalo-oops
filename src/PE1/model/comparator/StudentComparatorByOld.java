package PE1.model.comparator;

import PE1.model.Student;

import java.util.Comparator;

public class StudentComparatorByOld implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        return o1.getOld() - o2.getOld();
    }
}
