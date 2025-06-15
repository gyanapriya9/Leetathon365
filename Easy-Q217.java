// LeetCode 217: Contains Duplicate — Easy

import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();

    for (int num : nums) {
      // If the number already exists in the set, it's a duplicate
      if (!seen.add(num))
        return true;
    }

    return false; // No duplicates found
  }

  /*
   🧠 Flashcard-Style Summary:
   ----------------------------
   ✅ Problem: Check if the array contains any duplicate elements.

   ✅ Strategy:
     - Use a `HashSet` to track seen numbers.
     - Try to add each number to the set:
       - If it fails (already exists), return `true`.
       - Else continue.

   ✅ Example:
     Input: [1, 2, 3, 1]
     Set operations: add 1 ✅, add 2 ✅, add 3 ✅, add 1 ❌ → duplicate found → return true

   ✅ Edge Cases:
     - Empty array → false
     - Large values (within integer range) handled by HashSet

   ⏱ Time: O(n) — one pass through array  
   📦 Space: O(n) — in worst case, all elements are unique and stored in the set
  */
}
