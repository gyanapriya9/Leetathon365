// LeetCode 2294: Partition Array Such That Maximum Difference Is K — Medium

class Solution {
  public int partitionArray(int[] nums, int k) {
    // Step 1: Sort the array to group close elements
    Arrays.sort(nums);

    // Initialize first group with first element
    int ans = 1;
    int mn = nums[0]; // start of the current group

    // Step 2: Traverse the sorted array
    for (int i = 1; i < nums.length; ++i) {
      // If current element exceeds allowed range, start a new group
      if (nums[i] > mn + k) {
        ++ans;
        mn = nums[i]; // reset start of new group
      }
    }

    return ans;
  }

  /*
   Flashcard Summary:
   -----------------------
   Problem: Partition array into subsequences such that max - min ≤ k
   Goal: Minimize number of such subsequences

   Approach:
     1. Sort the array
     2. Traverse and group elements as long as (current - groupStart) ≤ k
     3. If not, start new group

   Example:
     Input: nums = [3,6,1,2,5], k = 2
     Sorted: [1,2,3,5,6]
     Group 1: [1,2,3] (1→3 ≤ 2)
     Group 2: [5,6]   (5→6 ≤ 2)
     Output: 2

   ⏱ Time Complexity: O(n log n) → due to sorting
   Space Complexity: O(1) → in-place grouping
  */
}
