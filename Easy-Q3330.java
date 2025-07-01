class Solution {
  public int possibleStringCount(String word) {
    int ans = 1; // At minimum, the original string could be same as word

    // Loop through the string to find repeated characters
    for (int i = 1; i < word.length(); ++i)
      // If current character is same as previous, it's a result of long press
      // We can remove one of these repeated characters to form another valid original string
      if (word.charAt(i) == word.charAt(i - 1))
        ++ans; // Each repeat gives one new possibility by removing one of the repeated characters

    return ans; // Return the total number of possible original strings
  }
}
