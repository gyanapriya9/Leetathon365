class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxCount = 0;      // Stores the maximum number of consecutive 1's found so far
    int currentCount = 0;  // Counts the current streak of 1's

    for (int num : nums) {
      if (num == 1) {
        // If current number is 1, increment the current streak
        currentCount++;
        // Update maxCount if current streak is the longest so far
        maxCount = Math.max(maxCount, currentCount);
      } else {
        // If current number is 0, reset the current streak
        currentCount = 0;
      }
    }

    return maxCount; // Return the maximum streak of consecutive 1's
  }
}
