// 3202. Find the Maximum Length of Valid Subsequence II

// 🔹 Flashcard Explanation:
// Question:
//   - Given an array `nums` and an integer `k`, find the longest valid subsequence such that:
//     (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... for all adjacent pairs in the subsequence.
// Approach:
//   - Dynamic Programming
//   - Define dp[i][j] as the maximum length of a valid subsequence ending with a number where:
//     - The previous number's value % k == i
//     - The current number's value % k == j
//   - For each number `x` in nums, and for each possible `y` in range 0 to k-1:
//     - Try to extend a sequence from dp[y][x % k] to dp[x % k][y]

import java.util.Arrays;

class Solution {
  public int maximumLength(int[] nums, int k) {
    // Initialize a 2D array dp where dp[i][j] holds the maximum valid subsequence length
    // for a pair (i, j) representing previous % k and current % k values
    int[][] dp = new int[k][k];

    // Traverse through each number in nums
    for (final int x : nums)
      for (int y = 0; y < k; ++y)
        // Try extending the subsequence from (y, x%k) to (x%k, y)
        dp[x % k][y] = dp[y][x % k] + 1;

    // Flatten dp and return the maximum value found
    return Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt();
  }
}

// Time Complexity: O(n * k) — where n is nums.length and k is the given integer
// Space Complexity: O(k^2) — for the dp table of size k x k
