package App.Lists;

import App.Usecases.List;

public class SingleLinkedList<T> extends List<T> implements IListable<T> {

    private Node head = null;

    private class Node{
        T data;
        Node next;

        public void next(Node T) {
            this.next = next;
        }
    }


    @Override
    public void add(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    @Override
    public void addFirst(T data) {

        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head==null)
        {
            node.next(null);

            head = node;
        }else{
            node.next(head);
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void addAll (SingleLinkedList<T> list) {
        clear();
        head = list.head;
        size = list.getSize();

    }

    @Override
    public void insert(int index, T data) {

        Node node = new Node();
        node.data = data;
        node.next = null;

        if (index <1)
        {
            System.out.println("Invalid Position");
        }
        else {
            while (index < size()) {
                node.next(head);
                System.out.println("Done Successfully");
                break;
            }
        }

    }


    @Override
    public T get(int index) {
        if ((head == null) || (index < 0) || (index >= size())) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public void set(int index, T data) {

    }

    @Override
    public void remove(int index) {

        if (index >= size || index < 0)
            System.out.println("Not done");

        if (index == 0) {
            head = head.next;
            size--;
            System.out.println("Done");
        }

        Node predecessor = head;

        for (int i = 0; i < index - 1; i++) {
            predecessor = predecessor.next;
        }

        if (index < size - 1)
            predecessor.next(predecessor.next.next);
        else
            predecessor.next(null);

        size--;
        System.out.println("Done");
    }

    @Override
    public int size() {
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }


    @Override
    public void printAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public void removeFirst() {
        remove(0);

    }

    @Override
    public void removeLast() {
        remove(size - 1);

    }

}


