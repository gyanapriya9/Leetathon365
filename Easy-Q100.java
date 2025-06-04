// 100. Same Tree
// Easy - Compare two binary trees for structural and value equality

class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    // If either node is null, both must be null to be same
    if (p == null || q == null)
      return p == q;
    
    // Check current values and recurse on left and right subtrees
    return p.val == q.val &&
           isSameTree(p.left, q.left) &&
           isSameTree(p.right, q.right);
  }
}

//Time Complexity: O(n)
//n = total number of nodes in the smaller tree

//Every node is visited once

//Space Complexity: O(h)
//h = height of the tree (due to recursion stack)