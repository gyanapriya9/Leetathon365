// LeetCode 88: Merge Sorted Array

// 🧠 Problem:
/*
You are given two sorted integer arrays nums1 and nums2, and their valid lengths m and n.
Modify nums1 in-place to contain all elements from both arrays in sorted order.
nums1 has enough space to hold the result (length = m + n).
*/


// 🧪 Example:
/*
Input:  nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3
Output: [1,2,2,3,5,6]
*/


// 💡 Approach (Two Pointers from End):
/*
- Start filling from the back of nums1 to avoid overwriting elements.
- Use three pointers:
    i = m - 1 → last actual element in nums1
    j = n - 1 → last element in nums2
    k = m + n - 1 → last position in nums1
- Compare nums1[i] and nums2[j], put the larger one at nums1[k], and move pointers accordingly.
*/


// ✅ Java Code:
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;     // pointer for nums1
    int j = n - 1;     // pointer for nums2
    int k = m + n - 1; // pointer for placement in nums1

    // Compare from the back and fill nums1
    while (j >= 0) {
      if (i >= 0 && nums1[i] > nums2[j])
        nums1[k--] = nums1[i--];
      else
        nums1[k--] = nums2[j--];
    }
  }
}


// ⏱ Time Complexity: O(m + n)
// 🔁 Each element is checked once

// 🧠 Space Complexity: O(1)
// ✅ In-place merging with constant space
