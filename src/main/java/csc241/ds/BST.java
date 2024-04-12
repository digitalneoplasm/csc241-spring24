package csc241.ds;

public class BST <E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public boolean find(E value) {
        return find(value, root);
    }

    private boolean find(E value, Node<E> currentRoot) {
        if (currentRoot == null) {
            return false;
        }
        if (value.compareTo(currentRoot.data) == 0) {
            return true;
        }
        else if (value.compareTo(currentRoot.data) < 0) {
            return find(value, currentRoot.left); // look left
        }
        else if (value.compareTo(currentRoot.data) > 0) {
            return find(value, currentRoot.right); // look right
        }
        return false;
    }

    public void insert(E value) {
        root = insert(value, root);
    }

    private Node<E> insert(E value, Node<E> currentRoot){
        // if currentRoot is null, "replace" currentRoot with new node containing value.
        if (currentRoot == null) {
            return new Node<E>(value);
        }
        // else if value == currentRoot.data, do nothing.
        else if ( currentRoot.data.equals(value) ) {
            return currentRoot;
        }
        // else if value < currentRoot.data, recursively insert in left subtree
        else if (value.compareTo(currentRoot.data) < 0) {
            // Set the left of the currentRoot to be the result of inserting on the left
            // of the currentRoot.
            currentRoot.left = insert(value, currentRoot.left);
            return currentRoot;
        }
        // else if value > currentRoot.data, recursively insert in right subtree
        else if (value.compareTo(currentRoot.data) > 0) {
            currentRoot.right = insert(value, currentRoot.right);
            return currentRoot;
        }
        return currentRoot;
    }

    /*
    Remove Method (you implement!)
    1) if the root is null,
        The item is not in tree – return null.
    2) Compare the value to the data at the current root.
        a) if the value is less than the data at the current root,
            Return the result of removing from the left subtree.
        b) else if the value is greater than the current root
            Return the result of removing from the right subtree.
        c) else // The value is current root's data
            i) if the current root has no children
                Set the parent of the current root to null.
            ii) else if the current root has one child
                Set the parent of the current root to reference that child.
            iii) else
                Find the in-order prececessor, p.
                Set current root's value to be p's value.
                Remove p.
     */

    public String toString() {
        if (root != null) {
            return root.toString();
        }
        else return "Empty tree";
    }



    private static class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data) {
            this.data = data;
            left = right = null;
        }

        public String toString() {
            String result = "";
            if (left != null) {
                result += left.toString();
            }
            result += data.toString() + " ";
            if (right != null) {
                result += right.toString();
            }
            return result;
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.insert(20);
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(40);
        bst.insert(30);
        bst.insert(100);
        bst.insert(12);
        System.out.println(bst);
        System.out.println(bst.find(12));
        System.out.println(bst.find(20));
        System.out.println(bst.find(100));
        System.out.println(bst.find(300));
    }
}
