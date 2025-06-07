// LeetCode 112: Path Sum

/*
🧠 Problem Summary:
Given a binary tree and an integer `targetSum`, check if there's **any root-to-leaf path** such that the sum of node values on that path equals `targetSum`.

🔍 Note:
- A **leaf node** is a node with no left and right children.
- The path must go from **root to leaf** (not just any node).

🧪 Examples:

Example 1:
Input:  root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22  
Output: true  
Explanation: Path 5 → 4 → 11 → 2 = 22 ✅

Example 2:
Input: root = [1,2,3], targetSum = 5  
Output: false  
Explanation: No root-to-leaf path sums to 5 ❌

Example 3:
Input: root = [], targetSum = 0  
Output: false  
Explanation: Tree is empty → no path ❌

💡 Approach (Recursive DFS):
- Subtract current node's value from `targetSum`.
- Recursively check left and right subtrees with the **remaining sum**.
- If a leaf is reached and the remaining sum equals the node's value → return true.
*/

class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null)
      return false; // Base case: empty tree has no paths

    // If this is a leaf node, check if its value equals the remaining targetSum
    if (root.left == null && root.right == null)
      return root.val == targetSum;

    // Recur down the tree with the reduced sum
    int remainingSum = targetSum - root.val;
    return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
  }
}

/*
⏱ Time Complexity: O(n)
- We visit each node at most once.

🧠 Space Complexity: O(h)
- Recursion stack space, where h = height of the tree.

📌 Flashcard Summary:
✅ Check root-to-leaf paths.
✅ Subtract node value at each step.
✅ Return true only when a leaf node’s value matches remaining sum.
*/
