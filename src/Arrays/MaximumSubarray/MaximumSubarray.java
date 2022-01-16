package Arrays.MaximumSubarray;

import org.junit.*;

import static java.lang.Math.max;
import static org.junit.Assert.*;

/**
 * Maximum Subarray | Leetcode #0278 | Easy
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 */

/**
 * Solution Notes by _______
 *
 */

public class MaximumSubarray {

  public static int maxSubArray(int[] nums) {
    // initializes first value in list as current sum and maximum sum
    int curSum = nums[0];
    int maxSum = curSum;

    // iterate through second and more values in list
    for (int i = 1; i < nums.length; i++) {
      // curSum is maximum of previous curSum + current value OR just the current value
        // this "disposes the garbage" if the previous values were too negative
      curSum = max(curSum + nums[i], nums[i]);
      // compares maximum between curSum and existing maxSum
      maxSum = max(curSum, maxSum);

    }
    return maxSum;
  }

  @Test
  public static void main(String[] args) {

    int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    assertEquals(6, maxSubArray(nums1));

    int[] nums2 = { 1 };
    assertEquals(1, maxSubArray(nums2));

    int[] nums3 = { 5, 4, -1, 7, 8 };
    assertEquals(23, maxSubArray(nums3));

  }
}
