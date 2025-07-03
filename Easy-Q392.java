class Solution {
  public boolean isSubsequence(String s, String t) {
    // Edge case: empty string is always a subsequence
    if (s.isEmpty())
      return true;

    int i = 0; // Pointer to track position in 's'

    for (final char c : t.toCharArray()) {
      // If characters match, move the pointer forward in 's'
      if (s.charAt(i) == c && ++i == s.length())
        return true; // All characters in 's' found in order in 't'
    }

    // If loop ends without returning, not all of 's' was matched
    return false;
  }
}
