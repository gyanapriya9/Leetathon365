// LeetCode 27: Remove Element (Easy)


// 🧠 Problem Explanation:
/*
Given an array `nums` and a value `val`, remove all occurrences of `val` in-place.
The remaining elements can be in any order.
Return the count `k` of elements not equal to `val`.

The first `k` elements of the modified `nums` array should contain the non-`val` elements.
*/


// 🧪 Examples:
/*
Input:  nums = [3,2,2,3], val = 3         → Output: 2, nums = [2,2,_,_]
Input:  nums = [0,1,2,2,3,0,4,2], val = 2 → Output: 5, nums = [0,1,4,0,3,_,_,_]
*/


// 💡 Approach (Two Pointers with Swap):
/*
- Use pointer `i` to scan the array.
- Use pointer `n` to track the valid length.
- If nums[i] == val, replace it with nums[n-1] and reduce `n`.
- If not, move `i` forward.
- No need to preserve order beyond the first `k` elements.
*/


// ✅ Code:
class Solution {
  public int removeElement(int[] nums, int val) {
    int n = nums.length;
    int i = 0;

    while (i < n) {
      if (nums[i] == val) {
        nums[i] = nums[n - 1]; // Replace current with last valid element
        n--;                   // Shrink the array size
      } else {
        i++;                   // Move to next element
      }
    }

    return n; // Final count of non-val elements
  }
}

//Time Complexity: O(n)
//Space Complexity: O(1) (in-place)
