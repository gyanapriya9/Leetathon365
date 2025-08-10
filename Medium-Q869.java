// 869. Reordered Power of 2
// ------------------------------------------------------------
// Flashcard Explanation:
// Problem: Given an integer n, check if its digits can be rearranged to form a power of two.
// Requirement: Return true if any permutation of digits of n (without leading zero) is a power of two.
// Approach: 
// 1. Count digit frequency of n using a compact hash (digit count stored as powers of 10).
// 2. Compare it with digit frequency of all powers of two from 1 (2^0) to 2^29.
// 3. If any matches, return true.
// Reasoning: Two numbers can be permutations of each other if their digit counts match exactly.
// ------------------------------------------------------------
// Time Complexity: O(1) — only 30 fixed iterations over constant-sized numbers.
// Space Complexity: O(1) — only integer variables used.

class Solution {
  public boolean reorderedPowerOf2(int n) {
    // Get digit frequency hash for n
    int count = counter(n);

    // Check against all powers of two within the range of int
    for (int i = 0; i < 30; ++i) // 2^30 > 10^9
      if (counter(1 << i) == count) // Compare digit hash
        return true;

    return false; // No match found
  }

  // Helper: Encodes digit frequency into a single integer hash
  private int counter(int n) {
    int count = 0;
    // Traverse digits, each digit contributes to hash via powers of 10
    for (; n > 0; n /= 10)
      count += Math.pow(10, n % 10);
    return count;
  }
}
