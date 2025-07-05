class Solution {
  public int longestPalindrome(String s) {
    int ans = 0;
    int[] count = new int[128]; // ASCII range to count frequency of each character

    // Count frequency of each character in the string
    for (final char c : s.toCharArray())
      ++count[c];

    // Add the even part of each character count to the total length
    for (final int freq : count)
      ans += freq % 2 == 0 ? freq : freq - 1; // if odd, leave 1 for possible center

    // If there's at least one odd count, we can put one odd char in the middle
    final boolean hasOddCount = Arrays.stream(count).anyMatch(freq -> freq % 2 == 1);

    return ans + (hasOddCount ? 1 : 0); // add 1 center char if needed
  }
}
