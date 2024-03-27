package csc241.ds;

/*
 * Requirements: Build a linked data structure.
 * - Holds strings
 *
 * State:
 * private Node head // The head of the list.
 * private int nrOfElements = 0;
 *
 * Constructors:
 * public SinglyLinkedList() - Make a new singly linked list, with head = null.
 *
 * Methods:
 * - public boolean add(String s) - adds at beginning. Returns true.
 * - public boolean add(int i, String s) - add s at index i, as long as index i
 *   is <= the size of the linked list
 * - public String get(int i) - Return the String at index i.
 * - public boolean contains(String s) - true if s is in the list, else false.
 * - String remove(int i) - remove at index i, returns the removed String
 * - boolean remove(String s) - remove first occurrence of s, true if successful.
 * - String toString()
 * - int size() - number of elements in the list.
 */

import java.util.Collection;
import java.util.Iterator;

public class SinglyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int nrOfElements = 0;

    public SinglyLinkedList() {}

    public boolean add(E s) {
        // First elt in the linked list (head == null)
        if (head == null) {
            head = new Node<>(s);
        }
        // Otherwise...
        else {
            head = new Node<>(s, head);
        }
        nrOfElements++;
        return true;
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

    private void removeFirst() {
        if(head == null) {
            throw new RuntimeException("The list contains no elements.");
        }
        head = head.next;
    }

    private void addAfter(Node<E> previous, E data){
//        Node oldNext = previous.next;
//        Node newNode = new Node(data);
//        newNode.next = oldNext;
//        previous.next = newNode;
        // previous -> newNode -> oldNext
        Node<E> newNode = new Node<>(data, previous.next);
        previous.next = newNode;
        nrOfElements++;
    }

    @Override
    public Iterator<E> iterator() {
        return new LLIterator();
    }

    private class LLIterator implements Iterator<E> {
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
    }

    // 2 kinds of nested classes:
    // static classes - can only access static members of the outer class.
    //                - don't rely on any instance of the outer class.
    // inner class - does rely on an instance of the outer class, can
    //               access all members.
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E d){
            this.data = d;
        }

        public Node(E d, Node<E> n) {
            this.data = d;
            this.next = n;
        }
    }
}
