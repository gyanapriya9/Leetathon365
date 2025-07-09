class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ans = new ArrayList<>();

    // First Pass: Mark visited numbers by negating the value at the corresponding index.
    for (final int num : nums) {
      final int index = Math.abs(num) - 1; // Map number x to index x - 1
      nums[index] = -Math.abs(nums[index]); // Mark as visited by making it negative
    }

    // Second Pass: If value is positive, its index + 1 was never visited (missing)
    for (int i = 0; i < nums.length; ++i)
      if (nums[i] > 0)
        ans.add(i + 1); // i + 1 is missing from the array

    return ans;
  }
}
