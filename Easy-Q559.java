// 559. Maximum Depth of N-ary Tree
// Question: Given the root of an N-ary tree, find its maximum depth.
// Flashcard: 
// - Goal: Find the length of the longest path from the root to any leaf node.
// - Approach: Use DFS (Depth First Search) recursively to explore each child and find the maximum depth.

class Solution {
  public int maxDepth(Node root) {
    // If the root is null, the depth is 0
    if (root == null)
      return 0;

    // Initialize the maximum depth from this node as 0
    int ans = 0;

    // Traverse all children of the current node
    for (Node child : root.children)
      // Recursively find max depth of children and update the answer
      ans = Math.max(ans, maxDepth(child));

    // Add 1 to account for the current node's level
    return 1 + ans;
  }
}

// Time Complexity: O(n), where n is the number of nodes in the tree (each node is visited once).
// Space Complexity: O(h), where h is the height of the tree (due to recursive call stack).
