// 520. Detect Capital

// Flashcard Explanation:
// - We need to check if a given word uses capital letters correctly.
// - Valid capital usage means one of the following:
//   1. All letters are uppercase (e.g., "USA")
//   2. All letters are lowercase (e.g., "leetcode")
//   3. Only the first letter is uppercase and the rest are lowercase (e.g., "Google")
// - This can be checked using built-in string functions.

// Approach:
// - Check if the entire word is uppercase: word.equals(word.toUpperCase())
// - OR check if all characters except the first are lowercase: 
//   word.substring(1).equals(word.substring(1).toLowerCase())

class Solution {
  public boolean detectCapitalUse(String word) {
    return word.equals(word.toUpperCase()) || // Case 1: All letters uppercase
           word.equals(word.toLowerCase()) || // Case 2: All letters lowercase
           word.substring(1).equals(word.substring(1).toLowerCase()); // Case 3: First capital only
  }
}

// Time Complexity: O(n) — where n is the length of the word (due to substring and case conversions).
// Space Complexity: O(n) — due to creation of substring and new string objects during case conversions.
