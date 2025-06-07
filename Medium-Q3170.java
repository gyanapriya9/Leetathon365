// LeetCode 3170: Lexicographically Minimum String After Removing Stars

/*
🧠 Problem Summary:
You're given a string `s` which may contain any number of `*` characters. For every `*`:
- Remove the *leftmost* `*`.
- Also remove the *smallest* (lexicographically) character to its left (non-star).

Your goal is to perform these operations until no `*` remains, and return the **lexicographically smallest** final string.

🧪 Examples:
Input:  s = "aaba*"  → Output: "aab" 
// Remove 'a' (smallest to left) + '*' at index 4.

Input:  s = "abc"    → Output: "abc" 
// No '*' → no removal.

💡 Key Idea:
- Track each character's index in a **bucketed list** for each letter 'a' to 'z'.
- When encountering '*':
  1. Mark '*' as removed.
  2. Remove the last inserted index of the **lex smallest** char (left to it) using the buckets.

✅ Java Code (Efficient and Lexicographically Aware):
*/

class Solution {
  public String clearStars(String s) {
    StringBuilder sb = new StringBuilder(s);  // Mutable string for edits
    List<Integer>[] buckets = new List[26];   // Buckets to track positions of a-z

    // Initialize buckets
    for (int i = 0; i < 26; ++i)
      buckets[i] = new ArrayList<>();

    for (int i = 0; i < s.length(); ++i) {
      char ch = s.charAt(i);

      if (ch == '*') {
        sb.setCharAt(i, ' '); // mark '*' as removed

        // Find the smallest char bucket with an index
        int j = 0;
        while (buckets[j].isEmpty())
          j++;

        // Remove the rightmost index of the smallest char
        int idxToRemove = buckets[j].remove(buckets[j].size() - 1);
        sb.setCharAt(idxToRemove, ' ');
      } else {
        // Save the index of this char into its respective bucket
        buckets[ch - 'a'].add(i);
      }
    }

    // Clean up by removing all marked chars (spaces)
    return sb.toString().replaceAll(" ", "");
  }
}

/*
⏱ Time Complexity: O(n)
- Each character is processed once.
- Bucket lookups are at most 26 operations per '*'.

🧠 Space Complexity: O(n)
- Space for `buckets` to track character positions.
- `StringBuilder` of size n for output building.

📌 Intuition:
- Think of buckets like 26 mini-stacks (one per char). At each `*`, remove the most recent occurrence of the smallest available char.
*/
