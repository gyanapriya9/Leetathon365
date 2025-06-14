// LeetCode 202. Happy Number — Easy
// A happy number eventually reaches 1 by repeatedly replacing the number
// with the sum of the squares of its digits. If it loops endlessly, it’s not happy.

class Solution {
  public boolean isHappy(int n) {
    // Use Floyd's Cycle Detection (slow & fast pointers)
    int slow = sumOfSquares(n);                    // move one step
    int fast = sumOfSquares(sumOfSquares(n));      // move two steps

    // If there's a cycle not involving 1, slow and fast will meet
    while (slow != fast) {
      slow = sumOfSquares(slow);
      fast = sumOfSquares(sumOfSquares(fast));
    }

    // If the number is happy, the meeting point will be 1
    return slow == 1;
  }

  // Helper function to compute sum of squares of digits of a number
  private int sumOfSquares(int n) {
    int sum = 0;
    while (n > 0) {
      int digit = n % 10;           // extract last digit
      sum += digit * digit;         // square and add
      n /= 10;                      // remove last digit
    }
    return sum;
  }

  /*
    Flashcard Style:
    ----------------
    - What is a Happy Number? A number that eventually becomes 1 by summing squares of its digits.
    - How to detect loop? Floyd’s Cycle Detection (slow/fast pointers).
    - Happy example: 19 → 82 → 68 → 100 → 1 ✅
    - Not happy example: 2 → loops → not happy ❌
  */
}
