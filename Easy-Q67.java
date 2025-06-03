// LeetCode 67: Add Binary

// 🧠 Problem:
/*
Given two binary strings `a` and `b`, return their **sum** as a binary string.
*/


// 🧪 Examples:
/*
Input:  a = "11", b = "1"         → Output: "100"
Input:  a = "1010", b = "1011"    → Output: "10101"
*/


// 💡 Approach:
/*
- Start from the end of both strings.
- Add digits one by one like elementary addition.
- Keep track of the carry.
- Use StringBuilder to build the result from the back and then reverse it.
*/


// ✅ Java Code:
class Solution {
  public String addBinary(String a, String b) {
    int i = a.length() - 1, j = b.length() - 1, carry = 0;
    StringBuilder result = new StringBuilder();

    while (i >= 0 || j >= 0 || carry > 0) {
      if (i >= 0) carry += a.charAt(i--) - '0'; // convert char to int
      if (j >= 0) carry += b.charAt(j--) - '0';

      result.append((carry % 2)); // add current digit
      carry /= 2; // update carry (0 or 1)
    }

    return result.reverse().toString(); // reverse to get the correct order
  }
}


// ⏱ Time Complexity: O(max(n, m))
// - n and m are the lengths of a and b

// 🧠 Space Complexity: O(max(n, m))
// - For the result string
