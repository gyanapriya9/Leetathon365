# 🔢 LeetCode 125 - Valid Palindrome

"""
Problem Summary:
Check if a given string is a valid **palindrome** after:
1. Removing all non-alphanumeric characters.
2. Ignoring case sensitivity.

Palindrome = reads the same forward and backward.

Example 1:
Input:  s = "A man, a plan, a canal: Panama"
Output: True
Explanation: After cleaning → "amanaplanacanalpanama" → same forward & backward

Example 2:
Input:  s = "race a car"
Output: False
Explanation: Cleaned string → "raceacar" ≠ "racacear"

Example 3:
Input:  s = " "
Output: True
Explanation: Empty string after cleanup is considered a palindrome.

Constraints:
- 1 <= s.length <= 2 * 10^5
"""

class Solution:
  def isPalindrome(self, s: str) -> bool:
    left = 0
    right = len(s) - 1

    while left < right:
      # Skip non-alphanumeric from left
      while left < right and not s[left].isalnum():
        left += 1
      # Skip non-alphanumeric from right
      while left < right and not s[right].isalnum():
        right -= 1

      # Compare characters ignoring case
      if s[left].lower() != s[right].lower():
        return False
      
      # Move pointers inward
      left += 1
      right -= 1

    return True

"""
 Approach:
- Use two pointers (`left` and `right`) starting from both ends of the string.
- Skip non-alphanumeric characters.
- Compare characters in lowercase.
- If all matched till the center → it's a palindrome.

Time: O(n)
Space: O(1)

Flashcard Tip:
"Clean while scanning" — no need to build a new string!
Two pointers + character filtering = efficient palindrome check ✅
"""
