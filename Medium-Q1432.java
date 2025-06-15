// LeetCode 1432. Max Difference You Can Get From Changing an Integer — Medium

class Solution {
  public int maxDiff(int num) {
    // Convert the number to string for easy digit manipulation
    String s = String.valueOf(num);

    // Step 1: Find first digit not '9' to maximize the number (change it to '9')
    int firstNot9 = findFirstNot(s, '9', '9');
    // Step 2: Find first digit not '0' or '1' to minimize the number
    int firstNot01 = findFirstNot(s, '0', '1');

    // Maximize: replace that digit with '9'
    String maxStr = s.replace(s.charAt(firstNot9), '9');
    // Minimize: replace that digit with '1' if it's the first digit, else '0'
    String minStr = s.replace(s.charAt(firstNot01), firstNot01 == 0 ? '1' : '0');

    return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
  }

  // Helper: Find index of first digit that’s not 'a' or 'b'
  private int findFirstNot(String s, char a, char b) {
    for (int i = 0; i < s.length(); ++i)
      if (s.charAt(i) != a && s.charAt(i) != b)
        return i;
    return 0;
  }

  /*
   🧠 Flashcard-Style Summary:
   ----------------------------
   ✅ Goal: Get the maximum difference between two numbers made by changing one digit in `num`.
   ✅ Rules:
     - You can replace *all* instances of one digit `x` with digit `y`.
     - Do this twice: once to get `a` (max) and once to get `b` (min)
     - No leading zeros allowed in result.

   ✅ Strategy:
     - For maximum (`a`): Replace first digit that's not '9' with '9'
     - For minimum (`b`): Replace first digit that's not '0' or '1' with '1' (if it's the first digit) or '0'
     - Return: a - b

   📌 Example:
     num = 555
     a = 999 (replace 5 → 9), b = 111 (replace 5 → 1)
     Difference = 888 ✅

   ⏱ Time: O(n) | 📦 Space: O(n), where n is length of number string
  */
}
