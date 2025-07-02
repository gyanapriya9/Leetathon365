class Solution {
  public int possibleStringCount(String word, int k) {
    // Step 1: Get lengths of consecutive identical character groups
    List<Integer> groups = getConsecutiveLetters(word);

    // Step 2: Compute total combinations using group sizes
    // If a group has size 3 (e.g., "aaa"), you can remove 0, 1, or 2 characters (3 possibilities)
    // So, multiply group sizes to get total combinations
    final int totalCombinations =
        (int) groups.stream().mapToLong(Integer::longValue).reduce(1L, (a, b) -> a * b % MOD);

    // Step 3: If k ≤ number of groups, then all strings formed are valid
    if (k <= groups.size())
      return totalCombinations;

    // Step 4: DP to count number of combinations with length < k (invalid ones)
    // dp[j] := number of ways to build a string of length j using first i groups
    int[] dp = new int[k];
    dp[0] = 1; // Base case: one way to form empty string

    // Step 5: Traverse each group and apply sliding window DP
    for (int i = 0; i < groups.size(); ++i) {
      int[] newDp = new int[k];
      int windowSum = 0;
      int group = groups.get(i);
      for (int j = i; j < k; ++j) {
        newDp[j] = (newDp[j] + windowSum) % MOD;
        windowSum = (windowSum + dp[j]) % MOD;
        if (j >= group)
          windowSum = (windowSum - dp[j - group] + MOD) % MOD; // Remove left of window
      }
      dp = newDp;
    }

    // Step 6: Calculate invalid combinations of length < k
    final int invalidCombinations = Arrays.stream(dp).reduce(0, (a, b) -> (a + b) % MOD);

    // Step 7: Subtract invalid ones from total
    return (totalCombinations - invalidCombinations + MOD) % MOD;
  }

  private static final int MOD = 1_000_000_007;

  // Utility to group consecutive identical characters
  // E.g. "aaabbc" -> [3, 2, 1]
  private List<Integer> getConsecutiveLetters(final String word) {
    List<Integer> groups = new ArrayList<>();
    int group = 1;
    for (int i = 1; i < word.length(); ++i)
      if (word.charAt(i) == word.charAt(i - 1)) {
        ++group;
      } else {
        groups.add(group);
        group = 1;
      }
    groups.add(group);
    return groups;
  }
}
