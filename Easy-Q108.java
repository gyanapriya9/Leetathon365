// LeetCode 108: Convert Sorted Array to Binary Search Tree

/*
🧠 Problem:
Given a sorted integer array nums, convert it to a height-balanced BST.
A height-balanced BST has minimal height difference between left and right subtrees.

🧪 Example:
Input:  nums = [-10, -3, 0, 5, 9]
Output: A BST like [0, -3, 9, -10, null, 5]

Input: nums = [1, 3]
Output: A BST like [3, 1] or [1, null, 3]

💡 Approach:
- Use divide and conquer (recursion).
- Choose middle element as root for balanced height.
- Recursively build left subtree from left half.
- Recursively build right subtree from right half.
- Base case: if left index > right index, return null.

This ensures a balanced tree since middle splits array evenly.
*/

class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    // Start recursion from full array range
    return build(nums, 0, nums.length - 1);
  }

  private TreeNode build(int[] nums, int left, int right) {
    // Base case: no elements to process
    if (left > right) return null;

    // Middle element index (root of current subtree)
    int mid = (left + right) / 2;

    // Create node with middle element
    TreeNode root = new TreeNode(nums[mid]);

    // Recursively build left subtree with left half
    root.left = build(nums, left, mid - 1);

    // Recursively build right subtree with right half
    root.right = build(nums, mid + 1, right);

    return root;
  }
}

/*
⏱ Time Complexity: O(n), each element is visited once.
🧠 Space Complexity: O(log n) due to recursion stack on balanced tree.
*/
