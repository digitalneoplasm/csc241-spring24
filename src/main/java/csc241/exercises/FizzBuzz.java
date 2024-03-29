package csc241.exercises;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz();
    }

    /*
    Write a method called fizzBuzz which takes no arguments.
- The method should print the numbers 1 to 100.
- For multiples of 3, print "Fizz" instead of the number.
- For multiples of 5, print "Buzz" instead of the number.
- For multiples of both 3 and 5, print "FizzBuzz" instead of the number.
     */
    public static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if ( i % 3 == 0 &&  i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if ( i % 3 == 0 ){
                System.out.println("Fizz");
            }
            else if ( i % 5 == 0 ){
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}
