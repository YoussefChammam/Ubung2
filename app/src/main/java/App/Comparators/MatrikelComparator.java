package App.Comparators;

import App.Algorithms.Comparator;
import App.Data.Student;

public class MatrikelComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getMatrikelnr() - o2.getMatrikelnr() ;
    }

}