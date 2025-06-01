// LeetCode 14: Longest Common Prefix (Level: Easy)


// 🧠 Question Explanation:
/*
We are given an array of strings, and we need to find the longest string prefix 
that is common to all strings in the array.

Example:
- ["flower", "flow", "flight"] → Common prefix is "fl"
- ["dog", "racecar", "car"] → No common prefix → Return ""

If no such prefix exists, return an empty string.
*/


// 💡 Approach:
/*
1. First, check if the array is empty. If yes, return "".
2. Use the first string in the array as a reference.
3. Loop through each character index of the first string:
   - For every other string in the array:
     - If the current index exceeds the length of that string, or
       the character doesn't match the one in the reference string → return the common part found so far.
4. If loop finishes completely, it means the entire first string is a common prefix.
*/


// ✅ Solution:
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";  // Return empty if input is empty
        }

        // Loop through each character of the first word
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);  // Take i-th char from the first string

            // Compare with i-th char of all other strings
            for (int j = 1; j < strs.length; j++) {
                // If i is out of bounds OR mismatch occurs, return substring till i
                if (i == strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return strs[0].substring(0, i);
                }
            }
        }

        // If no mismatch found, return the entire first word
        return strs[0];
    }
}

