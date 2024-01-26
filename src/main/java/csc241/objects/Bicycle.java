package csc241.objects;

public class Bicycle {

    // the Bicycle class has three fields (instance variables)
    // These are the state!
    private int cadence;
    private int gear;
    private int speed;

    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    // the Bicycle class has five methods (behavior)
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    /**
     *
     * @param decrement
     */
    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    /**
     * Speed up by a given value.
     * @param increment the value to speed up by.
     */
    public void speedUp(int increment) {
        speed += increment;
        // Same as: speed = speed + increment;
    }
    // public - access modifier (others: private, protected)
    // void - return type
    // speedUp - method name
    // (int increment) - parameter list
    // int increment - parameter
    // int - parameter type
    // increment - parameter name

    public int getSpeed() {
        return speed;
    }

}