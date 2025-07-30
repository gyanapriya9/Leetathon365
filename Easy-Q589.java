// 589. N-ary Tree Preorder Traversal

/*
Flashcard Explanation:
Task: Perform a preorder traversal (Root -> Children from left to right) on an N-ary tree and return a list of node values.
Approach: Use an iterative approach with a stack (DFS style), pushing children in reverse order to ensure left-to-right processing.
*/

class Solution {
  public List<Integer> preorder(Node root) {
    // If the tree is empty, return an empty list
    if (root == null)
      return new ArrayList<>();

    List<Integer> ans = new ArrayList<>();
    Deque<Node> stack = new ArrayDeque<>();

    // Start traversal by pushing the root node onto the stack
    stack.push(root);

    // Continue while there are nodes to process
    while (!stack.isEmpty()) {
      // Pop the top node from the stack
      root = stack.pop();
      // Add the value of the current node to the result list
      ans.add(root.val);

      // Push the children of the current node onto the stack in reverse order
      // so that the leftmost child is processed first
      for (int i = root.children.size() - 1; i >= 0; --i)
        stack.push(root.children.get(i));
    }

    // Return the final preorder traversal list
    return ans;
  }
}

/*
Time Complexity: O(n), where n is the number of nodes in the tree
Space Complexity: O(n), for the stack and the result list
*/
