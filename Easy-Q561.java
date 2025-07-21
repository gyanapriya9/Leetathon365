// 561. Array Partition
// Question: Given an array of 2n integers, form n pairs such that the sum of the minimum value in each pair is maximized.

// Flashcard:
// - Goal: Maximize the sum of min(ai, bi) for each pair.
// - Approach: Sort the array and pick every second element starting from index 0. 
//   Why? Sorting arranges numbers so pairing adjacent elements gives the largest possible minimums overall.

class Solution {
  public int arrayPairSum(int[] nums) {
    int ans = 0;

    // Step 1: Sort the array in ascending order
    Arrays.sort(nums); // So the minimum of each pair is at an even index

    // Step 2: Add every first element of each pair (i.e., every even index)
    for (int i = 0; i < nums.length; i += 2)
      ans += nums[i]; // We choose nums[i] as the min of the pair (nums[i], nums[i+1])

    return ans; // Final result: maximum possible sum of mins from all pairs
  }
}

// Time Complexity: O(n log n), due to sorting
// Space Complexity: O(1), if sorting is done in-place
