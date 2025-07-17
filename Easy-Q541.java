// 541. Reverse String II
// Flashcard:
// Given a string `s` and an integer `k`, reverse the first `k` characters for every 2k characters starting from the beginning.
// - If less than `k` characters are left, reverse all of them.
// - If between `k` and `2k`, reverse first `k` characters and leave the rest unchanged.
// Approach: Use StringBuilder to mutate the string, loop through every 2k block, reverse the first k characters using two-pointer method.

class Solution {
  public String reverseStr(String s, int k) {
    StringBuilder sb = new StringBuilder(s);  // Used to modify the string efficiently

    for (int i = 0; i < sb.length(); i += 2 * k) {  // Move in steps of 2k characters
      int l = i;  // Start index of the block to reverse
      int r = Math.min(i + k - 1, sb.length() - 1);  // End index (at most k characters or end of string)

      // Reverse characters from l to r
      while (l < r) {
        char temp = sb.charAt(l);  // Store left character
        sb.setCharAt(l, sb.charAt(r));  // Set left to right
        sb.setCharAt(r, temp);  // Set right to left
        ++l;
        --r;
      }
    }

    return sb.toString();  // Return the modified string
  }
}

// Time Complexity: O(n), where n is the length of the string
// Space Complexity: O(n), due to the use of StringBuilder
