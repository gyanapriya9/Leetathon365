// 144. Binary Tree Preorder Traversal
// Easy

// Problem:
// Given the root of a binary tree,
// return the preorder traversal of its nodes' values.

// Preorder Traversal: root → left → right

// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [1,2,4,5,6,7,3,8,9]

// Example 3:
// Input: root = []
// Output: []

// Example 4:
// Input: root = [1]
// Output: [1]

// Constraints:
// - Number of nodes: [0, 100]
// - Node values: [-100, 100]

// Follow-up:
// Recursive solution is easy — try doing it iteratively too.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Recursive Preorder Solution (root -> left -> right)
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    preorder(root, ans);
    return ans;
  }

  private void preorder(TreeNode root, List<Integer> ans) {
    if (root == null)
      return;

    // Visit root
    ans.add(root.val);

    // Traverse left subtree
    preorder(root.left, ans);

    // Traverse right subtree
    preorder(root.right, ans);
  }
}
