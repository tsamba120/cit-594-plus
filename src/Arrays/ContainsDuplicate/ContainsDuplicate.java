package Arrays.ContainsDuplicate;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/*
Contains Duplicate | Leetcode #0217 | Easy
https://leetcode.com/problems/contains-duplicate/

Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
 */

/*
Solution Notes:
    First Attempt:
        - Converted the entire array into a set
        - Compared length of set and array
        - If set was shorter than array, then duplicate existed -> return true
        - NOTE: this was longer and took more memory
            - Solution would iterate through full array
            - We don't need to do this though. Instead once we see a single duplicate even w/o
                full traversal, we can return true
    Second Attempt:
        - Initialized empty HashSet -> numSet
        - For loop through integer array
            - if the integer is not in numSet, add it
            - else if integer already exists in numSet (so a duplicate), return true
            - return false if runs through entire algorithm
        - NOTE: this solution is much faster and takes less memory
            - Because it was in O(n) and took much less memory bc did not need to use whole array
 */

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<Integer>();
        for (int i : nums) {
            if (numSet.contains(i)) {
                return true;
            } else {
                numSet.add(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        boolean expectedAnswer1 = true;
        assertEquals(expectedAnswer1, containsDuplicate(nums1));

        int[] nums2 = {1,2,3,4};
        boolean expectedAnswer2 = false;
        assertEquals(expectedAnswer2, containsDuplicate(nums2));

        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        boolean expectedAnswer3 = true;
        assertEquals(expectedAnswer3, containsDuplicate(nums3));

        System.out.println("Passed all tests!");
    }
}