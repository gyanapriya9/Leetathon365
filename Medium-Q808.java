// 808. Soup Servings
// ------------------------------------------------------------
// Flashcard Explanation:
// Problem: Given two soups A and B each with n mL, we randomly serve them with 4 possible serving combinations,
// and want the probability that A becomes empty first + 0.5 * probability that both become empty at the same time.
// Requirement: Calculate this probability with accuracy up to 1e-5.
// Approach: Use recursion with memoization (Dynamic Programming) to simulate all possible serving paths,
// reduce n to units of 25 mL for optimization, and stop recursion when one or both soups empty.
// Note: For n >= 4800, the probability is effectively 1.0 due to large serving size compared to n.

// Time Complexity: O((n/25)^2) due to memoization table size.
// Space Complexity: O((n/25)^2) for the memoization storage.

class Solution {
  public double soupServings(int n) {
    // If n is large enough, probability approaches 1.0
    return n >= 4800 ? 1.0 : dfs((n + 24) / 25, (n + 24) / 25);
  }

  // Memoization table to store results of subproblems
  private double[][] mem = new double[4800 / 25][4800 / 25];

  private double dfs(int a, int b) {
    // Base case: both empty
    if (a <= 0 && b <= 0)
      return 0.5;
    // Base case: only A empty
    if (a <= 0)
      return 1.0;
    // Base case: only B empty
    if (b <= 0)
      return 0.0;
    // If result already computed
    if (mem[a][b] > 0)
      return mem[a][b];

    // Recursively compute probability with each serving operation
    return mem[a][b] =
      0.25 * (
        dfs(a - 4, b) +         // Serve 100mL from A, 0 from B
        dfs(a - 3, b - 1) +     // Serve 75mL from A, 25 from B
        dfs(a - 2, b - 2) +     // Serve 50mL from A, 50 from B
        dfs(a - 1, b - 3)       // Serve 25mL from A, 75 from B
      );
  }
}
