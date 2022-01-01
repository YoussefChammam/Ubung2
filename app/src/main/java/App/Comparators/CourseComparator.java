package App.Comparators;

import App.Data.Student;
import App.Algorithms.Comparator;

public class CourseComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getStudies() - o2.getStudies();
    }

}