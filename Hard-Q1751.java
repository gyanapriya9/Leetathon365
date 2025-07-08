class Solution {
  public int maxValue(int[][] events, int k) {
    // DP memoization table: mem[i][k] = max value starting from i-th event with k slots left
    Integer[][] mem = new Integer[events.length][k + 1];

    // Sort events by start day, then by end day for deterministic order
    Arrays.sort(events, Comparator.comparingInt((int[] event) -> event[0])
                            .thenComparing((int[] event) -> event[1]));

    return maxValue(events, 0, k, mem);
  }

  private int maxValue(int[][] events, int i, int k, Integer[][] mem) {
    // Base cases: no more events or no more selections allowed
    if (k == 0 || i == events.length)
      return 0;

    // Return cached result if already computed
    if (mem[i][k] != null)
      return mem[i][k];

    // Choice 1: Attend current event
    // Find next index j where event starts after current event ends
    int j = firstGreaterEqual(events, i + 1, events[i][1] + 1);
    int take = events[i][2] + maxValue(events, j, k - 1, mem);

    // Choice 2: Skip current event
    int skip = maxValue(events, i + 1, k, mem);

    // Store max of both choices
    return mem[i][k] = Math.max(take, skip);
  }

  // Binary search to find first index l such that events[l][0] >= target
  private int firstGreaterEqual(int[][] events, int l, int target) {
    int r = events.length;
    while (l < r) {
      int m = (l + r) / 2;
      if (events[m][0] >= target)
        r = m;
      else
        l = m + 1;
    }
    return l;
  }
}
