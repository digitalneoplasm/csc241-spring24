package csc241.testers;

import csc241.objects.Bicycle;

public class BicycleTester {
    public static void main(String[] args) {
        Bicycle bike = new Bicycle(0,0,1);
        for (int i = 0; i < 10; i++) {
            bike.speedUp(1);
        }
        System.out.println("Bike Speed: " + bike.getSpeed());
    }
}
