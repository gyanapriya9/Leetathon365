// 145. Binary Tree Postorder Traversal
// Easy

// Problem:
// Given the root of a binary tree,
// return the postorder traversal of its nodes' values.

// Postorder Traversal: left → right → root

// Example 1:
// Input: root = [1,null,2,3]
// Output: [3,2,1]

// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [4,6,7,5,2,9,8,3,1]

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
// Try doing it iteratively as well (non-recursive).

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

// Recursive Postorder Solution (left -> right -> root)
class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    postorder(root, ans);
    return ans;
  }

  private void postorder(TreeNode root, List<Integer> ans) {
    if (root == null)
      return;

    // Traverse left subtree
    postorder(root.left, ans);

    // Traverse right subtree
    postorder(root.right, ans);

    // Visit root
    ans.add(root.val);
  }
}
