// 543. Diameter of Binary Tree

/*
Flashcard Explanation:
Given a binary tree, we need to find the longest path between any two nodes (number of edges), 
which is called the diameter. This path can pass through or bypass the root.

Approach:
We use DFS (post-order traversal) to compute the depth of each node’s left and right subtree.
At each node, we calculate the diameter as the sum of left and right subtree depths.
We keep track of the maximum diameter globally.

Why this works:
- The depth helps us understand the number of edges from the current node to its deepest leaf.
- The longest path through the current node is left depth + right depth.
*/

class Solution {
  private int diameter = 0; // Stores the maximum diameter found

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root); // Start post-order traversal from root
    return diameter; // Return the longest path found
  }

  private int depth(TreeNode node) {
    if (node == null) return 0; // Base case: null node has depth 0

    int left = depth(node.left); // Recursively find left depth
    int right = depth(node.right); // Recursively find right depth

    diameter = Math.max(diameter, left + right); // Update max diameter if needed

    return Math.max(left, right) + 1; // Return height of current node’s subtree
  }
}

/*
Time Complexity: O(n) – Every node is visited once
Space Complexity: O(h) – h is the height of the tree (stack space for recursion)
*/
