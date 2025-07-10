class Solution {
  public boolean repeatedSubstringPattern(String s) {
    // Step 1: Concatenate the string with itself
    final String ss = s + s;

    // Step 2: Remove the first and last character from the doubled string
    // This avoids matching the original string at its start or end
    String trimmed = ss.substring(1, ss.length() - 1);

    // Step 3: Check if the original string appears inside the trimmed version
    // If yes, it means s can be formed by repeating a substring
    return trimmed.contains(s);
  }
}
