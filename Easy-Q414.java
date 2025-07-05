class Solution {
  public int thirdMax(int[] nums) {
    long max1 = Long.MIN_VALUE; // First maximum
    long max2 = Long.MIN_VALUE; // Second maximum
    long max3 = Long.MIN_VALUE; // Third maximum

    for (final int num : nums) {
      //  Skip if already seen
      if (num == max1 || num == max2 || num == max3)
        continue;

      if (num > max1) { // New highest
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (num > max2) { // New second highest
        max3 = max2;
        max2 = num;
      } else if (num > max3) { // New third highest
        max3 = num;
      }
    }

    // Return third max if it exists, else return the max
    return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
  }
}
