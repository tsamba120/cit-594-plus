package Arrays.BestTimeStock;
import org.junit.*;
import static org.junit.Assert.*;
import java.lang.Math;
/*
Best Time to Buy and Sell Stock | Leetcode #0121 | Easy

You are given an array prices where prices[i] is the price
of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.
 */

/*
Solution Notes:
    Naive Solution:
        - Exponential time solution - O(N^2)
        - Time Limit Exceeded in LeetCode!

    Optimized Solution - O(N): (Next: research Kadane's Algorithm for dynamic programming)
        - Initialize minVal as first price value
        - Initialize maxProfit as 0
        - Iterate through each price
            - Get minVal is minimum between current minVal and current price
            - Current profit = current price - minVal
            - Get max between current profit and max profit thus far
        - Remember this sort of pattern!
            - Storing minimum and maximum values over time in an iteration

       Related problems:
        - Maximum subarray
 */
public class BestTimeStock {

    public static int maxProfit(int[] prices) {
        int minVal = prices[0];
        int profit = 0;
        int maxProfit = 0;

        for (int price : prices) {
            minVal = Math.min(minVal, price);
            profit = price - minVal;
            maxProfit = Math.max(profit, maxProfit);
        }
        if (maxProfit > 0) {
            return maxProfit;
        }
        return 0;
    }

    public static int naiveMaxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int g = i+1; g < prices.length; g++) {
               maxProfit = Math.max(prices[g]-prices[i], maxProfit);
            }
        }
        if (maxProfit <= 0) {
            return 0;
        }
        return maxProfit;
    }

    @Test
   public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int expected1 = 5;
        assertEquals(expected1, naiveMaxProfit(prices1));
        assertEquals(expected1, maxProfit(prices1));

        int[] prices2 = {7,6,4,3,1};
        int expected2 = 0;
        assertEquals(expected2, naiveMaxProfit(prices2));
        assertEquals(expected2, maxProfit(prices2));

        System.out.println("Passed all tests!");
   }
}
