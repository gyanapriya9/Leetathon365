// LeetCode 206. Reverse Linked List — Easy

// Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode nextTemp = curr.next; // Save next node
      curr.next = prev;              // Reverse the link
      prev = curr;                   // Move prev forward
      curr = nextTemp;               // Move current forward
    }

    return prev; // New head of reversed list
  }

  /*
   🧠 Flashcard-Style Summary:
   ----------------------------
   ✅ Problem: Reverse a singly linked list.

   ✅ Strategy:
     - Traverse the list while reversing pointers.
     - Use three pointers: `prev`, `curr`, and `nextTemp`.

   ✅ Key Operations:
     - `curr.next = prev`: core of reversal.
     - Move `prev` and `curr` forward.

   ✅ Edge Cases:
     - Empty list → return null
     - Single node → return same node

   📌 Example:
     Input: 1 → 2 → 3 → 4 → 5
     Output: 5 → 4 → 3 → 2 → 1

   ⏱ Time: O(n) | 📦 Space: O(1)
  */
}
