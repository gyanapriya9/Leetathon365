class Solution {
  public int firstUniqChar(String s) {
    int[] count = new int[26];  // To store frequency of each character (a-z)

    // Count frequency of each character in the string
    for (final char c : s.toCharArray())
      ++count[c - 'a'];  // Increment count for character 'c'

    // Find the first character with frequency 1 (unique)
    for (int i = 0; i < s.length(); ++i)
      if (count[s.charAt(i) - 'a'] == 1)
        return i;  // Return the index of first unique character

    return -1;  // If no unique character found
  }
}
