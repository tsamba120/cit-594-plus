package Arrays.FindDuplicate;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

/*
Find the Duplicate Number | Leetcode # 0287 | Medium
https://leetcode.com/problems/find-the-duplicate-number/

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
 */

/*
SOLUTION NOTES
    Constant Extra Space restriction:
        - Space needed is NOT proportional to the size of the problem

    Naive solution:
        - Initial HashSet and continually add integers to structure
        - If number already exists in HashSet, then return that number as it is the duplicate
        - Does not work however as this answer is not in constant extra space

 */

public class FindDuplicate {
    public static int findDuplicate(int nums[]) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,4,2,2};
        int answer1 = 2;
        assertEquals(answer1, findDuplicate(nums1));

        int[] nums2 = {3,1,3,4,2};
        int answer2 = 3;
        assertEquals(answer2, findDuplicate(nums2));
    }
}
