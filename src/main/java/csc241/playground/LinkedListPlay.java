package csc241.playground;

import csc241.ds.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedListPlay {
    public static void main(String[] args) {
        SinglyLinkedList<String> al = new SinglyLinkedList<>();
        al.add("amy");
        al.add("bob");
        al.add("chris");
        al.add("dahlia");

//        Iterator<String> it = al.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        for (String s : al) {
            System.out.println(s);
        }
    }
}
