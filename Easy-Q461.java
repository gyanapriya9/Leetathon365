class Solution {
  public int hammingDistance(int x, int y) {
    int ans = 0;

    // Loop through each bit until both numbers become 0
    while (x > 0 || y > 0) {
      // XOR the least significant bits (LSBs) of x and y
      // (x & 1) ^ (y & 1) gives 1 if bits differ, 0 if same
      ans += (x & 1) ^ (y & 1);

      // Right shift both numbers to compare next bits
      x >>= 1;
      y >>= 1;
    }

    return ans;
  }
}
