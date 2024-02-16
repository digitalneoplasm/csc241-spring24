package csc241.ds;

public class ExpandableArray {

    /*
     * Requirements: Do something like ArrayList (indexed, ordered)
     * - Holds strings
     *
     * State:
     * private String[] - the array we're managing.
     * private static int DEFAULT_LENGTH = 10;
     * private int nrOfElements = 0;
     *
     * Constructors:
     * public ExpandableArray() - Make a new expandable array, of the default length.
     *
     * Methods:
     * - public boolean add(String s) - adds at end of the array
     *   if the array isn't big enough, expand it (somehow). Returns true.
     *   (double? half? constant value) length += length >> 1;
     * - private void expandArray() - do the expansion
     * - public boolean add(int i, String s) - add s at index i, as long as index i
     *   is <= the size of the expandable array.
     * - public String get(int i) - Return the String at index i.
     * - public boolean contains(String s) - true if s is in the ExpandableArray, else false.
     * - String remove(int i) - remove at index i, returns the removed String
     * - boolean remove(String s) - remove first occurrence of s, true if successful.
     * - String toString()
     * - int size() - number of elements in the ExpandableArray.
     */



}
