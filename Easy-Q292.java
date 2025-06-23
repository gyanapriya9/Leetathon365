// LeetCode 292: Nim Game — Easy

class Solution {
  public boolean canWinNim(int n) {
    return n % 4 != 0; // You win unless n is divisible by 4
  }
}


/*
Concept:
-----------
- This is a classic **mathematical game theory** problem.
- If both players play optimally:
  You can win if `n % 4 != 0`
  You lose if `n % 4 == 0`

Why?
----
- If n is divisible by 4, no matter what you pick (1, 2, or 3), the other player can always bring the total picked to 4 each round.
  Example: You pick 1 → opponent picks 3. You pick 2 → opponent picks 2, etc.
- Eventually, you’re forced to take the last stone — and **lose**.

Example 1:
Input: n = 4
Output: false
Reason: Any move you make leaves your friend in a winning position.

Example 2:
Input: n = 1
Output: true
You take the only stone and win.

Example 3:
Input: n = 2
Output: true
You take 1, opponent is forced to take the last stone.

Flashcard Summary:
---------------------
Problem: Win Nim Game if both play optimally
Insight: Lose only when n % 4 == 0

Time Complexity: O(1)
Space Complexity: O(1)

Constraints:
---------------
- 1 <= n <= 2³¹ - 1
*/
