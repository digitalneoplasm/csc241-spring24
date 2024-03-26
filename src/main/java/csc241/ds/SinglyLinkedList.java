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

public class SinglyLinkedList<E> {
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

    public boolean add(int i, E data) {
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

        return true;
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

    private Node<E> getNodeAtIndex(int i){
        Node<E> temp = head;
        for (int j = 0; j < i; j++){
            temp = temp.next; // Move to the next node.
        }
        return temp;
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
