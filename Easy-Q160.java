// 160. Intersection of Two Linked Lists
// Easy

// ✅ Problem Statement:
// Given the heads of two singly linked lists, return the node at which the two lists intersect.
// If they don't intersect, return null. You must do it in O(m + n) time and O(1) space.

// ✅ Example:
// Input: headA = [4,1,8,4,5], headB = [5,6,1,8,4,5]
// Output: Intersected at '8'

// ✅ Approach:
// Use two pointers to traverse both lists. When one reaches the end, switch to the other list's head.
// If the lists intersect, the pointers will meet at the intersection node after at most m + n steps.
// If they don't intersect, both pointers will end up as null at the same time.

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists
        while (a != b) {
            // If 'a' reaches the end of its list, switch to head of listB
            a = (a == null) ? headB : a.next;

            // If 'b' reaches the end of its list, switch to head of listA
            b = (b == null) ? headA : b.next;
        }

        // Either both pointers meet at intersection or both become null
        return a;
    }
}

// ✅ Time Complexity: O(m + n), where m and n are lengths of the two lists.
// ✅ Space Complexity: O(1), no extra space used.

// 💡 Note:
// We rely on pointer equality, not node value equality.
// Even if node values are the same, they must be the same object in memory to be considered intersecting.
