package csc241.ds;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class DoubleLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int nrOfElements = 0;

    public DoubleLinkedList() {}

    private void addAfter(Node<E> previous, E data){
        Node<E> newNode = new Node<>(data);
        newNode.next = previous.next;
        newNode.previous = previous;
        previous.next = newNode;
        newNode.next.previous = newNode;
        if (previous == tail) {
            tail = newNode;
        }
        nrOfElements++;
    }

    public boolean add(E s) {
        // First elt in the linked list (head == null)
        if (head == null) {
            head = tail = new Node<>(s);
        }
        // Otherwise...
        else {
            Node<E> newNode = new Node<>(s);
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        nrOfElements++;
        return true;
    }

    public void addFirst(E data) {
        add(data);
    }

    public void addLast(E data) {
        if (head == null) {
            head = tail = new Node<>(data);
        }
        else {
            Node<E> newNode = new Node<>(data);
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        nrOfElements++;
    }

    public void add(int i, E data) {
        if (i < 0 || i > nrOfElements) {
            throw new IndexOutOfBoundsException();
        }
        // Case 1: i == 0
        if (i == 0)
            add(data);

        // Case 2: i > 0
        if (i > 0) {
            // Get the node before the one at index i.
            Node<E> before = getNodeAtIndex(i-1);
            addAfter(before, data);
        }
    }



    public int size() {
        return nrOfElements;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        // head = head.next;
        // Create a temporary node.
//        Node temp = head;
//        // While temp is non-null...
//        while (temp != null) {
//            result.append(temp.data).append(" ");
//            temp = temp.next; // Go to the next node.
//        }

        for (Node<E> temp = head; temp != null; temp = temp.next){
            result.append(temp.data).append(" ");
        }

        return result.toString();
    }

    public boolean contains(Object o) {
        Node<E> temp = head;
        while (temp != null) {
            if (temp.equals(o)) return true;
            temp = temp.next;
        }
        return false;
    }

    public boolean containsAll(Collection<?> c){
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    private Node<E> getNodeAtIndex(int i){
        Node<E> temp = head;
        for (int j = 0; j < i; j++){
            temp = temp.next; // Move to the next node.
        }
        return temp;
    }

    public E get(int i) {
        return getNodeAtIndex(i).data;
    }

    private void removeAfter(Node<E> n) {
        if (n.next == null) {
            throw new RuntimeException("No next element to remove.");
        }
        n.next = n.next.next;
    }

    public E removeFirst() {
        if(head == null) {
            throw new RuntimeException("The list contains no elements.");
        }
        E data = head.data;
        if (head == tail) {
            head = tail = null;
        }
        else {
            head = head.next;
            head.previous = null;
        }
        nrOfElements--;
        return data;
    }

    public E removeLast() {
        if (tail == null) {
            throw new RuntimeException("The list contains no elements.");
        }
        E data = tail.data;
        if (head == tail) {
            head = tail = null;
        }
        else {
            tail = tail.previous;
            tail.next = null;
        }
        nrOfElements--;
        return data;
    }

    @Override
    public Iterator<E> iterator() {
        return new LLIterator();
    }

    private class LLIterator implements ListIterator<E> {
        Node<E> current = null;

        public LLIterator() {

        }

        @Override
        public boolean hasNext() {
            if (current == null && head != null)
                return true;
            if (current != null && current.next != null)
                return true;
            return false;
        }

        @Override
        public E next() {
            if (current == null && head != null) {
                current = head;
                return current.data;
            }
            if (current != null && current.next != null) {
                current = current.next;
                return current.data;
            }
            throw new RuntimeException("No next.");
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }

    // 2 kinds of nested classes:
    // static classes - can only access static members of the outer class.
    //                - don't rely on any instance of the outer class.
    // inner class - does rely on an instance of the outer class, can
    //               access all members.
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> previous;

        public Node(E d){
            this.data = d;
        }
    }
}
