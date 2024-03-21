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

public class SinglyLinkedList {
    private Node head;
    private int nrOfElements = 0;

    public SinglyLinkedList() {}

    public boolean add(String s) {
        // First elt in the linked list (head == null)
        if (head == null) {
            head = new Node(s);
        }
        // Otherwise...
        else {
            head = new Node(s, head);
        }
        nrOfElements++;
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

        for (Node temp = head; temp != null; temp = temp.next){
            result.append(temp.data).append(" ");
        }

        return result.toString();
    }

    private Node getNodeAtIndex(int i){
        Node temp = head;
        for (int j = 0; j < i; j++){
            temp = temp.next; // Move to the next node.
        }
        return temp;
    }

    private void addAfter(Node previous, String data){
//        Node oldNext = previous.next;
//        Node newNode = new Node(data);
//        newNode.next = oldNext;
//        previous.next = newNode;
        // previous -> newNode -> oldNext
        Node newNode = new Node(data, previous.next);
        previous.next = newNode;

    }

    // 2 kinds of nested classes:
    // static classes - can only access static members of the outer class.
    //                - don't rely on any instance of the outer class.
    // inner class - does rely on an instance of the outer class, can
    //               access all members.
    private static class Node {
        private String data;
        private Node next;

        public Node(String d){
            this.data = d;
        }

        public Node(String d, Node n) {
            this.data = d;
            this.next = n;
        }
    }
}
