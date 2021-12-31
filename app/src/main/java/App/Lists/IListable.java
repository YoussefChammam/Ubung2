package App.Lists;

import App.Usecases.Node;

public interface IListable<T> {

    void add(T data);

    void insert(int index, T data);

    void addFirst(T data);

    void addLast(T data);

    T get(int index);

    void set(int index, T data);

    void remove (int index);

    void clear();

    int size();

    void printAll();

    boolean isEmpty();

    public void removeFirst();

    public void removeLast();

}
