package csc241.testers;

import csc241.ds.ExpandableArray;

public class ExpandableArrayTester {
    public static void main(String[] args) {

        // Normal case.
        ExpandableArray ea = new ExpandableArray();
        ea.add("a");
        ea.add("b");
        ea.add("c");
        ea.add("d");
        System.out.println(ea);

        // Empty
        ea = new ExpandableArray();
        System.out.println(ea);

        for (int i = 0; i < 20; i++){
            ea.add("a");
            System.out.println(ea + " size: " + ea.size());
        }

        ea = new ExpandableArray();
        ea.get(1);
    }
}
