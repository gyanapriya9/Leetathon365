// LeetCode 119: Pascal's Triangle II

/*
🧠 Problem Summary:
Given an integer `rowIndex`, return the `rowIndex`-th row (0-indexed) of Pascal's Triangle.

🔺 Pascal's Triangle Rule:
- Each number is the sum of the two numbers directly above it.
- The first and last elements in any row are always 1.

🧪 Examples:

Input: rowIndex = 3  
Output: [1, 3, 3, 1]

Input: rowIndex = 0  
Output: [1]

Input: rowIndex = 1  
Output: [1, 1]

💡 Approach:
We only need a **single 1D array** to construct the row in-place:
1. Initialize an array `ans` of size `rowIndex + 1` with all elements as 1.
2. For each row from index 2 to rowIndex:
   - Update values **in reverse order** to avoid overwriting needed values.

⚠️ Reverse iteration is key here to ensure we use previous values from the row correctly.
*/

class Solution {
  public List<Integer> getRow(int rowIndex) {
    Integer[] ans = new Integer[rowIndex + 1];
    Arrays.fill(ans, 1);  // Initialize all with 1s

    for (int i = 2; i <= rowIndex; ++i) {
      // Traverse backwards to preserve previous values
      for (int j = i - 1; j > 0; --j) {
        ans[j] = ans[j] + ans[j - 1];
      }
    }

    return Arrays.asList(ans);  // Convert array to list
  }
}

/*
⏱ Time Complexity: O(n²)
- Each row iteration involves updating the current row elements.

💾 Space Complexity: O(n)
- Single array of size rowIndex + 1 is used.

📌 Flashcard Summary:
🔹 Use a 1D array to store and update the row.
🔹 Always update from right to left to preserve values.
🔹 `ans[j] = ans[j] + ans[j - 1]`
*/
