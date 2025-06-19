// LeetCode 257: Binary Tree Paths — Easy

class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> ans = new ArrayList<>();
    dfs(root, new StringBuilder(), ans);
    return ans;
  }

  // DFS helper to build path strings
  private void dfs(TreeNode root, StringBuilder sb, List<String> ans) {
    if (root == null) return;

    int len = sb.length(); // Save current length for backtracking
    sb.append(root.val);

    // Leaf node found — add path to result
    if (root.left == null && root.right == null) {
      ans.add(sb.toString());
    } else {
      sb.append("->"); // Append arrow for non-leaf nodes
      dfs(root.left, sb, ans);    // Left subtree
      dfs(root.right, sb, ans);   // Right subtree
    }

    sb.setLength(len); // Backtrack to previous state
  }

  /*
    Flashcard Summary:
   -----------------------
   Problem: Return all root-to-leaf paths in a binary tree.
   Example:
     Input: [1, 2, 3, null, 5]
     Output: ["1->2->5", "1->3"]

   Approach:
     - Use Depth-First Search (DFS)
     - Accumulate path using StringBuilder
     - On reaching leaf node, add path to result list

   Key Concepts:
     - Tree Traversal
     - Backtracking
     - StringBuilder for path efficiency

   Time Complexity: O(N) — N is number of nodes
   Space Complexity: O(H) — H is height of the tree (recursive call stack)
  */
}
