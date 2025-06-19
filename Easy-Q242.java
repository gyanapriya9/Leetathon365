// LeetCode 242: Valid Anagram — Easy

class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    // Step 1: Frequency count array for 26 lowercase English letters
    int[] count = new int[26];

    // Count characters in string s
    for (char c : s.toCharArray())
      count[c - 'a']++;

    // Subtract characters using string t
    for (char c : t.toCharArray()) {
      if (count[c - 'a'] == 0)
        return false;
      count[c - 'a']--;
    }

    return true; // All characters matched in count
  }

  /*
   Flashcard Summary:
   -----------------------
   Problem: Check if two strings are anagrams (same characters, same frequency).
   Example:
       - s = "anagram", t = "nagaram" → true
       - s = "rat", t = "car" → false

   Approach:
     1. Use a fixed-size array of 26 to count character frequencies.
     2. Increment for string `s`, decrement for string `t`.
     3. If any count goes negative, return false.

   Time Complexity: O(n)
   Space Complexity: O(1) → fixed 26-sized array
   .
  */
}
