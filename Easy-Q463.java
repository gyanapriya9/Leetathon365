class Solution { 
  public int islandPerimeter(int[][] grid) {
    int islands = 0;     // Count of land cells
    int neighbors = 0;   // Count of shared edges between adjacent land cells

    for (int i = 0; i < grid.length; ++i)
      for (int j = 0; j < grid[0].length; ++j)
        if (grid[i][j] == 1) {
          ++islands;  // Count the land cell

          // Check the land cell above
          if (i - 1 >= 0 && grid[i - 1][j] == 1)
            ++neighbors;

          // Check the land cell to the left
          if (j - 1 >= 0 && grid[i][j - 1] == 1)
            ++neighbors;
        }

    // Each land contributes 4 sides, but each shared edge removes 2 sides (one for each cell)
    return islands * 4 - neighbors * 2;
  }
}
