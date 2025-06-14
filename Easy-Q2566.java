// 2566. Maximum Difference by Remapping a Digit
// Easy

// ✅ Problem Statement:
// You're given an integer `num`. Bob remaps **exactly one digit** (0–9) to another digit (0–9).
// The remapping replaces **all** instances of that digit in the number.
// Return the **maximum difference** between the highest and lowest number Bob can make by remapping a digit.

// ✅ Example:
// Input: num = 11891
// Output: 99009
// Explanation:
// - For max: Replace '1' with '9' → "99899"
// - For min: Replace '1' with '0' → "00890" → interpreted as 890
// - Difference = 99899 - 890 = 99009

// ✅ Approach:
// 1. Convert number to string for easy digit access and manipulation.
// 2. To maximize the number:
//    - Find the **first digit ≠ 9**, replace all its occurrences with '9'.
// 3. To minimize the number:
//    - Replace all occurrences of the **first digit** with '0'.
// 4. Return the difference of these two remapped values.

class Solution {
  public int minMaxDifference(int num) {
    String s = String.valueOf(num);
    
    // Step 1: For max, pick first digit that's not 9 and replace all with 9
    char to9 = s.charAt(firstNotNineIndex(s)); 
    
    // Step 2: For min, replace all occurrences of first digit with 0
    char to0 = s.charAt(0);                    

    // Step 3: Return the difference
    return getMax(new StringBuilder(s), to9) - getMin(new StringBuilder(s), to0);
  }

  // ✅ Helper: Finds first digit from left that's not '9'
  private int firstNotNineIndex(String s) {
    for (int i = 0; i < s.length(); ++i)
      if (s.charAt(i) != '9')
        return i;
    return 0; // All digits are 9 — any digit replacement will do
  }

  // ✅ Helper: Replace all instances of `to9` with '9'
  private int getMax(StringBuilder sb, char to9) {
    for (int i = 0; i < sb.length(); ++i)
      if (sb.charAt(i) == to9)
        sb.setCharAt(i, '9');
    return Integer.parseInt(sb.toString());
  }

  // ✅ Helper: Replace all instances of `to0` with '0'
  private int getMin(StringBuilder sb, char to0) {
    for (int i = 0; i < sb.length(); ++i)
      if (sb.charAt(i) == to0)
        sb.setCharAt(i, '0');
    return Integer.parseInt(sb.toString());
  }
}
