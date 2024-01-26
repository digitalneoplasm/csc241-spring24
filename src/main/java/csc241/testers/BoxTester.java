package csc241.testers;

import csc241.exercises.Box;

import java.awt.*;

public class BoxTester {
    public static void main(String[] args) {
        System.out.println("Sides in a box: " + Box.sides());

        Box box = new Box(2,2,2, Color.WHITE);
        System.out.println("Volume of the box: " + box.volume());
    }
}
