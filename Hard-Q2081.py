# LeetCode 2081: Sum of k-Mirror Numbers — Hard

class Solution:
    def kMirror(self, k: int, n: int) -> int:
        ans = 0
        A = ['0']  # Start with the "0" as a base case (will become 1, 2, 3...)

        def nextKMirror(A: list[str]) -> list[str]:
            # Generate next base-k palindrome string
            for i in range(len(A) // 2, len(A)):
                nextDigit = int(A[i]) + 1
                if nextDigit < k:
                    A[i] = str(nextDigit)
                    A[~i] = str(nextDigit)  # Mirror the change
                    for j in range(len(A) // 2, i):
                        A[j] = '0'
                        A[~j] = '0'
                    return A
            # If all digits were maxed out, create next-length palindrome
            return ['1'] + ['0'] * (len(A) - 1) + ['1']

        for _ in range(n):
            while True:
                A = nextKMirror(A)
                num = int(''.join(A), k)  # Convert from base-k to base-10
                if str(num) == str(num)[::-1]:  # Check if base-10 is palindrome
                    break
            ans += num

        return ans


"""
Example:
---------
Input: k = 2, n = 5
Output: 25
Explanation:
  The first 5 numbers that are palindromes in both base-10 and base-2:
  base-10: 1, 3, 5, 7, 9
  base-2:  1, 11, 101, 111, 1001
  Sum = 1 + 3 + 5 + 7 + 9 = 25

Approach:
---------
- Construct k-mirror numbers in base-k as palindromes by incrementing digits.
- Convert them to base-10.
- Keep only those whose base-10 representation is also a palindrome.
- Repeat until we find n such numbers and sum them.

Flashcard Summary:
------------------
Problem:
  Find n numbers that are palindromes in both base-10 and base-k.
Key Ideas:
  - Generate base-k palindromes lexicographically.
  - Check if base-10 value is also a palindrome.
  - Use digit mirroring to control palindrome structure.
Time Complexity:
  - Roughly O(n * d), where d is digits processed (since search is restricted).
Constraints:
