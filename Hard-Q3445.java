// 3445. Maximum Difference Between Even and Odd Frequency II
// Hard

// Strategy:
// Try all possible pairs of characters (a, b) where a != b
// Maintain prefix sums for both characters
// Track min (prefixA - prefixB) for valid prefix parities
// Ensure substrings have size >= k and a appears odd times, b appears even times

class Solution {
  public int maxDifference(String s, int k) {
    int ans = Integer.MIN_VALUE;

    // Try every combination of characters 'a' and 'b' (excluding when a == b)
    for (Pair<Character, Character> pair : getPermutations()) {
      final char a = pair.getKey();
      final char b = pair.getValue();

      int[][] minDiff = new int[2][2];
      Arrays.stream(minDiff).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE / 2));

      List<Integer> prefixA = new ArrayList<>(List.of(0));
      List<Integer> prefixB = new ArrayList<>(List.of(0));

      for (int l = 0, r = 0; r < s.length(); ++r) {
        prefixA.add(prefixA.get(prefixA.size() - 1) + (s.charAt(r) == a ? 1 : 0));
        prefixB.add(prefixB.get(prefixB.size() - 1) + (s.charAt(r) == b ? 1 : 0));

        // Maintain window of size >= k
        while (r - l + 1 >= k &&
               prefixA.get(l) < prefixA.get(prefixA.size() - 1) &&
               prefixB.get(l) < prefixB.get(prefixB.size() - 1)) {
          int parityA = prefixA.get(l) % 2;
          int parityB = prefixB.get(l) % 2;
          minDiff[parityA][parityB] = Math.min(
              minDiff[parityA][parityB], 
              prefixA.get(l) - prefixB.get(l)
          );
          ++l;
        }

        // Compute result based on current prefix difference
        int currA = prefixA.get(prefixA.size() - 1);
        int currB = prefixB.get(prefixB.size() - 1);
        int parityA = 1 - (currA % 2); // we want currA to be odd => look at even prefix
        int parityB = currB % 2;      // we want currB to be even
        ans = Math.max(ans, (currA - currB) - minDiff[parityA][parityB]);
      }
    }

    return ans;
  }

  // Generate all character pairs (a, b) from '0' to '4' where a != b
  private List<Pair<Character, Character>> getPermutations() {
    List<Pair<Character, Character>> permutations = new ArrayList<>();
    for (char a : "01234".toCharArray()) {
      for (char b : "01234".toCharArray()) {
        if (a != b) {
          permutations.add(new Pair<>(a, b));
        }
      }
    }
    return permutations;
  }
}
