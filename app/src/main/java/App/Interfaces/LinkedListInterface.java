package App.Interfaces;

public interface LinkedListInterface<T> {

    public void add(T data);
    public void addAtFirst(T data);

    public void addAtLast(T data);

    public boolean remove(int index);

    public void removeFirst();

    public void removeLast();

    public void removeAll();

    public T get(int index);

    public int getSize();

    public boolean isEmpty();
}
