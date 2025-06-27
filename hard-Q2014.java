class Solution {
  public String longestSubsequenceRepeatedK(String s, int k) {
    String ans = "";
    int[] count = new int[26];
    List<Character> possibleChars = new ArrayList<>();
    Queue<String> q = new ArrayDeque<>(List.of("")); // BFS queue starting with empty string

    // Count frequency of each character
    for (final char c : s.toCharArray())
      ++count[c - 'a'];

    // Only consider characters that occur at least k times
    for (char c = 'a'; c <= 'z'; ++c)
      if (count[c - 'a'] >= k)
        possibleChars.add(c);

    // BFS to generate all possible subsequences in lexicographic order
    while (!q.isEmpty()) {
      final String currSubseq = q.poll();

      // If current subsequence * k exceeds original length, no need to continue
      if (currSubseq.length() * k > s.length())
        return ans;

      // Try appending each valid character
      for (final char c : possibleChars) {
        final String newSubseq = currSubseq + c;

        // If newSubseq * k is a valid subsequence of s
        if (isSubsequence(newSubseq, s, k)) {
          q.offer(newSubseq); // Add to queue for further extension
          ans = newSubseq;    // Update answer (lexicographically larger strings come later)
        }
      }
    }

    return ans;
  }

  // Helper function to check if (subseq * k) is a subsequence of s
  private boolean isSubsequence(final String subseq, final String s, int k) {
    int i = 0; // Pointer for subseq
    for (final char c : s.toCharArray()) {
      if (c == subseq.charAt(i)) {
        i++;
        if (i == subseq.length()) { // One full match of subseq found
          k--;                     // Need to find k such matches
          if (k == 0)
            return true;
          i = 0; // Reset to match subseq again
        }
      }
    }
    return false; // Not enough repetitions found
  }
}
