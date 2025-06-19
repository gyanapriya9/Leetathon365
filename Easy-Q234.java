// LeetCode 234: Palindrome Linked List — Easy

class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;

    ListNode slow = head;
    ListNode fast = head;

    // 🐢 Step 1: Use slow-fast pointer to reach the middle of the list
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // ⏩ If the list has odd number of nodes, skip the middle node
    if (fast != null)
      slow = slow.next;

    // 🔁 Step 2: Reverse the second half of the list
    slow = reverseList(slow);

    // 🔍 Step 3: Compare the first half and the reversed second half
    ListNode firstHalf = head;
    while (slow != null) {
      if (firstHalf.val != slow.val)
        return false;
      firstHalf = firstHalf.next;
      slow = slow.next;
    }

    return true;
  }

  // Helper: Reverses a linked list and returns the new head
  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  /*
   Flashcard Summary:
   -----------------------
   Problem: Check if a singly linked list is a palindrome.
   Goal: Must be done in O(n) time and O(1) space.

   Approach:
     1. Use slow/fast pointers to find middle of list
     2. Reverse second half
     3. Compare both halves
     4. (Optional: Restore the list)

   Example:
     Input: [1, 2, 2, 1] → Output: true
     Input: [1, 2] → Output: false

   Time Complexity: O(n)
   Space Complexity: O(1)
  */
}
