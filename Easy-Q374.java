public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int l = 1;     // left bound of binary search
    int r = n;     // right bound of binary search

    // Binary search loop to find the number
    while (l < r) {
      int m = l + (r - l) / 2; // avoid integer overflow

      // guess(m) returns:
      // -1 → m is too high
      //  1 → m is too low
      //  0 → m is correct
      if (guess(m) <= 0) // if m is correct or too high
        r = m;           // narrow search to left half including m
      else
        l = m + 1;       // m is too low, search right half excluding m
    }

    // When loop exits, l == r == picked number
    return l;
  }
}
