/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
Find and return the maximum profit you can achieve.


Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
*/


class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // If the current price is higher than the previous day's price, we have a profit opportunity:
            if (prices[i] > prices[i - 1]) {
                // Accumulate the profit by subtracting yesterday's price from today's price.
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        // At the end, maxProfit holds the total profit accrued through all transactions.
        return maxProfit;
    }
}

/*
The problem is essentially about finding opportunities to make as much profit as possible by buying stocks on one day and selling them on another. This can be achieved by making transactions whenever there's a profit to be made, without concern for a future decrement in prices.
In a simplified manner, the problem reduces to accumulating all positive differences between consecutive days. By always projecting into the future and accumulating possible gains daily, we capitalize on every rising curve of the stock price graph.
*/

/*
Time Complexity: O(n) since iterating through the prices array once.
Space Complexity: O(1) since uses constant space.
*/
