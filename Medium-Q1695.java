// 1695. Maximum Erasure Value

// Flashcard Explanation:
// Problem: Find the maximum sum of a subarray with only unique elements.
// Approach: Sliding window with HashSet to maintain uniqueness.
// - Expand right boundary of window until a duplicate is found.
// - Shrink from the left until the duplicate is removed.
// - Track current window sum and update maximum score.

class Solution {
  public int maximumUniqueSubarray(int[] nums) {
    int ans = 0;                    // Stores the maximum score found so far
    int score = 0;                  // Current window score (sum of unique elements)
    Set<Integer> seen = new HashSet<>();  // HashSet to track unique elements in window

    for (int l = 0, r = 0; r < nums.length; ++r) {
      // While nums[r] is already in the set (duplicate), shrink window from left
      while (!seen.add(nums[r])) {
        score -= nums[l];          // Subtract nums[l] from score
        seen.remove(nums[l++]);    // Remove nums[l] from set and increment left pointer
      }
      score += nums[r];            // Add nums[r] to the current score
      ans = Math.max(ans, score);  // Update answer if current score is greater
    }

    return ans;                    // Return the maximum score of any unique subarray
  }
}

// Time Complexity: O(n) - Each element is added and removed from the set at most once.
// Space Complexity: O(n) - To store up to n elements in the HashSet.
