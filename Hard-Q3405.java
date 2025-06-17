// LeetCode 3405: Count the Number of Arrays with K Matching Adjacent Elements — Hard

class Solution {
  private static final int MOD = 1_000_000_007;

  public int countGoodArrays(int n, int m, int k) {
    long[][] factAndInvFact = getFactAndInvFact(n);
    long[] fact = factAndInvFact[0];
    long[] invFact = factAndInvFact[1];

    // Idea:
    // Choose `k` positions where adjacent elements are equal → C(n - 1, k)
    // Fill the remaining (n - k) positions ensuring adjacent are NOT equal:
    //   - First position: m choices
    //   - Rest (n - k - 1) positions: m - 1 choices each (must differ from prev)
    // Result = m * (m - 1)^(n - k - 1) * C(n - 1, k)

    long ways = m * modPow(m - 1, n - k - 1) % MOD;
    ways = ways * nCk(n - 1, k, fact, invFact) % MOD;
    return (int) ways;
  }

  // Fast exponentiation: (base^exp) % MOD
  private long modPow(long base, int exp) {
    long result = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) result = result * base % MOD;
      base = base * base % MOD;
      exp >>= 1;
    }
    return result;
  }

  // Precompute factorials and inverse factorials up to n
  private long[][] getFactAndInvFact(int n) {
    long[] fact = new long[n + 1];
    long[] invFact = new long[n + 1];
    long[] inv = new long[n + 1];
    fact[0] = invFact[0] = inv[1] = 1;

    for (int i = 1; i <= n; ++i) {
      fact[i] = fact[i - 1] * i % MOD;
      if (i >= 2) inv[i] = MOD - MOD / i * inv[MOD % i] % MOD;
      invFact[i] = invFact[i - 1] * inv[i] % MOD;
    }
    return new long[][] {fact, invFact};
  }

  // Compute C(n, k) % MOD using precomputed factorials
  private int nCk(int n, int k, long[] fact, long[] invFact) {
    if (k < 0 || k > n) return 0;
    return (int) (fact[n] * invFact[k] % MOD * invFact[n - k] % MOD);
  }

  /*
   Flashcard-Style Summary:
   ----------------------------
   Problem: Count arrays of length `n` using [1..m] such that **exactly `k` adjacent equal pairs** exist.

   Strategy:
     - Choose `k` positions out of `n - 1` where arr[i] == arr[i-1] → C(n-1, k)
     - First element: m choices
     - For non-equal transitions: (m - 1) choices each
     - Total = m * (m - 1)^(n - k - 1) * C(n - 1, k)

   Edge Case:
     - k = 0: all elements must differ from previous → only alternate choices

   ⏱ Time: O(n + log n)  
   📦 Space: O(n) — for factorials
  */
}
