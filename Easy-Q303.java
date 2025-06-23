// LeetCode 303: Range Sum Query - Immutable — Easy

class NumArray {
  private int[] prefix;

  public NumArray(int[] nums) {
    // Build prefix sum array where prefix[i] is the sum of first i elements
    prefix = new int[nums.length + 1];
    for (int i = 0; i < nums.length; ++i)
      prefix[i + 1] = nums[i] + prefix[i];
  }

  public int sumRange(int left, int right) {
    // Use the prefix sum difference to get the range sum
    return prefix[right + 1] - prefix[left];
  }
}


/*
Concept:
-----------
Prefix Sum Array Technique:
- Precompute cumulative sums: prefix[i] stores the sum of nums[0] to nums[i - 1]
- Query range sum in O(1) time using:
    sumRange(left, right) = prefix[right + 1] - prefix[left]

Example:
------------
Input: nums = [-2, 0, 3, -5, 2, -1]
Initialization builds:
prefix = [0, -2, -2, 1, -4, -2, -3]

sumRange(0, 2) = prefix[3] - prefix[0] = 1 - 0 = 1
sumRange(2, 5) = prefix[6] - prefix[2] = -3 - (-2) = -1
sumRange(0, 5) = prefix[6] - prefix[0] = -3 - 0 = -3

Flashcard Summary:
---------------------
Problem: Efficient sum queries on fixed array
Technique: Prefix sum
Query Time: O(1), Space: O(n), Preprocessing: O(n)

Constraints:
---------------
- 1 <= nums.length <= 10⁴
- -10⁵ <= nums[i] <= 10⁵
- At most 10⁴ queries

*/
