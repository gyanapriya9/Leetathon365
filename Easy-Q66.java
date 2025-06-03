// LeetCode 66: Plus One

// 🧠 Problem:
/*
You are given a large integer in the form of an integer array `digits`.
Each element represents a digit of the number from most to least significant.

Increment the integer by one and return the new array.
*/


// 🧪 Examples:
/*
Input:  digits = [1,2,3]      → Output: [1,2,4]
Input:  digits = [4,3,2,1]    → Output: [4,3,2,2]
Input:  digits = [9]          → Output: [1,0]
*/


// 💡 Approach:
/*
Start from the end:
1. If digit < 9: simply increment and return.
2. If digit == 9: set it to 0 and move left.
3. If all were 9s, we need a new array with an extra leading 1.
*/


// ✅ Java Code:
class Solution {
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }

    // All digits were 9
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
  }
}


// ⏱ Time Complexity: O(n)
// - We may traverse the entire array in the worst case (all 9s).

// 🧠 Space Complexity: O(n)
// - If a new array is needed (like [9,9,9] → [1,0,0,0]), size increases by 1.
