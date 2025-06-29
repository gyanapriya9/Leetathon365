class Solution {
  public int numSubseq(int[] nums, int target) {
    final int MOD = 1_000_000_007;  // Modulo to avoid overflow
    final int n = nums.length;
    int ans = 0;

    // Step 1: Precompute powers of 2 (since each range [l, r] can form 2^(r - l) subsequences)
    int[] pows = new int[n]; // pows[i] = 2^i % MOD
    pows[0] = 1;
    for (int i = 1; i < n; ++i)
      pows[i] = pows[i - 1] * 2 % MOD;

    // Step 2: Sort to allow two-pointer traversal (min is nums[l], max is nums[r])
    Arrays.sort(nums);

    // Step 3: Use two pointers to find valid subsequences
    for (int l = 0, r = n - 1; l <= r;) {
      // If the smallest + largest <= target, all subsets between l and r are valid
      if (nums[l] + nums[r] <= target) {
        ans += pows[r - l]; // Add number of valid subsequences
        ans %= MOD;
        ++l; // Move left to check next min
      } else {
        --r; // If sum too big, reduce the max
      }
    }

    return ans; //  Final result
  }
}
