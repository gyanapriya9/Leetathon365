// 572. Subtree of Another Tree

// Flashcard Explanation:
//  Goal: Check if `subRoot` is a subtree of `root`.
//  A subtree is any node in the main tree and all its descendants.
//  Approach: Use recursion to compare each subtree of `root` with `subRoot`.
//    - At each node, check if the tree starting at that node matches `subRoot` using helper `isSameTree`.
//    - If match found, return true. Else, check left and right subtrees recursively.

class Solution {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    // Base case: if main tree is null, it can't have any subtree
    if (s == null)
      return false;

    // Check if the current subtree rooted at 's' matches 't'
    if (isSameTree(s, t))
      return true;

    // Recursively check left and right subtrees
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean isSameTree(TreeNode p, TreeNode q) {
    // If either node is null, return true only if both are null
    if (p == null || q == null)
      return p == q;

    // Check current node value and recursively check left and right children
    return p.val == q.val && 
           isSameTree(p.left, q.left) && 
           isSameTree(p.right, q.right);
  }
}

// Time Complexity: O(m * n), where m = number of nodes in root, n = number in subRoot
// Space Complexity: O(h), where h = height of the tree (due to recursion stack)
