// 509. Fibonacci Number

// Flashcard Explanation:
// - The Fibonacci sequence is defined as:
//   F(0) = 0, F(1) = 1
//   F(n) = F(n - 1) + F(n - 2) for n > 1
// - We are asked to compute F(n) for a given integer n.
// - A naive recursive approach would be inefficient due to overlapping subproblems.
// - Here, we use an iterative bottom-up approach with constant space optimization.

// Approach:
// - We use a rolling array of size 3 (dp[0], dp[1], dp[2]) to store the previous two Fibonacci numbers.
// - At each iteration, we shift the values and compute the next Fibonacci number using dp[0] + dp[1].

class Solution {
  public int fib(int n) {
    if (n < 2)
      return n;  // Base cases: F(0) = 0, F(1) = 1

    int[] dp = {0, 0, 1};  // dp[2] starts as F(1) = 1, dp[0] and dp[1] help rotate previous values

    for (int i = 2; i <= n; ++i) {
      dp[0] = dp[1];          // Move F(n-2)
      dp[1] = dp[2];          // Move F(n-1)
      dp[2] = dp[0] + dp[1];  // Compute F(n) = F(n-1) + F(n-2)
    }

    return dp[2];  // dp[2] now contains F(n)
  }
}

// Time Complexity: O(n) — We iterate once from 2 to n.
// Space Complexity: O(1) — We only use a fixed array of size 3 to track state.
