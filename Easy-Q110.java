// LeetCode 110: Balanced Binary Tree

/*
🧠 Problem:
Given a binary tree, determine if it is height-balanced.
A height-balanced binary tree means the difference in height 
between left and right subtree of every node is at most 1.

🧪 Examples:
Input: root = [3,9,20,null,null,15,7]
Output: true

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Input: root = []
Output: true

💡 Approach:
- For each node, check the height difference between left and right subtree.
- If difference > 1, tree is not balanced.
- Recursively check if left and right subtrees are balanced.
- Use a helper function to compute the max depth of subtrees.

This approach uses a top-down recursion to validate balance.

*/

class Solution {
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    // Check height difference for current node
    int leftHeight = maxDepth(root.left);
    int rightHeight = maxDepth(root.right);

    // Check if current node is balanced and recursively check children
    return Math.abs(leftHeight - rightHeight) <= 1 &&
           isBalanced(root.left) &&
           isBalanced(root.right);
  }

  // Helper method to find max depth of a subtree
  private int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}

/*
⏱ Time Complexity: O(n²) in worst case because maxDepth is called for every node.
🧠 Space Complexity: O(h) due to recursion stack, h = height of the tree.
*/
