// 231. Power of Two
// ------------------------------------------------------------
// Flashcard Explanation:
// Problem: Given an integer n, determine if it is a power of two (n = 2^x for some integer x).
// Requirement: Return true if n is a power of two, otherwise false.
// Approach: A power of two has exactly one bit set in its binary representation.
// Use Integer.bitCount(n) == 1 to check this property, also ensuring n > 0.

// Time Complexity: O(1) — bit counting on a 32-bit integer is constant time.
// Space Complexity: O(1) — no extra space used.

class Solution {
  public boolean isPowerOfTwo(int n) {
    // Ensure n is positive and has exactly one set bit in its binary form
    return n > 0 && Integer.bitCount(n) == 1;
  }
}
