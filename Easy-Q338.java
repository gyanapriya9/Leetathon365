class Solution {
  public int[] countBits(int n) {
    // ans[i] will store the number of 1s in binary representation of i
    int[] ans = new int[n + 1];

    for (int i = 1; i <= n; ++i)
      // ⚡ f(i) = f(i / 2) + (i % 2)
      // f(i / 2): right shift by 1 (removes last bit)
      // i % 2: 1 if i is odd, else 0 (adds last bit)
      ans[i] = ans[i / 2] + (i % 2);

    return ans;
  }
}
