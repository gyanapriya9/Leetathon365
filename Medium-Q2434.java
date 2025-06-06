// LeetCode 2434: Using a Robot to Print the Lexicographically Smallest String

/*
🧠 Problem:
Given a string `s` and an initially empty robot-held string `t`, perform:
1. Move the first character of `s` to the end of `t`.
2. Remove the **last character** of `t` and **append it to the paper string `p`**.
Repeat these operations until both `s` and `t` are empty.
Return the **lexicographically smallest** string that can be written on paper.

🧪 Example:
Input:  s = "zza" → Output: "azz"
Input:  s = "bac" → Output: "abc"
Input:  s = "bdda" → Output: "addb"

💡 Approach:
- Count frequency of characters in `s`.
- Use a stack to simulate `t`.
- Iterate over `s`, pushing each character into `t`.
- After each push, check the stack top:
  - If it's smaller or equal to the **smallest character left in `s`**, pop from `t` and append to output (`p`).
- Repeat until all characters are processed.

🔧 Helper:
- `getMinChar(count)`: returns the lexicographically smallest character remaining in `s`.

✅ Java Code:
*/

class Solution {
  public String robotWithString(String s) {
    StringBuilder result = new StringBuilder();         // Final written string p
    int[] count = new int[26];                          // Count of each character left in s
    Deque<Character> stack = new ArrayDeque<>();        // Stack to simulate robot's t string

    // Count frequencies of characters in s
    for (char c : s.toCharArray())
      count[c - 'a']++;

    for (char c : s.toCharArray()) {
      stack.push(c);               // First operation: move char from s to t
      count[c - 'a']--;            // Decrease frequency of the moved character

      // Determine current smallest character still in s
      char minChar = getMinChar(count);

      // Second operation: pop from t to paper if it's ≤ minChar
      while (!stack.isEmpty() && stack.peek() <= minChar)
        result.append(stack.pop());
    }

    // Add remaining characters in stack to result
    while (!stack.isEmpty())
      result.append(stack.pop());

    return result.toString();
  }

  // Helper: Find the smallest character remaining in s
  private char getMinChar(int[] count) {
    for (int i = 0; i < 26; i++)
      if (count[i] > 0)
        return (char) ('a' + i);
    return 'a';  // default, although unused once s is exhausted
  }
}

/*
⏱ Time Complexity: O(n * 26) ≈ O(n)
- We iterate over `s`, and for each character, do a fixed 26 checks max in getMinChar.
- Stack and StringBuilder operations are O(1) amortized.

🧠 Space Complexity: O(n)
- Stack and output result can hold up to n characters.
- Count array is fixed size (26).
*/
