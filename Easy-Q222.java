// LeetCode 222: Count Complete Tree Nodes — Medium

class Solution {
  public int countNodes(TreeNode root) {
    if (root == null)
      return 0;

    int leftHeight = getHeight(root, true);
    int rightHeight = getHeight(root, false);

    // ✅ If left and right heights are equal, it's a full tree
    if (leftHeight == rightHeight)
      return (1 << leftHeight) - 1; // 2^height - 1 nodes in a full binary tree

    // ✅ Otherwise, recurse on left and right
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  private int getHeight(TreeNode node, boolean left) {
    int height = 0;
    while (node != null) {
      height++;
      node = left ? node.left : node.right;
    }
    return height;
  }

  /*
   🧠 Flashcard-Style Summary:
   ----------------------------
   ✅ Problem: Count the number of nodes in a **complete** binary tree.

   ✅ Key Property of Complete Binary Tree:
     - All levels are completely filled **except possibly the last**.
     - Last level nodes are as **far left as possible**.

   ✅ Strategy:
     - If left height == right height → it's a full binary tree → node count = 2^h - 1
     - Else → recursively count left + right + 1 (root)

   ✅ Example:
     Input: [1,2,3,4,5,6]
     Left Height = 3, Right Height = 2 → Not full → recurse

   ⏱ Time: O(log²n) — log n for height, and potentially log n levels  
   📦 Space: O(log n) — for recursion stack
  */
}
