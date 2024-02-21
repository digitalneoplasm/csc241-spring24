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

    private String[] arr;
    private static int DEFAULT_LENGTH = 10;
    private int nrOfElements = 0;

    public ExpandableArray() {
        arr = new String[DEFAULT_LENGTH];
    }

    public boolean add(String s) {
        // Where are we putting s?
        // - Add at nrOfElements.
        // - Increment nrOfElements.

        // But! If nrOfElements == arr.length
        // - Make a new array (newArr) size: arr.length + arr.length >> 1
        // - Copy over the elements
        // - arr = newArr
        // - Do our add.
        if (nrOfElements == arr.length) {
            String[] newArr = new String[arr.length + (arr.length >> 1)];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[nrOfElements] = s;
        nrOfElements++;

        return true;
    }

    public String get(int i) {
        // Error cases:
        // 1) i is too big. i > nrOfElements - 1
        if (i > nrOfElements - 1){
            throw new IndexOutOfBoundsException(i + " is greater than " + (nrOfElements));
        }
        // 2) i is too small. i < 0
        if (i < 0) {
            throw new IndexOutOfBoundsException("i < 0");
        }
        return arr[i];
    }

    public int size() {
        return nrOfElements;
    }

    public String toString() {
        if (nrOfElements == 0){
            return "[]";
        }
        String ret = "[";
        for (int i = 0; i < nrOfElements - 1; i++){
            ret += arr[i] + ", ";
        }
        ret += arr[nrOfElements - 1] + "]";
        return ret;
    }



}
