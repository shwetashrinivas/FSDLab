/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

1. Initialize an empty HashMap.
2. Iterate over the elements of the array.
3. For every element in the array - If the element exists in the Map, then check if it’s complement (target - element) also exists in the Map or not. If the complement exists then return the indices of the current element and the complement.
4. Otherwise, put the element in the Map, and move to the next iteration.
*/
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

class TwoSum {
    
    // Time complexity: O(n)
    private static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
