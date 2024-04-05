package csc241.sorting;

import java.util.ArrayList;

public class SelectionSort {

    public static void selectionSort(ArrayList<Integer> nums) {
        // Loop until unsorted list is empty.
        // limit is index of last unsorted element.
        for (int limit = nums.size() - 1; limit >= 1; limit--) {
            // Find the index of the max value up to limit.
            Integer maxIdx = maxValueIndex(nums, limit);
            //System.out.println(nums + " limit: " + limit + " max: " + max);
            // Swap the max with the elt in last spot before limit
            swap(nums, maxIdx, limit);
        }
        // End loop
    }

    private static void swap(ArrayList<Integer> nums, Integer maxIdx, int limit) {
        // Temp variable for storing nums at limit.
        Integer limitValue = nums.get(limit);
        // Put max value where the limit was.
        nums.set(limit, nums.get(maxIdx));
        // Put limit where the max was.
        nums.set(maxIdx, limitValue);
    }

    private static Integer maxValueIndex(ArrayList<Integer> nums, int limit) {
        // Champion starts as the first element of nums.
        int champion = nums.get(0); // Initial champion!
        int champIndex = 0; // Index of champion

        // Look at each element from 1 .. up to and including limit of nums, and call it
        // the challenger.
        for (int i = 1; i <= limit; i++){
            int challenger = nums.get(i);
            // If the challenger is bigger than the champiom, it becomes the new champ!
            if (challenger > champion){
                champion = challenger;
                champIndex = i;
            }
        }

        return champIndex;
    }
}
