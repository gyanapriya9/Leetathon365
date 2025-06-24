class Solution {
  public boolean isPowerOfFour(int n) {
    // Check 1: n must be positive
    // Check 2: Only one bit must be set (i.e., power of 2)
    // Check 3: That bit must be in the correct (even) position for power of 4
    // For example, powers of 4 in binary:
    // 1 -> 0001, 4 -> 0100, 16 -> 0001 0000, etc.

    // 0x55555555 is a binary mask: 0101... pattern (only allows bits at even positions)
    return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
  }
}
