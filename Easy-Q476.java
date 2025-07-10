class Solution {
  public int findComplement(int num) {
    for (long i = 1; i <= num; i <<= 1)  // Iterate over all bit positions set in `num`
      num ^= i;  // ⛏ Flip the current bit using XOR
    return num;
  }
}
