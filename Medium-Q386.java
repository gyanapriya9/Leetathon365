// LeetCode 386: Lexicographical Numbers

/*
🧠 Problem Summary:
Given an integer `n`, return all the numbers from 1 to `n` **in lexicographical order**.

Example:
Input: n = 13  
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

Lexicographical order is dictionary order:
- Like how strings are sorted: 1, 10, 100, ..., 109, 11, ..., 19, 2, 20, ..., 9

Constraints:
- Time: O(n)
- Space: O(1) extra space (excluding result list)

Approach:
Use **DFS-like traversal**:
1. Start from `curr = 1`.
2. Try to go deeper: `curr *= 10` (adds '0' at end, like moving to the next child).
3. If you can't go deeper (i.e., `curr * 10 > n`), move to the next sibling: `++curr`.
4. But if you reach the end of a branch (e.g., 9, 19, ...), backtrack using `curr /= 10` until you can increment.

This simulates pre-order traversal on a **trie-like structure** of numbers.

*/

class Solution {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> ans = new ArrayList<>();
    int curr = 1;

    while (ans.size() < n) {
      ans.add(curr);

      // Try to go deeper (children: 10, 100, 1000, etc.)
      if (curr * 10 <= n) {
        curr *= 10;
      } else {
        // If at end of branch, move up until we find next sibling
        while (curr % 10 == 9 || curr == n) {
          curr /= 10;
        }
        ++curr;  // Move to next number
      }
    }

    return ans;
  }
}

/*
⏱ Time Complexity: O(n)
- Each number from 1 to n is visited exactly once.

Space Complexity: O(1) extra (excluding result list)

Flashcard Summary:
🔹 Simulate pre-order DFS over a 10-ary tree of numbers.
🔹 Go deeper using `curr *= 10`, backtrack when hitting ends.
🔹 Efficient lexicographical order generation in O(n) time.
*/
