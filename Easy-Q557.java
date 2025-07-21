// 557. Reverse Words in a String III
// Question: Reverse each word in a string while preserving the word order and spaces.

// 🔹 Flashcard Explanation:
// What is required? → Reverse characters of each word in the string.
// Constraints: Words are separated by single space, no extra leading/trailing spaces.
// Approach: Use a StringBuilder to reverse each word in-place using two pointers.

// Code starts here:
class Solution {
  public String reverseWords(String s) {
    // Convert input string to StringBuilder for in-place modification
    StringBuilder sb = new StringBuilder(s);
    
    int i = 0; // Pointer to start of a word
    int j = 0; // Pointer to end of a word

    // Loop through the StringBuilder to find and reverse each word
    while (i < sb.length()) {
      // Skip spaces to move i to the start of the next word
      while (i < j || (i < sb.length() && sb.charAt(i) == ' '))
        ++i;

      // Move j to the end of the word
      while (j < i || (j < sb.length() && sb.charAt(j) != ' '))
        ++j;

      // Reverse the characters from index i to j - 1
      reverse(sb, i, j - 1);
    }

    // Return the modified string
    return sb.toString();
  }

  // Helper method to reverse characters in StringBuilder from l to r
  private void reverse(StringBuilder sb, int l, int r) {
    while (l < r) {
      final char temp = sb.charAt(l);
      sb.setCharAt(l++, sb.charAt(r));
      sb.setCharAt(r--, temp);
    }
  }
}

// 🔹 Time Complexity: O(n), where n is the length of the string.
// 🔹 Space Complexity: O(n), due to usage of StringBuilder for in-place operations.
