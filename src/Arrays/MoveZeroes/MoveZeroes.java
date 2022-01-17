package Arrays.MoveZeroes;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

/*
Move Zeroes | Leetcode #0283 | Easy

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
 */

/*
Solution Notes
    O(n) solution
        - Initialize a variable for an available non-zero placement index - starts at 0
        - Iterate through the array indices
            - if the value at the index is non-zero,
                - save non-zero value as variable "val"
                - set value at that index as 0
                - set value at available non-zero placement index as val
                - if non-zero index = current index, this is account for by order of value setting and saving value into "val"
                - one a non-zero value placed at non-zero placement index, increment it by one

    Read this snowball solution:
        - https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
        - this performs a type of iterative swapping
        - except that if two zeros are next to eachother (or more) it tracks the size of the group
        - when the next non-zero value arrives
            - swap the non-zero value with the left-most zero value in the snowball
 */

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int indexForNonZero = 0;
        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int val = nums[i];
                    nums[i] = 0;
                    nums[indexForNonZero] = val;
                    indexForNonZero++;
                }
            }
        }
    }

    /*
    Optimal solution that tracks number of snowballs
    Solves for iterative swap problem when two zeros are next to each other
    When this occurs, we swap the non-zero with the left-most zero in the snowball
     */
    public static void snowballZeroes(int[] nums) {
        int snowballSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowballSize++;
            } else if (nums[i] != 0) {
                int val = nums[i];
                nums[i] = 0;
                nums[i - snowballSize] = val;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        int[] answer1 = {1,3,12,0,0};
        moveZeroes(nums1);
        assertArrayEquals(nums1, answer1);

        int[] numsSnowball1 = {1,3,12,0,0};
        snowballZeroes(numsSnowball1);
        assertArrayEquals(nums1, answer1);


        int[] nums2 = {0};
        int[] answer2 = {0};
        assertArrayEquals(nums2, answer2);

        int[] numsSnowball2 = {0};
        snowballZeroes(numsSnowball2);
        assertArrayEquals(answer2, numsSnowball2);

        int[] nums3 = {1,0};
        int[] answer3 = {1,0};
        assertArrayEquals(answer3, nums3);

        int[] numsSnowball3 = {1,0};
        snowballZeroes(numsSnowball3);
        assertArrayEquals(answer3, numsSnowball3);

        System.out.println("Passed all tests!");
    }
}
