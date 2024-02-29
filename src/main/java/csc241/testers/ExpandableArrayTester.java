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
            ea.add(""+(char)('a'+i));
            System.out.println(ea + " size: " + ea.size());
        }

        ea.add(5, "b");
        System.out.println(ea);

//        ea = new ExpandableArray();
//        ea.get(1);
    }
}
