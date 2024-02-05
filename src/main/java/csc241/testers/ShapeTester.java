package csc241.testers;

import csc241.exercises.Circle;
import csc241.exercises.GraphicObject;
import csc241.exercises.Rectangle;

import java.util.ArrayList;

public class ShapeTester {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(0,0, 3, 2);
        //System.out.println(r1);
        r1.moveTo(10,10);
        //System.out.println(r1);

        Circle c1 = new Circle(10,10,3);
        Circle c2 = new Circle(20,20,5);

        ArrayList<GraphicObject> shapes = new ArrayList<>();
        shapes.add(r1);
        shapes.add(c1);
        shapes.add(c2);
        displayShapes(shapes);
    }

    public static void displayShapes(ArrayList<GraphicObject> shapes){
        for (GraphicObject g : shapes){
            System.out.println(g);
        }
        System.out.println("Double the sizes...");
        for (GraphicObject g : shapes) {
            g.resize(2);
        }
        for (GraphicObject g : shapes){
            System.out.println(g);
        }
    }


}
