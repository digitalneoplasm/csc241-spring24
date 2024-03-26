package csc241.testers;

import csc241.ds.SinglyLinkedList;
import csc241.exercises.Rectangle;

public class LLTester {
    public static void main(String[] args) {
        SinglyLinkedList<String> ll = new SinglyLinkedList<>();

        for (int i = 0; i < 10; i++){
            ll.add(""+(char)('a'+i));
            System.out.println(ll.toString());
        }

        ll.add(10, "z");
        System.out.println(ll);
        ll.add(0, "A");
        ll.add(5, "M");
        System.out.println(ll);

        SinglyLinkedList<Rectangle> rects = new SinglyLinkedList<>();
        rects.add(new Rectangle(0,0,10,20));
        rects.add(new Rectangle(5,5,15,25));

        System.out.println(rects);

        SinglyLinkedList<SinglyLinkedList<String>> ssl = new SinglyLinkedList<>();
        ssl.add(ll);
        ssl.add(ll);

        System.out.println(ssl);
    }
}
