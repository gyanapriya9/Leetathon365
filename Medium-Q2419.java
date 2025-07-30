// Leetcode 2419. Longest Subarray With Maximum Bitwise AND
// ----------------------------------------------------------
// Problem Summary:
// Given an integer array `nums`, find the length of the longest contiguous subarray
// such that the bitwise AND of all elements in that subarray is equal to the maximum 
// bitwise AND value achievable by any subarray in `nums`.
//
// Flashcard Explanation:
// - Task: Find the maximum bitwise AND value in all subarrays.
// - Only subarrays with this max AND value are considered.
// - Return the length of the longest such subarray.
// - Insight: Bitwise AND decreases or stays same as the subarray grows.
// - So, the max AND must come from the individual max elements themselves.
// - We just need to count the longest sequence of elements equal to the max value.

class Solution {
  public int longestSubarray(int[] nums) {
    int ans = 0;            // Stores the maximum length of subarray with max AND
    int maxIndex = 0;       // Tracks the index of the current maximum value in the array
    int sameNumLength = 0;  // Counter for consecutive elements equal to the max value

    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == nums[maxIndex]) {
        // If current number is equal to the current max, increment the streak
        ans = Math.max(ans, ++sameNumLength);
      } else if (nums[i] > nums[maxIndex]) {
        // If current number is greater than the current max,
        // update maxIndex and reset streak count to 1
        maxIndex = i;
        sameNumLength = 1;
        ans = 1;
      } else {
        // Current number is less than the max value; reset streak count
        sameNumLength = 0;
      }
    }

    return ans;
  }
}

// Time Complexity: O(n) - Single pass through the array
// Space Complexity: O(1) - Constant extra space used
