// 501. Find Mode in Binary Search Tree
// Question:
// Given the root of a BST that may contain duplicates, return all modes (most frequently occurring elements).
// - A BST is such that left subtree ≤ root and right subtree ≥ root.
// - Return all values with highest frequency.

// Approach:
// - Perform an inorder traversal (which yields sorted order in BST).
// - Keep track of current node value frequency (`currCount`) and update the max frequency (`maxCount`) found so far.
// - Use a global `pred` (predecessor) node to detect if the current value is the same as the previous.
// - When a new value is encountered, reset the counter.
// - If a new frequency exceeds `maxCount`, reset the result list.
// - If frequency matches `maxCount`, add to result list.

class Solution {
  public int[] findMode(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    // count[0] = current frequency, count[1] = max frequency
    int[] count = new int[2];

    inorder(root, count, ans);  // Perform inorder traversal
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }

  private TreeNode pred = null; // Holds the previous node during inorder

  private void inorder(TreeNode root, int[] count, List<Integer> ans) {
    if (root == null)
      return;

    inorder(root.left, count, ans);   // Visit left
    updateCount(root, count, ans);    // Process current node
    inorder(root.right, count, ans);  // Visit right
  }

  // Updates frequency counts and handles result list logic
  private void updateCount(TreeNode root, int[] count, List<Integer> ans) {
    if (pred != null && pred.val == root.val)
      ++count[0]; // Same value as previous, increment count
    else
      count[0] = 1; // New value, reset count

    if (count[0] > count[1]) {
      count[1] = count[0];  // New max frequency
      ans.clear();          // Clear previous modes
      ans.add(root.val);    // Add current value as new mode
    } else if (count[0] == count[1]) {
      ans.add(root.val);    // Same as max frequency, add to result
    }

    pred = root; // Update predecessor
  }
}

// Time Complexity: O(n) - every node is visited once in inorder traversal
// Space Complexity: O(h + m), where h = height of tree (stack space), m = number of modes
