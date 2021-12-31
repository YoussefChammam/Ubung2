package App.Usecases;

import App.Interfaces.ListInterface;

public class List<T> implements ListInterface<T>{

    protected Node<T> head;
    protected int size;

    public List() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }




    @Override
    public String getAll() {
        if (head == null)
            return "There are no elements in the list..";

        StringBuffer buffer = new StringBuffer();

        Node<T> ourNode = head;

        while (ourNode != null) {

            buffer.append(ourNode.getData());
            buffer.append("\n");

            ourNode = ourNode.getNext();
        }

        return buffer.toString();
    }

    @Override
    public Node<T> getHead() {
        return head;
    }


}