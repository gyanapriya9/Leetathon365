// LeetCode 83: Remove Duplicates from Sorted List

// 🧠 Problem:
/*
Given the head of a sorted linked list, delete all duplicates such that 
each element appears only once. Return the linked list sorted as well.
*/


// 🧪 Examples:
/*
Input:  head = [1,1,2]         → Output: [1,2]
Input:  head = [1,1,2,3,3]     → Output: [1,2,3]
*/


// 💡 Approach (One Pass Traversal):
/*
- Use a pointer `curr` to traverse the list.
- While `curr.next` exists and the current node's value equals the next's,
  skip the next node by pointing `curr.next` to `curr.next.next`.
- Move `curr` to the next node.
- Since the list is sorted, all duplicates are adjacent.
*/


// ✅ Java Code:
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;

    while (curr != null) {
      while (curr.next != null && curr.val == curr.next.val)
        curr.next = curr.next.next; // skip duplicate
      curr = curr.next;
    }

    return head;
  }
}


// ⏱ Time Complexity: O(n)
// 🔁 Each node is visited once

// 🧠 Space Complexity: O(1)
// ✅ In-place modification without extra memory
