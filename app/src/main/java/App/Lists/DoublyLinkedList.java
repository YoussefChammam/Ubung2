package App.Lists;

import App.Interfaces.DoublyLinkedListInterface;
import App.Usecases.List;
import App.Usecases.Node;


public class DoublyLinkedList<T> extends List<T> implements DoublyLinkedListInterface<T> {
    private Node<T> tail;

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail){
        this.tail = tail;
    }

    public void addAtLast(T data){
        Node<T> node = new Node<T>(data);
        insertLast(node);
    }


    public void add(T data) {
    }

    public void addAtFirst(T data){
        Node<T> node = new Node<T>(data);
        insertFirst(node);
    }

    public void addEverything(DoublyLinkedList<T> list){
        removeAll();
        head = list.getHead();
        tail = list.getTail();
        size = list.getSize();

    }

    public boolean remove(int index){

        if (index >= size || index < 0){
            return false;
        }

        if (index == size - 1) {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            size--;
            return true;
        }

        Node<T> prev;

        if (size - index > size / 2) {

            prev = head;

            for (int i = 0; i < index - 1; i++) {
                prev = prev.getNext();
            }

            delete(prev);

        } else {

            prev = tail;
            int steps = size - index;
            for (int i = 0; i < steps; i++) {
                prev = prev.getPrev();
            }

            delete(prev);

        }
        size--;

        return true;
    }

    private void delete(Node<T> prev) {
        Node<T> tmp = prev.getNext().getNext();
        tmp.setPrev(prev);
        prev.setNext(tmp);
    }

    @Override
    public void removeFirst() {
        remove(0);

    }

    @Override
    public void removeLast() {

        remove(size - 1);

    }

    @Override
    public void removeAll() {
        head = null;
        tail = null;
        size = 0;

    }
    private void insertFirst(Node<T> node) {

        if (head == null) {
            node.setNext(null);
            node.setPrev(null);
            tail = node;
        }
        else {
            node.setNext(head);
            head.setPrev(node);
        }
        head = node;
        size++;
    }

    private void insertLast(Node<T> node) {
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            node.setNext(null);
            tail = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            return null;

        if (index == 0)
            return head.getData();
        if (index == size - 1)
            return tail.getData();
        Node<T> current;
        if (size - index > size / 2) {
            current = head;
            for (int i = 0; i <= index - 1; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            int steps = size - index - 1;
            for (int i = 0; i < steps; i++) {
                current = current.getPrev();
            }
        }
        return current.getData();
    }

}

