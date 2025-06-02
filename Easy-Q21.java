// LeetCode 21: Merge Two Sorted Lists (Level: Easy)


// 🧠 Problem Explanation:
/*
You are given the heads of two sorted linked lists, `list1` and `list2`.

You need to merge them into one sorted list by rearranging and reusing nodes from the original lists.

Return the head of the merged linked list.
*/


// 🧪 Examples:
/*
Input:  list1 = [1,2,4], list2 = [1,3,4]   → Output: [1,1,2,3,4,4]
Input:  list1 = [], list2 = []             → Output: []
Input:  list1 = [], list2 = [0]            → Output: [0]
*/


// 💡 Approach:
/*
1. Use recursion to compare the heads of both lists.
2. Always attach the smaller value node to the result list.
3. Recur on the next of the selected node and the other list.
4. Base condition: if one list is null, return the other.
*/


// 🧱 Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


// ✅ Recursive Solution:
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // If either list is null, return the other
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        // Ensure list1 has the smaller head value
        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        // Recur for the next node
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }
}
