// Question: 498. Diagonal Traverse
// Quick Flashcard Summary:
// We need to traverse a given m x n matrix diagonally and return all elements in diagonal order.
// Diagonal order means: start from (0,0), move upward-right until out-of-bounds, then switch direction 
// to downward-left, and so on until all elements are visited.
// Approach: Simulation approach using direction toggling. Keep track of row, col, and direction (d = 1 for upward, -1 for downward).
// Each step: record element, move diagonally, handle out-of-bound cases by adjusting row/col and flipping direction.

// Inside Code:
// - Start at (0,0), move diagonally according to direction.
// - If we go out of bounds, adjust row/col back inside and reverse direction.
// - Continue until all m*n elements are visited.

class Solution {
  public int[] findDiagonalOrder(int[][] matrix) {
    final int m = matrix.length;
    final int n = matrix[0].length;
    int[] ans = new int[m * n];
    int d = 1; // direction: 1 means moving upward-right, -1 means downward-left
    int row = 0;
    int col = 0;

    for (int i = 0; i < m * n; ++i) {
      ans[i] = matrix[row][col]; // record current element
      row -= d; // move along the diagonal
      col += d;

      // handle out-of-bounds conditions
      if (row == m) { // went past bottom
        row = m - 1;
        col += 2; // shift right
        d = -d;   // reverse direction
      }
      if (col == n) { // went past right
        col = n - 1;
        row += 2; // shift down
        d = -d;
      }
      if (row < 0) { // went past top
        row = 0;
        d = -d;
      }
      if (col < 0) { // went past left
        col = 0;
        d = -d;
      }
    }
    return ans;
  }
}

// Time Complexity: O(m * n), since each element is visited exactly once
// Space Complexity: O(m * n) for output array, O(1) extra space for variables
