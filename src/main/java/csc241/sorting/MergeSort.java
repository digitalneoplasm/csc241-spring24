package csc241.sorting;

public class MergeSort {

    private static void merge(int[] left, int[] right, int[] result){
        // Three counters
        // l, r, c - all start at 0
        int l = 0, r = 0, c = 0;

        // Stage 1: Still have items in both left and right.
        while ( l < left.length && r < right.length){
            // if left at l is less than right at r,
            // result at c gets the value of left at l.
            // increment l and c.
            if (left[l] < right[r]) {
                //result[c++] = left[l++];
                result[c] = left[l];
                c = c + 1;
                l = l + 1;
            }
            // else
            // result at c gets the value of right at r.
            // increment r and c.
            else {
                result[c] = right[r];
                c = c + 1;
                r = r + 1;
            }
        }

        // while left still has elements...
        // copy into result.
        while (l < left.length){
            result[c] = left[l];
            c = c + 1;
            l = l + 1;
        }

        // while right still has elements...
        // copy into result.
        while (r < right.length){
            result[c] = right[r];
            c = c + 1;
            r = r + 1;
        }
    }

    public static void mergeSort(int[] arr) {
        // Split arr into left and right, as long as arr length > 1.
        // call mergeSort on left and right side.
        // merge the left and right, store result in arr.
    }

    public static void main(String[] args) {
        int[] left = {10, 44, 56, 88};
        int[] right = {13, 36};
        int[] result = new int[6];

        merge(left, right, result);

        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
