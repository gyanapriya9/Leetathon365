// 2616. Minimize the Maximum Difference of Pairs
// Medium

// ✅ Problem Statement:
// You're given an array `nums` and an integer `p`.
// Form `p` pairs such that no index is used more than once and the **maximum difference** among all pairs is **minimized**.

// ✅ Example:
// Input: nums = [10,1,2,7,1,3], p = 2
// Output: 1
// Explanation:
// - Pair indices (1,4) → |1 - 1| = 0
// - Pair indices (2,5) → |2 - 3| = 1
// - Max difference among pairs = max(0, 1) = 1

// ✅ Approach:
// 1. Sort the array to make it easier to find closest pairs.
// 2. Use binary search over the range of possible maximum differences.
// 3. For each guess `m`, greedily form pairs where the adjacent difference ≤ `m`.
// 4. If you can form `p` or more pairs, search in the left half (try smaller `m`).
//    Otherwise, search right (need larger `m` to allow more pairs).

class Solution {
  public int minimizeMax(int[] nums, int p) {
    Arrays.sort(nums); // Step 1: Sort for easier adjacent pairing

    int l = 0;
    int r = nums[nums.length - 1] - nums[0]; // Max possible difference

    while (l < r) {
      final int m = (l + r) / 2;
      // Check if we can form at least p pairs with maxDiff m
      if (numPairs(nums, m) >= p)
        r = m; // Try smaller max difference
      else
        l = m + 1; // Increase maxDiff to allow more pairs
    }

    return l; // The minimum possible value of the maximum difference
  }

  // ✅ Helper: Counts how many non-overlapping pairs can be formed
  // with difference ≤ maxDiff
  private int numPairs(int[] nums, int maxDiff) {
    int pairs = 0;
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] - nums[i - 1] <= maxDiff) {
        ++pairs;
        ++i; // Skip next index since it's already used
      }
    }
    return pairs;
  }
}

// ✅ Time Complexity:
// - Sorting: O(n log n)
// - Binary Search: O(log(maxDiff)) iterations
// - Each numPairs call: O(n)
// ⇒ Total: O(n log n + n log(maxDiff))

// ✅ Space Complexity: O(1) extra space (in-place sort + no additional DS)

// 💡 Tip: Think of the problem as a greedy + binary search optimization problem.
