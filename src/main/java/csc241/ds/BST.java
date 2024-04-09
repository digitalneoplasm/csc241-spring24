package csc241.ds;

public class BST <T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }


    private static class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data) {
            this.data = data;
            left = right = null;
        }
    }
}
