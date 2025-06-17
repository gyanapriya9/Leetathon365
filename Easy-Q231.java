// LeetCode 231: Power of Two — Easy

class Solution {
  public boolean isPowerOfTwo(int n) {
    // Base case: must be positive
    if (n <= 0)
      return false;

    // Key logic: only powers of 2 have exactly one bit set in binary
    return (n & (n - 1)) == 0;
  }

  /*
   🧠 Flashcard-Style Summary:
   ----------------------------
   ✅ Problem: Check if a number is a power of 2.

   ✅ Concept:
     - In binary, power of 2 → only one '1' bit (e.g., 1=0001, 2=0010, 4=0100, 8=1000)
     - Trick: (n & (n - 1)) removes the lowest set bit.
       → For powers of 2: result = 0
       → For non-powers: result ≠ 0

   ⏱ Time: O(1)
   📦 Space: O(1)

   🧾 Examples:
     - Input: 1 → Output: true  (2⁰)
     - Input: 16 → Output: true (2⁴)
     - Input: 3 → Output: false
     - Input: -2 → Output: false (negative)
  */
}
