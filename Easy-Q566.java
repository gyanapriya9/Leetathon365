// 566. Reshape the Matrix
// Given a 2D matrix, convert it into a new one with different dimensions (r x c).
// Return the new reshaped matrix if possible, otherwise return the original.
// We are using a linear index to map old matrix values into the new matrix directly.
// Approach: Flatten and refill using linear index mapping

class Solution {
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    // Edge case: if reshape is not possible (total elements must remain the same)
    if (nums.length == 0 || r * c != nums.length * nums[0].length)
      return nums; // Return original matrix

    // Create new reshaped matrix
    int[][] ans = new int[r][c];
    int k = 0; // Linear index to track current position

    // Traverse the original matrix row by row
    for (int[] row : nums)
      for (final int num : row) {
        // Map the linear index to 2D coordinates in the new matrix
        ans[k / c][k % c] = num;
        ++k; // Move to next index
      }

    return ans; // Return the reshaped matrix
  }
}
