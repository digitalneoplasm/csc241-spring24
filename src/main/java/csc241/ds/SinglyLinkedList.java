package csc241.ds;

public class SinglyLinkedList {
    private Node head;

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
