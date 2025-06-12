// 190. Reverse Bits
// Easy

// ✅ Problem Statement:
// Given a 32-bit unsigned integer `n`, reverse its binary bits and return the resulting integer.

// ⚠️ Note:
// - Java doesn't have unsigned types, but internally it uses 2's complement. So bit manipulation works as expected.

// ✅ Example 1:
// Input:  00000010100101000001111010011100 (43261596)
// Output: 00111001011110000010100101000000 (964176192)

// ✅ Example 2:
// Input:  11111111111111111111111111111101 (4294967293)
// Output: 10111111111111111111111111111111 (3221225471)

// ✅ Approach:
// - Loop 32 times (for each bit).
// - In each iteration:
//   1. Shift the result left by 1 to make space.
//   2. Add the least significant bit of `n` (n & 1).
//   3. Unsigned right shift `n` by 1 (`n >>> 1`).
// - Return the final reversed result.

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;            // Shift result left to make space
            result |= (n & 1);       // Add the rightmost bit of n
            n >>>= 1;                // Unsigned right shift n
        }
        return result;
    }
}

// ✅ Example Walkthrough:
// Input: n = 000...0101 (just an example)
// Iteration 1: result = 0, n = ...101
//  -> result <<= 1 = 0
//  -> result |= 1 = 1
//  -> n >>>= 1 => new n

// ✅ Time Complexity: O(1) — always runs 32 iterations
// ✅ Space Complexity: O(1)

// 💡 Optimization (Follow-up):
// - If the function is called many times, cache results of reversed 8-bit chunks
//   → Reverse each byte using a lookup table of size 256
//   → Assemble the final reversed number using 4 reverse lookups
