package csc241.exercises;

public abstract class GraphicObject implements Movable {
    protected int x, y;

    public GraphicObject(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void resize(double multiplier);

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
