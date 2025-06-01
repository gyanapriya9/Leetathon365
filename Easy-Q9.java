// LeetCode 9: Palindrome Number (Level: Easy)


// 🧠 Question Explanation:
/*
A number is said to be a palindrome if it reads the same forwards and backwards.
For example: 121 → forwards it's 121, and reversed it’s still 121 → so it's a palindrome ✅
But -121 is not a palindrome because the minus sign moves to the end when reversed → becomes 121- ❌
Also, 10 is not a palindrome because reversed it becomes 01 → different from 10 ❌

Your task is to check whether the given number behaves like this mirror image or not.
*/


// 💡 Approach:
/*
We will reverse the number digit by digit.
Compare the reversed number with the original.
If they are the same → it’s a palindrome.
But we must handle negative numbers, because by rule no negative number is a palindrome (due to the - sign).
Also avoid converting to String — we’ll work entirely with digits and math.
*/


// ✅ Solution:
class Solution {
    public boolean isPalindrome(int x) {
        // Immediately rule out negative numbers
        if (x < 0) return false;

        int original = x;      // Store the original number for later comparison
        int reversed = 0;      // This will store the reversed number

        // Keep reversing until the number becomes 0
        while (x > 0) {
            int lastDigit = x % 10;                  // Get the rightmost digit
            reversed = reversed * 10 + lastDigit;    // Add digit to the reversed number
            x = x / 10;                              // Remove the digit from original
        }

        // After the loop, compare reversed number with original
        return reversed == original;
    }
}

