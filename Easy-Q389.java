class Solution {
  public char findTheDifference(String s, String t) {
    int[] count = new int[26];  // To count frequency of letters in s

    // Count frequency of each character in string s
    for (final char c : s.toCharArray())
      ++count[c - 'a'];  // Increase count for the character

    // Check each character in t
    for (final char c : t.toCharArray()) {
      if (count[c - 'a'] == 0)
        return c;  // If character not in s or used up, it's the added one
      --count[c - 'a'];  // Decrease count as it's matched
    }

    // Should never reach here as t has one extra character
    throw new IllegalArgumentException();
  }
}
