class Solution {
  public int arrangeCoins(long n) {
    // Mathematical formula:
    // The total coins needed to form k full rows is: k*(k + 1)/2
    // We solve: k*(k + 1)/2 ≤ n → quadratic equation: k^2 + k - 2n ≤ 0
    // Using quadratic formula: k = (−1 + √(1 + 8n)) / 2

    return (int) (-1 + Math.sqrt(8 * n + 1)) / 2;
  }
}
