class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    final int n = nums.length;
    List<Integer> ans = new ArrayList<>();

    // Two pointers: i scans every index, j tracks next possible key index
    for (int i = 0, j = 0; i < n; ++i) {
      // Move j to the first index where nums[j] == key and j >= i - k
      while (j < n && (nums[j] != key || j < i - k))
        ++j;

      // If j reaches end, break (no further key elements)
      if (j == n)
        break;

      // If current i is within distance k from j (nums[j] == key), it's valid
      if (Math.abs(i - j) <= k)
        ans.add(i);
    }

    return ans;
  }
}
