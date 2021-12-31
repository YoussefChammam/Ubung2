package App.Algorithms;

import App.enums.SortOptions;
import App.Usecases.Node;
import App.Data.Student;
import App.Lists.SingleLinkedList;

public class SelectionSort extends Sort{

    private static long compares;
    private static long moves;

    public static void sort(SingleLinkedList<Student> list, SortOptions attr) {

        SingleLinkedList<Student> result = new SingleLinkedList<>();

        compares = 0;
        moves = 0;

        long timeStart = System.nanoTime();

        if (!isSorted(list, attr)) {
            result = Selection_sort(list, attr);
            list.addAll(result);
        }

        long timeEnd = System.nanoTime();
        printStatistic("SelectionSort", list.getSize(), compares, moves, timeStart, timeEnd);

    }

    private static SingleLinkedList<Student> Selection_sort(SingleLinkedList<Student> list, SortOptions option) {
        if (list.getSize() <= 1)
            return list;

        compares++;

        SingleLinkedList<Student> left = new SingleLinkedList<>();

        SingleLinkedList<Student> right = new SingleLinkedList<>();
        int half = list.getSize() / 2;
        Node<Student> tmp = list.getHead();

        int i = 0;
        while (tmp != null) {
            if (i < half) {
                left.add(tmp.getData());
            } else {
                right.add(tmp.getData());
            }

            i++;
            tmp = tmp.getNext();


            compares++;
            moves++;
        }

        left = Selection_sort(left, option);
        right = Selection_sort(right, option);
        return selection_sort(left, right, option);
    }

    private static SingleLinkedList<Student> selection_sort(SingleLinkedList<Student> left, SingleLinkedList<Student> right,
                                                       SortOptions option) {

        SingleLinkedList<Student> result = new SingleLinkedList<>();
        while ((!left.isEmpty() && !right.isEmpty())) {
            Node<Student> leftHead = left.getHead();
            Node<Student> rightHead = right.getHead();

            switch (option) {
                case Matrikelnumber:
                    if (leftHead.getData().getMatrikelnr() <= rightHead.getData().getMatrikelnr()) {
                        result.add(left.get(0));

                        left.removeFirst();

                    } else {
                        result.add(right.get(0));
                        right.removeFirst();
                    }
                    break;

                case Studies:
                    if (leftHead.getData().getStudies() <= (rightHead.getData().getStudies())) {
                        result.add(left.get(0));
                        left.removeFirst();
                    } else {
                        result.add(right.get(0));
                        right.removeFirst();
                    }

                    break;
                default:
                    break;

            }
            compares++;
            moves++;
        }

        while (!left.isEmpty()) {
            result.add(left.get(0));
            left.removeFirst();
            moves++;
        }

        while (!right.isEmpty()) {
            result.add(right.get(0));
            right.removeFirst();

            moves++;
        }
        return result;

    }

}