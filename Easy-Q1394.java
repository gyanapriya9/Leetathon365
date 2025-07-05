class Solution {
  public int findLucky(int[] arr) {
    // Step 1: Create a frequency counter
    int[] count = new int[arr.length + 1]; // Only need up to arr.length, since lucky number must be <= its freq

    // Step 2: Count frequencies (only consider numbers <= arr.length)
    for (final int a : arr)
      if (a <= arr.length)
        ++count[a];

    // Step 3: Check from largest to smallest if count[i] == i
    for (int i = arr.length; i >= 1; --i)
      if (count[i] == i) // A lucky integer is found
        return i;

    return -1; // No lucky integer found
  }
}
