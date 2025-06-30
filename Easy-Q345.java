class Solution {
  public String reverseVowels(String s) {
    StringBuilder sb = new StringBuilder(s);  // Mutable string for in-place changes
    int l = 0;                  // Left pointer
    int r = s.length() - 1;     // Right pointer

    // Keep going until both pointers meet
    while (l < r) {
      // Skip non-vowel characters from the left
      while (l < r && !isVowel(sb.charAt(l)))
        ++l;

      // Skip non-vowel characters from the right
      while (l < r && !isVowel(sb.charAt(r)))
        --r;

      // Swap vowels at left and right
      sb.setCharAt(l, s.charAt(r));
      sb.setCharAt(r, s.charAt(l));
      ++l;
      --r;
    }

    return sb.toString();  // Final string with vowels reversed
  }

  // Helper function to check if a character is a vowel (case-insensitive)
  private boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
  }
}
