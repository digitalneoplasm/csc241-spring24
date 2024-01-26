package csc241.exercises;

import java.awt.*;

public class Box {
    private double length, width, height;
    private Color color;

    // All Boxes have 6 sides, so this can be static.
    private static int sides = 6;

    public Box(double l, double w, double h, Color color){
        length = l;
        width = w;
        height = h;
        this.color = color;
    }

    public double volume() {
        return length * width * height;
    }

    public static int sides() {
        return sides;
    }



}
