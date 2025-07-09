class Solution {
  public int findContentChildren(int[] g, int[] s) {
    // Sort both arrays to apply the greedy strategy
    Arrays.sort(g); // Sort greed factors (children)
    Arrays.sort(s); // Sort cookie sizes

    int i = 0; // Pointer for children
    int j = 0; // Pointer for cookies

    // Try to satisfy each child with the smallest available cookie that fits
    while (i < g.length && j < s.length) {
      if (s[j] >= g[i]) {
        // Cookie s[j] satisfies child g[i]
        i++; // Move to next child
      }
      j++; // Move to next cookie regardless of whether it was used
    }

    // 'i' will be the number of content children
    return i;
  }
}
