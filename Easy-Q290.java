// LeetCode 290: Word Pattern — Easy

class Solution {
  public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" "); // Split input string by space
    if (words.length != pattern.length()) // Pattern length must match word count
      return false;

    // Maps to store index of first occurrence for characters and words
    Map<Character, Integer> charToIndex = new HashMap<>();
    Map<String, Integer> wordToIndex = new HashMap<>();

    for (int i = 0; i < pattern.length(); ++i) {
      // If mapping is inconsistent, return false
      if (charToIndex.put(pattern.charAt(i), i) != wordToIndex.put(words[i], i))
        return false;
    }

    return true;
  }
}


/*
Example 1:
-----------
Input: pattern = "abba", s = "dog cat cat dog"
Mapping:
  'a' -> "dog"
  'b' -> "cat"
Pattern is followed. Output: true

Example 2:
-----------
Input: pattern = "abba", s = "dog cat cat fish"
Mapping:
  'a' -> "dog"
  'b' -> "cat"
But 'a' later maps to "fish" — contradiction. Output: false

Example 3:
-----------
Input: pattern = "aaaa", s = "dog cat cat dog"
Different words for same pattern letter. Output: false

Approach:
---------
- Use two hash maps to track first-seen indices of both pattern characters and words.
- If a character and corresponding word are always seen at the same index, pattern holds.
- If mappings differ at any position, return false.

Flashcard Summary:
------------------
Problem:
  Does a string `s` follow a character `pattern` with 1-1 mapping?

Key Concepts:
  - HashMap for bijection validation
  - Index-based comparison to avoid false positives

Time Complexity: O(n) — n = length of pattern or number of words
Space Complexity: O(n) — for storing character and word maps

Constraints:
  - 1 <= pattern.length <= 300
  - 1 <= s.length <= 3000
  - s contains lowercase words and single spaces (no extra whitespace)
*/
