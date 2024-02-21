package csc241.demos;

import java.util.ArrayList;

public class ValueAndReference {
    public static void addAThing(ArrayList<String> a, String s){
        a.add(s);
    }

    public static void addOne(int i){
        i = i + 1;
    }

    public static int addOneVersion2 (int i){
        return i + 1;
    }

    public static void main(String[] args) {
        int a = 5;
        addOne(a);
        System.out.println("a: " + a); // What will print?
        a = addOneVersion2(a);
        System.out.println("a: " + a); // What will print?

        ArrayList<String> al = new ArrayList<>();
        al.add("a");
        addAThing(al, "b");
        System.out.println("al: " + al); // What will print?
    }
}
