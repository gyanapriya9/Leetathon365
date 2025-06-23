// LeetCode 283: Move Zeroes — Easy

class Solution {
  public void moveZeroes(int[] nums) {
    int i = 0; // Pointer to place next non-zero element

    // First pass: move all non-zero elements to the front
    for (int num : nums)
      if (num != 0)
        nums[i++] = num;

    // Second pass: fill the rest with zeroes
    while (i < nums.length)
      nums[i++] = 0;
  }
}


/*
Example:
---------
Input:  nums = [0, 1, 0, 3, 12]
Step 1: Move non-zeroes: [1, 3, 12, _, _]
Step 2: Fill rest with 0s: [1, 3, 12, 0, 0]
Output: [1, 3, 12, 0, 0]

Approach:
---------
- Traverse the array and shift non-zero numbers forward.
- Use a separate index `i` to track where the next non-zero should go.
- Once done, fill the remaining part of the array with zeros.
- This is done in-place (modifies original array).

Flashcard Summary:
------------------
Problem:
  Move all 0's to the end of the array while preserving order of non-zero elements.

Key Concepts:
  - Two-pass in-place algorithm
  - First move non-zero values forward
  - Then fill remaining positions with 0s

Time Complexity: O(n)
Space Complexity: O(1) — in-place modification

Constraints:
  1 <= nums.length <= 10^4
  -2^31 <= nums[i] <= 2^31 - 1
*/
