package App.Algorithms;
import App.enums.SortOptions;
import App.Usecases.List;
import App.Usecases.Node;
import App.Data.Student;


public class BubbleSort extends Sort {

    private static long moves;

    public static void sort(List<Student> list, SortOptions attr) {

        long timeStart = System.nanoTime();
        moves = 0;
        long compares = 0;
        boolean hasSwapped = true;

        if (list.getSize() <= 1)
            return;
        int i = 0;

        while (i < list.getSize() && hasSwapped) {

            Node<Student> current = list.getHead();
            Node<Student> next = list.getHead().getNext();

            hasSwapped = false;

            for (int j = 0; j < list.getSize() - 1 - i; j++) {

                compares++;

                switch (attr) {
                    case Matrikelnumber:
                        if (current.getData().getMatrikelnr() > next.getData().getMatrikelnr()) {

                            swapData(current, next);
                            hasSwapped = true;
                        }
                        break;
                    case Studies:
                        if (current.getData().getStudies() > (current.getNext().getData().getStudies())) {

                            swapData(current, next);
                            hasSwapped = true;

                        }
                }
                current = next;
                next = next.getNext();

            }
            i++;
        }

        long timeEnd = System.nanoTime();
        printStatistic("BubbleSort", list.getSize(), compares, moves, timeStart, timeEnd);
    }

    private static void swapData(Node<Student> current, Node<Student> next) {

        Student tmp = current.getData();
        current.setData(next.getData());
        next.setData(tmp);

        moves++;
    }

}