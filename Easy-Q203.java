// LeetCode 203. Remove Linked List Elements — Easy
// Given a linked list, remove all nodes with the value == val and return the new head.

class Solution {
  public ListNode removeElements(ListNode head, int val) {
    // Create a dummy node pointing to the head to handle edge cases like head being deleted
    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;

    // Traverse the list and remove nodes with value == val
    while (head != null) {
      if (head.val != val) {
        prev.next = head;      // Keep the current node
        prev = prev.next;
      }
      head = head.next;        // Move to the next node
    }

    // Cut off any lingering references (important if last nodes had val)
    prev.next = null;

    // Return the next of dummy node which is the new head
    return dummy.next;
  }

  /*
    Flashcard Style Explanation:
    ----------------------------
    ✅ Problem: Remove all nodes in a linked list that have a given value.
    ✅ Strategy: Use a dummy node to handle edge cases cleanly (like removing head).
    ✅ Traverse with two pointers:
       - `head`: current node
       - `prev`: last node that wasn't removed
    ✅ Cut off `prev.next` after traversal to ensure no lingering links.
    
    Example:
    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]
  */
}
