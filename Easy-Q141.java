// 141. Linked List Cycle
// Easy

// Problem:
// Given head, the head of a linked list,
// determine if the linked list has a cycle in it.

// A cycle exists if some node can be reached again
// by continuously following the next pointer.

// Return true if there is a cycle in the linked list.
// Otherwise, return false.

// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: tail connects to the 1st node (0-indexed).

// Example 2:
// Input: head = [1,2], pos = 0
// Output: true
// Explanation: tail connects to the 0th node.

// Example 3:
// Input: head = [1], pos = -1
// Output: false
// Explanation: No cycle present.

// Constraints:
// - The number of nodes in the list is in the range [0, 10^4]
// - -10^5 <= Node.val <= 10^5
// - pos is -1 or a valid index in the linked-list

// Follow-up:
// Can you solve it using O(1) memory?

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class Solution {
  public boolean hasCycle(ListNode head) {
    // Use two pointers (Floyd's Tortoise and Hare algorithm)
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      // Move slow by 1 step
      slow = slow.next;

      // Move fast by 2 steps
      fast = fast.next.next;

      // If slow and fast meet, there is a cycle
      if (slow == fast)
        return true;
    }

    // No cycle if fast pointer reaches end
    return false;
  }
}
