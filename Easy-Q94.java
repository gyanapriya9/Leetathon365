// LeetCode 94: Binary Tree Inorder Traversal

// 🧠 Problem:
/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.
Inorder traversal: left → root → right
*/


// 🧪 Examples:
/*
Input: root = [1,null,2,3]
Output: [1,3,2]

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]

Input: root = []
Output: []

Input: root = [1]
Output: [1]
*/


// 💡 Approach (Iterative using Stack):
/*
- Use a stack to simulate recursion
- Traverse to the leftmost node, pushing each node onto the stack
- Pop from stack, process node, and move to its right child
*/


// ✅ Java Code:
class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();

    while (root != null || !stack.isEmpty()) {
      // Go as left as possible
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      // Backtrack
      root = stack.pop();
      ans.add(root.val);
      root = root.right;
    }

    return ans;
  }
}


// ⏱ Time Complexity: O(n)
// 🔁 We visit each node exactly once (n = number of nodes)

// 🧠 Space Complexity: O(h)
// 💾 Stack holds at most h nodes where h = height of tree
