class Solution {
  public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
    int n = startTime.length;
    int[] gaps = getGaps(eventTime, startTime, endTime);
    int ans = 0;

    // maxLeft[i] = max gap from gaps[0..i]
    int[] maxLeft = new int[n + 1];
    // maxRight[i] = max gap from gaps[i..n]
    int[] maxRight = new int[n + 1];

    maxLeft[0] = gaps[0];
    for (int i = 1; i <= n; ++i)
      maxLeft[i] = Math.max(gaps[i], maxLeft[i - 1]);

    maxRight[n] = gaps[n];
    for (int i = n - 1; i >= 0; --i)
      maxRight[i] = Math.max(gaps[i], maxRight[i + 1]);

    // Try moving each meeting and calculate potential max free time
    for (int i = 0; i < n; ++i) {
      int meetingLen = endTime[i] - startTime[i];
      int adjacentGaps = gaps[i] + gaps[i + 1];

      boolean canMoveElsewhere =
        meetingLen <= Math.max(
          (i > 0 ? maxLeft[i - 1] : 0),
          (i + 2 <= n ? maxRight[i + 2] : 0)
        );

      int candidate = adjacentGaps + (canMoveElsewhere ? meetingLen : 0);
      ans = Math.max(ans, candidate);
    }

    return ans;
  }

  // Helper to compute gaps before/after/between meetings
  private int[] getGaps(int eventTime, int[] startTime, int[] endTime) {
    int n = startTime.length;
    int[] gaps = new int[n + 1];
    gaps[0] = startTime[0];  // before the first meeting

    for (int i = 1; i < n; ++i)
      gaps[i] = startTime[i] - endTime[i - 1];

    gaps[n] = eventTime - endTime[n - 1];  // after the last meeting
    return gaps;
  }
}
