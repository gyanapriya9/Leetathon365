// LeetCode 58: Length of Last Word

// 🧠 Problem:
/*
Given a string `s` consisting of words and spaces,
return the length of the **last word** in the string.

A word is defined as a maximal substring of non-space characters.
*/


// 🧪 Examples:
/*
Input:  s = "Hello World"              → Output: 5     ("World")
Input:  s = "   fly me   to   the moon  " → Output: 4 ("moon")
Input:  s = "luffy is still joyboy"    → Output: 6     ("joyboy")
*/


// 💡 Approach:
/*
1. Start from the end of the string.
2. Skip trailing spaces.
3. Then count the characters until the next space or beginning of string.
*/


// ✅ Java Code:
class Solution {
  public int lengthOfLastWord(String s) {
    int i = s.length() - 1;

    // Skip trailing spaces
    while (i >= 0 && s.charAt(i) == ' ')
      --i;

    // Start of the last word
    int lastIndex = i;

    // Move to the beginning of the last word
    while (i >= 0 && s.charAt(i) != ' ')
      --i;

    return lastIndex - i;
  }
}


// ⏱ Time Complexity: O(n)
// - In the worst case, we might go through all characters (from end).

// 🧠 Space Complexity: O(1)
// - No extra space used.
