class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] count = new int[26];  // Array to count characters in magazine

    // Count each character in magazine
    for (final char c : magazine.toCharArray())
      ++count[c - 'a'];

    // For each character in ransomNote, check if it's available in magazine
    for (final char c : ransomNote.toCharArray()) {
      if (count[c - 'a'] == 0)  // If char not available, return false
        return false;
      --count[c - 'a'];         // Use the character once
    }

    return true; // All characters matched successfully
  }
}
