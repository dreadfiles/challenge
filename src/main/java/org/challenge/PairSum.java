package org.challenge;

import java.util.HashSet;
import java.util.Set;

/*
    Given an array of N integers, no duplicates, and an integer K, the task is to find the number of pairs of integers in the array whose sum is equal to K.

    Input: arr[] = {1, 5, 7, 2, 4 , 6}, K = 6
    Output:  2
    Explanation: Pairs with sum 6 are (1, 5) and (2, 4)
 */
public class PairSum {

    public static int validatePairSumArray(int[] inputArray, int value) {
        int result = 0;
        Set<Integer> savedItems = new HashSet<>();

        for (int item : inputArray) {
            if (savedItems.contains(item)) {
                result++;
            }
            savedItems.add(value - item);
        }

        return result;
    }
}
