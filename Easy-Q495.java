class Solution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    // If duration is 0, no poisoning effect
    if (duration == 0)
      return 0;

    int ans = 0;

    // Loop through each attack except the last one
    for (int i = 0; i + 1 < timeSeries.length; ++i) {
      // If the next attack happens after the poison from the current attack ends,
      // then add full duration. Otherwise, add only the non-overlapping portion.
      ans += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
    }

    // Add duration for the last attack, since it always contributes fully
    return ans + duration;
  }
}
