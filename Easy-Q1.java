// LeetCode 1: Two Sum (Level: Easy)


// 🧠 Question Explanation:
/*
You're given a list of numbers (an array) and a target value.
Your goal is to find two distinct numbers in the list that, when added together, exactly match the target.
You need to return the indices (positions) of these two numbers.
Remember: 
- You can’t use the same number twice.
- There’s always exactly one solution.
Think of it like buying two items with a gift card — find two prices that add up to the total gift card value.
*/


// 💡 Approach:
/*
Instead of checking every possible pair (which is slow), we’ll use a HashMap to remember numbers we’ve already seen.
While looping:
- For each number, calculate what number would complete the sum.
- If we’ve already seen that number, we return the indices.
- If not, we store the current number with its index in the map.
This way, we can solve the problem in linear time O(n).
*/


// ✅ Solution:
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to keep track of numbers and their positions
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array once
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];                // the number we're currently looking at
            int required = target - currentNum;      // the number we need to reach the target

            // Check if the required number already exists in the map
            if (map.containsKey(required)) {
                // If yes, we found a valid pair → return their indices
                return new int[] { map.get(required), i };
            }

            // Otherwise, store this number with its index for future reference
            map.put(currentNum, i);
        }

        // Fallback return (though we are told there’s always a solution)
        return new int[] { -1, -1 };
    }
}
