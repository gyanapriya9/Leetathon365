```java
// LeetCode 118: Pascal's Triangle

/*
🧠 Problem Summary:
Given an integer `numRows`, return the first `numRows` of Pascal's Triangle.

🔺 Pascal's Triangle Rule:
- The first and last elements of each row are 1.
- Any other element is the **sum of the two numbers directly above it**.

🧪 Examples:

Input: numRows = 5  
Output:  
[
 [1],  
 [1,1],  
 [1,2,1],  
 [1,3,3,1],  
 [1,4,6,4,1]  
]

Input: numRows = 1  
Output: [[1]]
  
💡 Approach:
1. Create a list of lists `ans`.
2. For each row:
   - Initialize with all 1s.
   - Fill inner values using values from the previous row:
     `curr[j] = prev[j - 1] + prev[j]`
*/

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();

    // Step 1: Initialize each row with 1s
    for (int i = 0; i < numRows; ++i) {
      Integer[] row = new Integer[i + 1];
      Arrays.fill(row, 1); // All elements as 1
      ans.add(Arrays.asList(row)); // Convert array to list and add to ans
    }

    // Step 2: Fill inner values using Pascal's Triangle rule
    for (int i = 2; i < numRows; ++i) {
      for (int j = 1; j < ans.get(i).size() - 1; ++j) {
        int val = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
        ans.get(i).set(j, val); // Update current value
      }
    }

    return ans;
  }
}

/*
⏱ Time Complexity: O(n²)
- Each row has up to n elements.

🧠 Space Complexity: O(n²)
- Space used to store all elements in the triangle.

📌 Flashcard Summary:
🔹 Each row starts and ends with 1.
🔹 Middle values: sum of two values above it.
🔹 Build row-by-row using previously built rows.
*/
```
