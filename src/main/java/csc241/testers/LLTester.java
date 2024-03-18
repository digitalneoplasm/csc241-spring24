package csc241.testers;

import csc241.ds.SinglyLinkedList;

public class LLTester {
    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();

        for (int i = 0; i < 10; i++){
            ll.add(""+(char)('a'+i));
            System.out.println(ll.toString());
        }
    }
}
