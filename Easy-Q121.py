# LeetCode 121 - Best Time to Buy and Sell Stock

"""
Problem Summary:
You're given an array `prices` where `prices[i]` is the stock price on day `i`.
Pick **one** day to buy and **one** future day to sell to maximize your profit.

Goal: Maximize profit = sell price - buy price
Return 0 if no profitable transaction exists.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy at 1 (day 2), sell at 6 (day 5) → profit = 6 - 1 = 5

 Example 2:
Input: prices = [7,6,4,3,1]
Output: 0 (No profit possible)

Constraints:
- 1 <= prices.length <= 100000
- 0 <= prices[i] <= 10000
"""

class Solution:
    def maxProfit(self, prices):
        sellOne = 0  # Max profit after selling (initially 0)
        holdOne = float('-inf')  # Max value after buying (negative because we spent money)

        for price in prices:
            # Update holdOne to be max of current or buying at this price
            holdOne = max(holdOne, -price)
            # Update sellOne to be max of current or selling now (buying at holdOne)
            sellOne = max(sellOne, holdOne + price)

        return sellOne

"""
Approach Breakdown (Greedy):
- Traverse once while tracking:
  1. `holdOne` = best (least) price to buy so far (as -price for ease of math).
  2. `sellOne` = best profit by selling at current price.

 Time: O(n)
 Space: O(1)

 Flashcard Summary:
- Track the minimum price as you go.
- For each day, calculate possible profit.
- Return the max profit seen.
"""
