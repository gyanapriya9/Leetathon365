// LeetCode 26: Remove Duplicates from Sorted Array (Level: Easy)


// 🧠 Problem Explanation:
/*
Given a **sorted** array `nums`, remove duplicates in-place such that each element appears only once.
Return the number of unique elements (let's call it `k`).

Modify the original array so that the first `k` elements are the unique values.
The values beyond `k` don't matter.
*/


// 🧪 Examples:
/*
Input:  nums = [1,1,2]               → Output: 2, nums = [1,2,_]
Input:  nums = [0,0,1,1,2,2,3,3,4]   → Output: 5, nums = [0,1,2,3,4,_,_,_,_]
*/


// 💡 Approach:
/*
1. Use a pointer `i` to track the position of the last unique element.
2. Iterate through the array using a for-each loop.
3. If the current number is greater than the last inserted unique number (`nums[i-1]`), insert it at `nums[i]`.
4. Return `i`, which gives the count of unique elements.
*/


// ✅ Solution:
class Solution {
  public int removeDuplicates(int[] nums) {
    int i = 0;

    for (final int num : nums)
      if (i < 1 || num > nums[i - 1])  // First element or strictly greater (to skip duplicates)
        nums[i++] = num;               // Place the unique value and move pointer

    return i;
  }
}


//Time Complexity: O(n)
//Space Complexity: O(1) (in-place)