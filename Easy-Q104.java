// ✅ LeetCode 101: Symmetric Tree

// 🧠 Problem:
/*
Given the root of a binary tree, check whether it is a mirror of itself 
(i.e., symmetric around its center).
*/

// 🧪 Examples:
/*
Input:  root = [1,2,2,3,4,4,3]
Output: true

Input:  root = [1,2,2,null,3,null,3]
Output: false
*/

// 💡 Approach (Recursive):
/*
- A tree is symmetric if the left subtree is a mirror reflection of the right subtree.
- We define a helper function that checks if two trees are mirrors of each other.
- Base Case:
  - Both nodes are null → true
  - One is null and the other is not → false
  - Values differ → false
- Recursive Case:
  - Compare left subtree of one with right subtree of the other and vice versa
*/

class Solution {
  public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root); // Start by comparing the tree with itself
  }

  private boolean isMirror(TreeNode p, TreeNode q) {
    // If both nodes are null, they are mirrors
    if (p == null && q == null) return true;

    // If only one is null, or their values don't match → not mirrors
    if (p == null || q == null || p.val != q.val) return false;

    // Recursively compare the left subtree of one to the right subtree of the other
    return isMirror(p.left, q.right) && isMirror(p.right, q.left);
  }
}


// ⏱ Time Complexity: O(n)
// - We visit each node once

// 🧠 Space Complexity: O(h)
// - Due to recursive stack, where h is the height of the tree
