// 504. Base 7
// Convert a given integer to its base 7 representation (as a string).
// Requirements:
// - Convert both positive and negative integers.
// - Use recursive or iterative approach.
// - Base 7 uses digits from 0 to 6.

// Approach:
// - If the number is negative, recursively call the function on its absolute value and prepend '-'.
// - If the number is less than 7, return the digit itself as a string.
// - Recursively divide the number by 7 and append the remainder to build the result.

class Solution {
  public String convertToBase7(int num) {
    // Base case for negative numbers: handle sign and recurse with positive equivalent
    if (num < 0)
      return "-" + convertToBase7(-num);

    // Base case for numbers less than base (7): just return as string
    if (num < 7)
      return String.valueOf(num);

    // Recursive call: build result string by dividing and finding remainder
    return convertToBase7(num / 7) + String.valueOf(num % 7);
  }
}

// Time Complexity: O(log₇n) — We reduce the number by a factor of 7 each step
// Space Complexity: O(log₇n) — Due to recursive call stack and result string building
