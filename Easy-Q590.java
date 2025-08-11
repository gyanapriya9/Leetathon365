// Question: 590. N-ary Tree Postorder Traversal
// --------------------------------------------------------
// Flashcard Explanation:
// What is required?
//   - Given an N-ary tree, return its postorder traversal (children before root).
// Approach used:
//   - Iterative approach using a stack to simulate recursion.
//   - Push nodes in reverse visiting order and then reverse the result list.
// --------------------------------------------------------

class Solution {
  public List<Integer> postorder(Node root) {
    // Base case: if root is null, return empty list
    if (root == null)
      return new ArrayList<>();

    List<Integer> ans = new ArrayList<>();
    Deque<Node> stack = new ArrayDeque<>();

    // Step 1: Push root to stack
    stack.push(root);

    // Step 2: Loop while stack is not empty
    while (!stack.isEmpty()) {
      // Step 3: Pop the top node from stack
      root = stack.pop();

      // Step 4: Add node's value to answer list
      ans.add(root.val);

      // Step 5: Push all children to stack
      for (Node child : root.children)
        stack.push(child);
    }

    // Step 6: Reverse the answer list to get postorder
    Collections.reverse(ans);

    // Step 7: Return final postorder list
    return ans;
  }
}

// --------------------------------------------------------
// Time Complexity: O(n) - visiting each node exactly once
// Space Complexity: O(n) - for stack and result list
// --------------------------------------------------------
