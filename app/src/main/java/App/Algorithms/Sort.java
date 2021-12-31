package App.Algorithms;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import App.enums.SortOptions;
import App.Usecases.List;
import App.Usecases.Node;
import App.Data.Student;

public class Sort {

    protected static boolean isSorted(List<Student> list, SortOptions option) {

        long compares = 0;
        long moves = 0;

        long timeStart = System.nanoTime();

        boolean isSorted = true;

        Node<Student> current = list.getHead();

        while (current.getNext() != null && isSorted) {

            switch (option) {

                case Matrikelnumber:

                    if (current.getData().getMatrikelnr() > current.getNext().getData().getMatrikelnr())
                        isSorted = false;

                    break;

                case Studies:
                    if (current.getData().getStudies() > (current.getNext().getData().getStudies()))
                        isSorted = false;
                    break;
            }
            current = current.getNext();
            compares++;

        }

        long timeEnd = System.nanoTime();

        printStatistic("isSorted", list.getSize(), compares, moves, timeStart, timeEnd);

        return isSorted;

    }

    protected static void printStatistic(String algorithms, int size, long compares, long moves, long timeStart,
                                         long timeEnd) {

        long sum = compares + moves;

        System.out.println("-----------------------------------------");

        System.out.println("stats " + algorithms + ":");

        System.out.printf("Size(list) n\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(size));

        System.out.printf("Compares\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(compares));
        System.out.printf("Swaps / Moves\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(moves));

        System.out.printf("Total:\t\t%s\n", NumberFormat.getNumberInstance(Locale.GERMAN).format(sum));

        System.out.printf("Time:\t\t%s s\n", TimeUnit.NANOSECONDS.toSeconds(timeEnd - timeStart));

        System.out.println("\"-----------------------------------------");
    }

}
