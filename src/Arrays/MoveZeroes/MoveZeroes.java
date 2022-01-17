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
                - then place value at that index at the available non-zero placement index
                - if current index != non-zero placement index then set current index to zero
                    - this "moves" the zeros to the right, while moving non-zeros to the left
                - one a non-zero value placed at non-zero placement index, increment it by one

    Read this snowball solution:
        - https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
 */

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int indexForNonZero = 0;
        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[indexForNonZero] = nums[i];
                    if (i != indexForNonZero) {
                        nums[i] = 0;
                    }
                    indexForNonZero++;

                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        int[] answer1 = {1,3,12,0,0};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(answer1));
        assertArrayEquals(nums1, answer1);

        int[] nums2 = {0};
        int[] answer2 = {0};
        assertArrayEquals(nums2, answer2);

        int[] nums3 = {1,0};
        int[] answer3 = {1,0};
        assertArrayEquals(answer3, nums3);

        System.out.println("Passed all tests!");
    }
}
