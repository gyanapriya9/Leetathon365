// 506. Relative Ranks
// Given a list of scores, assign ranks to athletes:
// - "Gold Medal" for highest score
// - "Silver Medal" for 2nd highest
// - "Bronze Medal" for 3rd highest
// - Rank number as string for the rest

// Approach:
// - Store original indices to keep track after sorting.
// - Sort the indices based on descending score values.
// - Assign ranks using sorted order and update result array at original indices.

class Solution {
  public String[] findRelativeRanks(int[] nums) {
    final int n = nums.length;
    String[] ans = new String[n];
    List<Integer> indices = new ArrayList<>();

    // Store all indices to sort based on corresponding scores
    for (int i = 0; i < n; ++i)
      indices.add(i);

    // Sort indices based on descending scores
    Collections.sort(indices, Comparator.comparingInt(a -> -nums[a]));

    // Assign medals/ranks based on sorted positions
    for (int i = 0; i < n; ++i)
      if (i == 0)
        ans[indices.get(0)] = "Gold Medal"; // Highest score
