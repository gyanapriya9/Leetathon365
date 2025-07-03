class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null)
      return 0; // Base case: if the tree is empty, return 0

    int ans = 0;

    // Check if the left child exists
    if (root.left != null) {
      // If the left child is a leaf (no children), add its value
      if (root.left.left == null && root.left.right == null)
        ans += root.left.val;
      else
        // Otherwise, continue recursively on the left subtree
        ans += sumOfLeftLeaves(root.left);
    }

    // Always continue on the right subtree (could have left leaves deeper down)
    ans += sumOfLeftLeaves(root.right);

    return ans;
  }
}
