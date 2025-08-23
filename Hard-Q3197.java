// Question: 3197. Find the Minimum Area to Cover All Ones II
// Quick Flashcard Summary:
// We are given a 2D binary grid. Goal: Cover all cells containing 1's using exactly 3 non-overlapping rectangles 
// with minimum possible sum of areas. Rectangles must have horizontal/vertical sides, but they can touch each other.
// Approach: Brute force over all possible partitioning strategies (horizontal, vertical, L-shapes, etc.), 
// and compute the minimum rectangle area for each region using a helper function.
// Key Idea: Try every valid split of the grid into 3 disjoint parts and calculate area sum.

// Inside Code:
// - We compute possible partitions in different orientations (horizontal/vertical cuts, L-shapes, etc.).
// - For each partition, we calculate the minimal bounding rectangle area containing all 1's inside the part.
// - The helper `minimumArea` finds the smallest rectangle covering 1's in a subgrid.
// - Finally, we return the minimal sum across all partitioning strategies.

class Solution {
  public int minimumSum(int[][] grid) {
    final int m = grid.length;
    final int n = grid[0].length;
    int ans = m * n;  // Start with max possible area

    // Partition top vs (left + right) in the bottom half
    for (int i = 0; i < m; ++i) {
      final int top = minimumArea(grid, 0, i, 0, n - 1);
      for (int j = 0; j < n; ++j)
        ans = Math.min(ans, top + 
                          /*left*/ minimumArea(grid, i + 1, m - 1, 0, j) +
                          /*right*/ minimumArea(grid, i + 1, m - 1, j + 1, n - 1));
    }

    // Partition bottom vs (left + right) in the top half
    for (int i = 0; i < m; ++i) {
      final int bottom = minimumArea(grid, i, m - 1, 0, n - 1);
      for (int j = 0; j < n; ++j)
        ans = Math.min(ans, bottom + 
                          /*left*/ minimumArea(grid, 0, i - 1, 0, j) +
                          /*right*/ minimumArea(grid, 0, i - 1, j + 1, n - 1));
    }

    // Partition left vs (top + bottom) in the right half
    for (int j = 0; j < n; ++j) {
      final int left = minimumArea(grid, 0, m - 1, 0, j);
      for (int i = 0; i < m; ++i)
        ans = Math.min(ans, left + 
                          /*top*/ minimumArea(grid, 0, i, j + 1, n - 1) +
                          /*bottom*/ minimumArea(grid, i + 1, m - 1, j + 1, n - 1));
    }

    // Partition right vs (top + bottom) in the left half
    for (int j = 0; j < n; ++j) {
      final int right = minimumArea(grid, 0, m - 1, j, n - 1);
      for (int i = 0; i < m; ++i)
        ans = Math.min(ans, right + 
                          /*top*/ minimumArea(grid, 0, i, 0, j - 1) +
                          /*bottom*/ minimumArea(grid, i + 1, m - 1, 0, j - 1));
    }

    // Straight horizontal partition into 3 parts
    for (int i1 = 0; i1 < m; ++i1)
      for (int i2 = i1 + 1; i2 < m; ++i2)
        ans = Math.min(ans, 
                        /*top*/ minimumArea(grid, 0, i1, 0, n - 1) +
                        /*middle*/ minimumArea(grid, i1 + 1, i2, 0, n - 1) +
                        /*bottom*/ minimumArea(grid, i2 + 1, m - 1, 0, n - 1));

    // Straight vertical partition into 3 parts
    for (int j1 = 0; j1 < n; ++j1)
      for (int j2 = j1 + 1; j2 < n; ++j2)
        ans = Math.min(ans, 
                        /*left*/ minimumArea(grid, 0, m - 1, 0, j1) +
                        /*middle*/ minimumArea(grid, 0, m - 1, j1 + 1, j2) +
                        /*right*/ minimumArea(grid, 0, m - 1, j2 + 1, n - 1));

    return ans;
  }

  // Helper function: Finds bounding rectangle area covering all 1's in subgrid
  private int minimumArea(int[][] grid, int si, int ei, int sj, int ej) {
    int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
    int x2 = 0, y2 = 0;
    for (int i = si; i <= ei; ++i)
      for (int j = sj; j <= ej; ++j)
        if (grid[i][j] == 1) {
          x1 = Math.min(x1, i);
          y1 = Math.min(y1, j);
          x2 = Math.max(x2, i);
          y2 = Math.max(y2, j);
        }
    // If no 1 found, rectangle area = 0
    return x1 == Integer.MAX_VALUE ? 0 : (x2 - x1 + 1) * (y2 - y1 + 1);
  }
}

// Time Complexity: O(m^2 * n + n^2 * m), since we try all splits and compute areas (m, n ≤ 30 so feasible)
// Space Complexity: O(1), only a few variables used
