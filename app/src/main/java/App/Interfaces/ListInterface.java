package App.Interfaces;

import App.Usecases.Node;

public interface ListInterface<T> {
    public int getSize();
    public boolean isEmpty();
    public String getAll();
    public Node<T> getHead();
}
