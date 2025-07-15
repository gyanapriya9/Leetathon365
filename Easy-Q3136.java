// 3136. Valid Word
// Question:
// A word is valid if:
// - It has at least 3 characters.
// - It contains only digits and English letters (both cases).
// - It has at least one vowel (a, e, i, o, u in either case).
// - It has at least one consonant (a letter that's not a vowel).
// Return true if the given word meets all these conditions.

// Approach:
// - Check if the length is at least 3.
// - Ensure all characters are alphanumeric (no special characters).
// - Ensure the word has at least one vowel.
// - Ensure the word has at least one consonant.
// - Use helper functions `isVowel()` and `isConsonant()` to simplify logic.

class Solution {
  public boolean isValid(String word) {
    // Check for all 4 conditions using logical AND
    return word.length() >= 3 &&
           word.chars().allMatch(Character::isLetterOrDigit) && // Only letters and digits
           word.chars().anyMatch(c -> isVowel((char) c)) &&     // At least one vowel
           word.chars().anyMatch(c -> isConsonant((char) c));   // At least one consonant
  }

  // Helper method to check if a character is a vowel
  private boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
  }

  // Helper method to check if a character is a consonant
  private boolean isConsonant(char c) {
    return Character.isLetter(c) && !isVowel(c);
  }
}

// Time Complexity: O(n), where n = word.length()
// Space Complexity: O(1), since we use constant space for logic checks
