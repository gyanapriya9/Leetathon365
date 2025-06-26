class Solution {
  public int longestSubsequence(String s, int k) {
    int oneCount = 0; // Count of '1's that can be included without exceeding k
    int num = 0;      // Current binary number value
    int pow = 1;      // Power of 2 to calculate value from right to left

    // Traverse from the right (least significant bit) to left
    for (int i = s.length() - 1; i >= 0 && num + pow <= k; --i) {
      if (s.charAt(i) == '1') {
        ++oneCount;         // Include this '1'
        num += pow;         // Update the number value
      }
      pow *= 2;             // Move to higher binary digit (left side)
    }

    // Total length = all '0's (they don't increase value) + included '1's
    return (int) s.chars().filter(c -> c == '0').count() + oneCount;
  }
}
