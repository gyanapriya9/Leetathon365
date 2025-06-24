class Solution:
  def isPowerOfThree(self, n: int) -> bool:
    # Only positive numbers can be a power of 3
    # 3^19 = 1162261467 is the largest power of 3 within 32-bit signed int
    # If n divides 3^19, then it must be a power of 3 (since all factors of 3^19 are powers of 3)
    return n > 0 and 1162261467 % n == 0
