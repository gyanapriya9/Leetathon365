// 2438. Range Product Queries of Powers
// ------------------------------------------------------------
// Flashcard Explanation:
// Problem: Given n, represent it as the sum of the smallest number of powers of 2 (sorted ascending).
// Then, for each query [l, r], return the product of powers[l] through powers[r], modulo 10^9 + 7.
// Approach:
// 1. Extract powers of 2 from n using bitwise checks and store them in a list (ascending order).
// 2. For each query, iterate through the specified range in the list and compute the product mod 10^9+7.
// Reasoning: The powers list is unique due to binary representation of n. Direct multiplication for each query is simple to implement.
// ------------------------------------------------------------
// Time Complexity: O(k + q * m) — k = number of bits in n (<= 30), q = number of queries, m = average query range length.
// Space Complexity: O(k) — storing extracted powers from n.

class Solution {
  public int[] productQueries(int n, int[][] queries) {
    final int MOD = 1_000_000_007;
    final int MAX_BIT = 30;
    int[] ans = new int[queries.length];
    List<Integer> pows = new ArrayList<>();

    // Extract powers of 2 from binary representation of n
    for (int i = 0; i < MAX_BIT; ++i)
      if ((n >> i & 1) == 1) // If i-th bit is set, add corresponding power of 2
        pows.add(1 << i);

    // Process each query
    for (int i = 0; i < queries.length; ++i) {
      final int left = queries[i][0];
      final int right = queries[i][1];
      long prod = 1;

      // Multiply values in range [left, right]
      for (int j = left; j <= right; ++j) {
        prod *= pows.get(j);
        prod %= MOD; // Keep result within modulo
      }

      ans[i] = (int) prod;
    }

    return ans;
  }
}
