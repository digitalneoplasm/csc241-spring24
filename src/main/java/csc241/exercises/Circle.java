package csc241.exercises;

public class Circle extends GraphicObject{
    private double radius;

    public Circle(int x, int y, double radius){
        super(x,y);
        this.radius = radius;
    }

    @Override
    public void resize(double multiplier) {
        radius *= multiplier;
    }

    public String toString() {
        return "[x: " + x + " y: " + y + " radius: " + radius + "]";
    }

}
