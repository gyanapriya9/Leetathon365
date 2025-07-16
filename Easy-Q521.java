// 521. Longest Uncommon Subsequence I

// Flashcard Explanation:
// - An uncommon subsequence is a string that is a subsequence of exactly one of the two input strings.
// - If the two strings `a` and `b` are equal, there is no such uncommon subsequence → return -1.
// - Otherwise, the longer of the two strings itself is the longest uncommon subsequence, 
//   because it can't be a subsequence of the shorter or different string if the strings are not equal.

// Approach:
// - If `a.equals(b)`, return -1.
// - Else, return the max length of `a` and `b`.

class Solution {
  public int findLUSlength(String a, String b) {
    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
  }
}

// Time Complexity: O(n) — for string comparison where n is the length of the longer string.
// Space Complexity: O(1) — no extra space used.
