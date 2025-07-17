// 530. Minimum Absolute Difference in BST
// ------------------------------------------
// Flashcard Summary:
// Problem: Find the minimum absolute difference between values of any two nodes in a BST.
// Approach: In-order traversal of BST yields sorted values. Track difference between consecutive nodes.
// Why this works: In BST, in-order traversal gives sorted list — so min diff must be between consecutive nodes in this order.

class Solution {
  public int getMinimumDifference(TreeNode root) {
    // Variable to hold the result (minimum absolute difference)
    int ans = Integer.MAX_VALUE;

    // Variable to store value of previously visited node during in-order traversal
    int prev = -1;

    // Stack for iterative in-order traversal
    Deque<TreeNode> stack = new ArrayDeque<>();

    // Iterative in-order traversal starts
    while (root != null || !stack.isEmpty()) {
      // Go to the leftmost node
      while (root != null) {
        stack.push(root);  // push current node to stack
        root = root.left;  // move to left child
      }

      // Process node at top of stack
      root = stack.pop();

      // If previous node exists, calculate difference and update result if needed
      if (prev >= 0)
        ans = Math.min(ans, root.val - prev);

      // Update prev with current node's value
      prev = root.val;

      // Move to right child
      root = root.right;
    }

    // Return the minimum absolute difference found
    return ans;
  }
}

// Time Complexity: O(n) where n is the number of nodes in the tree (full traversal)
// Space Complexity: O(h) where h is the height of the tree (stack space for traversal)
