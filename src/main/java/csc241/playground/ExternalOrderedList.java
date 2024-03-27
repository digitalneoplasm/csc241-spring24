package csc241.playground;

import csc241.ds.SinglyLinkedList;

public class ExternalOrderedList<E extends Comparable<E>> {
    SinglyLinkedList<E> linkedList;

    public ExternalOrderedList() {
        linkedList = new SinglyLinkedList<E>();
    }

    // Add using Insertion Sort.
    public void add(E element) {
        // Adding at start if size > 0, or adding in middle.
        for (int i = 0; i < linkedList.size(); i++) {
            // Check if the element at index i is greater than our element. If so, we need to add before that element.
            if (linkedList.get(i).compareTo(element) > 0) {
                linkedList.add(i, element);
                return;
            }
        }
        // Adding at start if size == 0, or adding at the end.
        linkedList.add(linkedList.size(), element);
    }

    public String toString() {
        return linkedList.toString();
    }

    public static void main(String[] args) {
        ExternalOrderedList<String> eol = new ExternalOrderedList<>();
        eol.add("bob");
        eol.add("dahlia");
        eol.add("chris");
        eol.add("amy");
        System.out.println(eol);
    }

}
