class Solution {
  public String licenseKeyFormatting(String s, int k) {
    StringBuilder sb = new StringBuilder();
    int length = 0;

    // Traverse from end to start
    for (int i = s.length() - 1; i >= 0; --i) {
      char c = s.charAt(i);
      if (c == '-') continue;

      if (length > 0 && length % k == 0)
        sb.append('-');

      sb.append(Character.toUpperCase(c));
      ++length;
    }

    return sb.reverse().toString();
  }
}
