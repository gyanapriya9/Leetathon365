// 3201. Find the Maximum Length of Valid Subsequence I

// Problem Flashcard:
// - We are given an array `nums`.
// - A subsequence is valid if for all adjacent pairs `(a, b)` in the subsequence:
//   (a + b) % 2 is equal across the entire subsequence.
// - Return the length of the longest such valid subsequence.

// Approach:
// - Since (a + b) % 2 depends only on the parity (odd/even) of a and b:
//     - Even + Even = Even => (0 + 0) % 2 = 0
//     - Odd + Odd   = Even => (1 + 1) % 2 = 0
//     - Even + Odd  = Odd  => (0 + 1) % 2 = 1
//     - Odd + Even  = Odd  => (1 + 0) % 2 = 1
// - Therefore, valid subsequence must follow a parity pattern like: 0,1,0,1... or 1,0,1,0...
// - We use `dp[a][b]` where:
//   - `a` is the current parity (0 for even, 1 for odd) of the current number,
//   - `b` is the parity of the previous number in the subsequence.
// - The recurrence builds longest alternating subsequences by extending based on previous parity.

import java.util.Arrays;

class Solution {
  public int maximumLength(int[] nums) {
    int[][] dp = new int[2][2];  // dp[current_parity][previous_parity]

    // Iterate over each number in the input
    for (final int x : nums)
      for (int y = 0; y < 2; ++y)
        // Try to extend the subsequence by using the previous parity 'y'
        dp[x % 2][y] = dp[y][x % 2] + 1;

    // Get the maximum length found in all dp states
    return Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt();
  }
}

// Time Complexity: O(n), where n is the number of elements in nums
// Space Complexity: O(1), constant space used for 2x2 dp table
