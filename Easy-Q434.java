class Solution {
  public int countSegments(String s) {
    int ans = 0;

    // Traverse each character in the string
    for (int i = 0; i < s.length(); ++i)
      // If current char is not space AND (it's the first character OR the previous one is a space),
      // then it's the start of a new segment.
      if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
        ++ans;

    // Return the total segment count
    return ans;
  }
}
