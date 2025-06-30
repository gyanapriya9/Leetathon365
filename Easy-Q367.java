class Solution {
  public boolean isPerfectSquare(int num) {
    long l = 1;           // Start of binary search range
    long r = num;         // End of binary search range

    // Binary search to find if any number * itself == num
    while (l < r) {
      long m = (l + r) / 2; // Midpoint

      // If m is too big (m * m >= num), we might have found the square or need to go left
      if (m >= num / m)
        r = m;
      else
        l = m + 1;          // If m * m < num, move right
    }

    // After loop, check if l * l is exactly equal to num
    return l * l == num;
  }
}
