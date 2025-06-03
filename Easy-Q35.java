// LeetCode 35: Search Insert Position

// 🧠 Problem:
/*
Given a sorted array of distinct integers and a target,
return the index if the target is found.
If not, return the index where it would be inserted in order.

You must write an algorithm with O(log n) runtime complexity.
*/


// 🧪 Examples:
/*
Input:  nums = [1,3,5,6], target = 5 → Output: 2
Input:  nums = [1,3,5,6], target = 2 → Output: 1
Input:  nums = [1,3,5,6], target = 7 → Output: 4
*/


// 💡 Approach (Binary Search):
/*
1. Initialize two pointers: l = 0, r = nums.length.
2. Run binary search until l < r:
   - Compute mid = (l + r) / 2.
   - If nums[mid] == target → return mid.
   - If nums[mid] < target → search right half (l = mid + 1).
   - Else → search left half (r = mid).
3. Return l as the insertion index when the loop ends.
*/


// ✅ Java Code:
class Solution {
  public int searchInsert(int[] nums, int target) {
    int l = 0;
    int r = nums.length;

    while (l < r) {
      int m = (l + r) / 2;
      if (nums[m] == target)
        return m;
      else if (nums[m] < target)
        l = m + 1;
      else
        r = m;
    }

    return l; // l is the correct insert position
  }
}


// ⏱ Time Complexity: O(log n)
// - Binary search divides the array in half every iteration.

// 🧠 Space Complexity: O(1)
// - No extra space used.
