// LeetCode 28: Find the Index of the First Occurrence in a String (Easy)


// 🧠 Problem Explanation:
/*
Given two strings `haystack` and `needle`, return the index of the first occurrence 
of `needle` in `haystack`. If `needle` is not part of `haystack`, return -1.
*/


// 🧪 Examples:
/*
Input:  haystack = "sadbutsad", needle = "sad"   → Output: 0
Input:  haystack = "leetcode", needle = "leeto" → Output: -1
*/


// 💡 Approach (Brute-force Sliding Window):
/*
- Loop through each index `i` from 0 to haystack.length() - needle.length()
- At each index, compare character-by-character with the `needle`
- If all characters match, return index `i`
- If no match found, return -1
*/


// ✅ Code:
class Solution {
public:
    int strStr(string haystack, string needle) {
        int m = haystack.size(), n = needle.size();
        if (n == 0) return 0;         // Edge case: empty needle
        if (n > m) return -1;         // Needle longer than haystack

        for (int i = 0; i <= m - n; ++i) {
            int j = 0;
            while (j < n && haystack[i + j] == needle[j]) {
                ++j;
            }
            if (j == n) return i;     // All characters matched
        }

        return -1;                    // No match found
    }
};
//Time Complexity:O(n)
//Space Complexity: O(1)