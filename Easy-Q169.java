// 169. Majority Element
// Easy

// ✅ Problem Statement:
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You can assume the majority element always exists in the array.

// ✅ Examples:
// Input: [3,2,3]        → Output: 3
// Input: [2,2,1,1,1,2,2] → Output: 2

// ✅ Follow-up:
// Can you solve this in linear time and O(1) space?

// ✅ Approach:
// This is the **Boyer-Moore Voting Algorithm**
// - Initialize count = 0 and candidate = None
// - For each number:
//     - If count is 0, set candidate to current number
//     - If number == candidate, increment count
//     - Else, decrement count
// The majority element will be the candidate in the end.

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}

// ✅ Time Complexity: O(n) – One pass through the array
// ✅ Space Complexity: O(1) – Constant space used

// 💡 Why it works:
// Because the majority element appears more than n/2 times,
// it will always survive the cancellation process and remain as the candidate.
