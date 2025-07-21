// 563. Binary Tree Tilt
// Question: Given the root of a binary tree, return the sum of all node tilts.
// A node's tilt = |sum of left subtree - sum of right subtree|.

// Flashcard:
// - Problem Type: Tree Traversal (Post-order)
// - Task: Calculate sum of tilts across all nodes
// - Approach: Use DFS to compute subtree sums and update tilt at each node during recursion

class Solution {
  public int findTilt(TreeNode root) {
    sum(root); // Start DFS traversal from the root to compute tilts
    return ans; // Return the total tilt accumulated
  }

  private int ans = 0; // Global variable to store total tilt

  // Helper method to calculate the sum of subtree rooted at 'root'
  private int sum(TreeNode root) {
    if (root == null)
      return 0; // If node is null, subtree sum is 0

    int l = sum(root.left);  // Recursively compute left subtree sum
    int r = sum(root.right); // Recursively compute right subtree sum

    ans += Math.abs(l - r);  // Add the current node's tilt to global answer

    return root.val + l + r; // Return total sum rooted at current node
  }
}

// Time Complexity: O(n), where n is the number of nodes in the tree
// Space Complexity: O(h), where h is the height of the tree (due to recursion stack)
