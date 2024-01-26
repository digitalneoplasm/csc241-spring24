package csc241.exercises;

public class Account {
    // number of objects created
    private static int objectCount = 0;
    private final int id;
    public Account (){
        // increment count and assign ID.
        id = ++objectCount;
    }
    public static int getCount (){
        return objectCount;
    }

    public int getAccountNumber() {
        return id;
    }
}