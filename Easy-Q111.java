// LeetCode 111: Minimum Depth of Binary Tree

/*
🧠 Problem Summary:
You are given the root of a binary tree.
Your task is to find the **minimum depth**, defined as:
👉 The number of nodes along the **shortest path** from the root down to the **nearest leaf** node.

🔍 Note:
- A **leaf node** is a node with no left or right child.
- A path must reach a **leaf**, not just any node.

🧪 Examples:

Input:  root = [3,9,20,null,null,15,7]
Output: 2
Explanation: 9 is the nearest leaf from root (path: 3 → 9)

Input:  root = [2,null,3,null,4,null,5,null,6]
Output: 5
Explanation: The shortest path to a leaf is 5 nodes long.

💡 Approach (Top-Down DFS):
- Traverse recursively down the tree.
- For each node:
  - If it has only one child (left or right), we cannot consider a null branch.
  - So we handle missing children specially.
- Return 1 + minimum of left/right subtree depths.
*/

class Solution {
  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;  // Base case: empty tree

    // If only left is null, go right
    if (root.left == null)
      return minDepth(root.right) + 1;

    // If only right is null, go left
    if (root.right == null)
      return minDepth(root.left) + 1;

    // Both children exist → take the shorter one
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}

/*
⏱ Time Complexity: O(n)
- In the worst case, we visit each node once.

🧠 Space Complexity: O(h)
- Due to recursion stack, where `h` is the height of the tree.

📌 Tip:
- If you were using **BFS**, you'd return the depth as soon as you hit the first leaf node.
- This DFS version carefully ensures only valid paths to **leaf nodes** are considered.
*/
