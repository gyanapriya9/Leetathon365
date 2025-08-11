// Question: 594. Longest Harmonious Subsequence
// ------------------------------------------------------
// Flashcard Quick Notes:
// What is required? -> Find length of the longest subsequence where max - min = 1
// Approach -> Use HashMap to store frequency of each number, 
// then check for each number if (num+1) exists, and update max length.
// ------------------------------------------------------

class Solution {
  public int findLHS(int[] nums) {
    // ans -> stores the maximum length found
    int ans = 0;
    // count -> frequency map of elements
    Map<Integer, Integer> count = new HashMap<>();

    // Count frequency of each element
    for (final int num : nums)
      count.merge(num, 1, Integer::sum);

    // For each number, check if number+1 exists
    for (final int num : count.keySet())
      if (count.containsKey(num + 1))
        ans = Math.max(ans, count.get(num) + count.get(num + 1));

    return ans; // Return longest harmonious subsequence length
  }
}

// ------------------------------------------------------
// Time Complexity: O(n) -> Iterate over array + keys in map
// Space Complexity: O(n) -> Map stores frequency of each number
// ------------------------------------------------------
