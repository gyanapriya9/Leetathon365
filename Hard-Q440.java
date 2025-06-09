// 136. Single Number
// Easy

// Problem:
// Given a non-empty array of integers nums,
// every element appears twice except for one. Find that single one.

// You must implement a solution with:
// - Linear runtime complexity O(n)
// - Constant extra space O(1)

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

// Example 2:
// Input: nums = [4,1,2,1,2]
// Output: 4

// Example 3:
// Input: nums = [1]
// Output: 1

// Constraints:
// 1 <= nums.length <= 3 * 10^4
// -3 * 10^4 <= nums[i] <= 3 * 10^4

class Solution {
  public int singleNumber(int[] nums) {
    int ans = 0;

    // XOR-ing all elements
    // Same numbers cancel each other: a ^ a = 0
    // 0 ^ b = b — so remaining will be the single number
    for (final int num : nums)
      ans ^= num;

    return ans;
  }
}
