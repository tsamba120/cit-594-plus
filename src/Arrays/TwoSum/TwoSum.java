package Arrays.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.*;
import static org.junit.Assert.*;

/*
  Two Sum | Leetcode #0001 | Medium
  https://leetcode.com/problems/two-sum/

  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.
  You can return the answer in any order.
 */

/**
 * Solution Notes by _______
 * Used hashmap to store values in memory and keeping the algorithm in linear time
 * More efficient than looping through array for each index which would have an exponential time
 */

public class TwoSum {

    public static int[] twoSum(int nums[], int target) {
        // iterate through array get each values corresponding match such that: value + match = target
        // store in HashMap -> {match_needed: original_index}

        HashMap<Integer, Integer> targetMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int matchNeeded = target - value;

            // if current value exists in map (aka it matches something) return array with both values
            if (targetMap.containsKey(value)){
                return new int[] {targetMap.get(value), i};
            }
            // else if match not in map then add match and index of home value
            else if (!targetMap.containsKey(matchNeeded)) {
                // {matchNeeded, index}
                targetMap.put(matchNeeded, i);
            }
        }
        return new int[0];
    }

    @Test
    public static void main(String[] args) {

        int[] nums1 = { 2, 7, 11, 15 };
        int[] result1 = twoSum(nums1, 9);
        Arrays.sort(result1); // Sort to ensure assert works
        int[] expected1 = { 0, 1 };
        assertArrayEquals(expected1, result1);

        int[] nums2 = { 3, 2, 4 };
        int[] result2 = twoSum(nums2, 6);
        Arrays.sort(result2); // Sort to ensure assert works
        int[] expected2 = { 1, 2 };
        assertArrayEquals(expected2, result2);

        int[] nums3 = { 3, 3 };
        int[] result3 = twoSum(nums3, 6);
        Arrays.sort(result3); // Sort to ensure assert works
        int[] expected3 = { 0, 1 };
        assertArrayEquals(expected3, result3);

    }
}
