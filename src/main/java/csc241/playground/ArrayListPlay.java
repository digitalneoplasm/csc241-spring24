package csc241.playground;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPlay {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("amy");
        al.add("bob");
        al.add("chris");
        al.add("dahlia");

        Iterator<String> it = al.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
