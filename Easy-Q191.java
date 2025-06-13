// 191. Number of 1 Bits
// Easy

// ✅ Problem Statement:
// Given an integer `n`, return the number of 1's (set bits) in its binary representation.
// This is also known as the **Hamming weight**.

// ✅ Examples:
// Input:  11        → Binary: 00000000000000000000000000001011 → Output: 3
// Input: 128        → Binary: 00000000000000000000000010000000 → Output: 1
// Input: 2147483645 → Binary: 1111111111111111111111111111101  → Output: 30

// ✅ Approach:
// - Loop through each of the 32 bits of the integer.
// - Right shift the number by `i` bits, and check the least significant bit.
// - If that bit is 1, increment the counter.
// - Return the total count of set bits.

class Solution {
  // You need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int ans = 0;

    for (int i = 0; i < 32; ++i)
      if (((n >> i) & 1) == 1)
        ++ans;

    return ans;
  }
}

// ✅ Example Walkthrough (n = 11):
// Binary: 00000000000000000000000000001011
// Positions with 1's: bit 0, bit 1, bit 3 → count = 3

// ✅ Time Complexity: O(32) → O(1) constant time for 32-bit integer
// ✅ Space Complexity: O(1)

// 💡 Tip:
// You can also use `n &= (n - 1)` trick to turn off the lowest set bit
// and count faster if set bits are fewer (Brian Kernighan’s Algorithm).
