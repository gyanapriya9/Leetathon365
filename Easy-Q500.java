// 500. Keyboard Row
// Question:
// Given a list of words, return the words that can be typed using letters of the alphabet 
// on only one row of the American keyboard. 
// The three keyboard rows are:
// Row 1: "qwertyuiop"
// Row 2: "asdfghjkl"
// Row 3: "zxcvbnm"
// Words are case-insensitive. Both lowercase and uppercase letters are treated the same.

// Approach:
// - Create a mapping of each character to its keyboard row number.
// - For each word, convert to lowercase and determine the row of its first character.
// - Check whether all characters in the word belong to the same row using the mapping.
// - If valid, add the original word (case preserved) to the result list.

class Solution {
  public String[] findWords(String[] words) {
    List<String> ans = new ArrayList<>();
    
    // Mapping for characters: index represents 'a' to 'z', value is the row number
    final int[] rows = {
      2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3,
      3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3
    };

    for (final String word : words) {
      final String lowerWord = word.toLowerCase(); // convert to lowercase for uniformity
      final int row = rows[lowerWord.charAt(0) - 'a']; // get row number of first character

      // Check if all characters belong to the same row
      final boolean isValid = lowerWord.chars().allMatch(c -> rows[c - 'a'] == row);

      if (isValid)
        ans.add(word); // Add the original word with its case preserved
    }

    return ans.toArray(new String[0]);
  }
}

// Time Complexity: O(n * k), where n = number of words and k = average length of each word
// Space Complexity: O(n * k) for storing the output list
