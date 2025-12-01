/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Update the minimum price so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate the potential profit
            int profit = price - minPrice;
            // Update the maximum profit found so far
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}

/*
Approach:
Scan prices left to right while maintaining:

minPrice: the lowest price seen so far (best day to have bought before or on today).
maxProfit: the best profit achievable if we must sell on or after that minPrice day and on or before today.
At each day’s price p:

Update minPrice = min(minPrice, p). This locks in the cheapest buy seen so far.
Compute potential profit if we sell today: p - minPrice.
Update maxProfit = max(maxProfit, p - minPrice).
Return maxProfit after the scan.
*/

/*
Time Complexity: O(n) due to single loop.
Space Complexity: O(1) as no extra space is used.
*/
