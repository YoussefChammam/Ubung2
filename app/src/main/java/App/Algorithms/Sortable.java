package App.Algorithms;
import App.Lists.IListable;
import java.util.List;
import App.Algorithms.Comparator;

public interface Sortable<T> {
    public void sort(IListable<T> list, Comparator<T> comp);
}
