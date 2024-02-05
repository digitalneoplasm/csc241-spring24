package csc241.exercises;

public class Rectangle extends GraphicObject{
    private double length;
    private double width;

    public Rectangle(int x, int y, double length, double width){
        super(x,y);
        this.length = length;
        this.width = width;
    }

    @Override
    public void resize(double multiplier) {
        length *= multiplier;
        width *= multiplier; // width = width * multiplier;
    }

    public String toString() {
        //return super.toString() + " [length: " + length + " width: " + width + "]";
        return "[x: " + x + " y: " + y + " length: " + length + " width: " + width + "]";
    }

}
