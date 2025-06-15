// LeetCode 219: Contains Duplicate II — Easy

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>(); // num → last seen index

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
        return true; // Duplicate found within k distance

      map.put(nums[i], i); // Update last seen index
    }

    return false; // No valid duplicates found
  }

  /*
   🧠 Flashcard-Style Summary:
   ----------------------------
   ✅ Problem: Find if there are any two equal elements with indices at most k apart.

   ✅ Strategy:
     - Use a HashMap to store the last index of each number.
     - For every new element:
       - If it's already in the map, check distance.
       - If distance ≤ k → return true.
       - Otherwise, update the index in map.

   ✅ Example:
     Input: nums = [1,0,1,1], k = 1
     → At i=2 and i=3, nums[i]=1 found again within distance 1 → return true

   ✅ Edge Cases:
     - k = 0 → can't have any valid duplicates
     - All unique elements → returns false

   ⏱ Time: O(n) — one pass through array  
   📦 Space: O(n) — for storing element indices
  */
}
