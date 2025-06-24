class Solution {
  public void reverseString(char[] s) {
    int l = 0;                   // Left pointer starts at beginning of array
    int r = s.length - 1;       // Right pointer starts at end of array

    // Keep swapping characters from both ends until pointers meet
    while (l < r) {
      char temp = s[l];         // Store left character in temp
      s[l++] = s[r];            // Move right character to left, then increment left pointer
      s[r--] = temp;            // Move temp (original left) to right, then decrement right pointer
    }
    // Reversal is done in-place with O(1) space
  }
}
