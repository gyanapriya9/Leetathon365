// 168. Excel Sheet Column Title
// Easy

// ✅ Problem Statement:
// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
//
// Excel columns follow this pattern:
// A -> 1, B -> 2, ..., Z -> 26, AA -> 27, AB -> 28, ..., ZY -> 701, etc.

// ✅ Example:
// Input: 1    → Output: "A"
// Input: 28   → Output: "AB"
// Input: 701  → Output: "ZY"

// ✅ Approach:
// This is similar to converting a number to base-26, but since Excel columns are 1-indexed (not 0),
// we subtract 1 before taking the modulo. That’s why we do (n - 1) % 26 instead of n % 26.
// We build the result recursively by finding the previous characters and appending the current one.

class Solution {
    public String convertToTitle(int n) {
        // Base case: if n is 0, return an empty string
        if (n == 0)
            return "";

        // Recursively call for the previous part
        String previous = convertToTitle((n - 1) / 26);

        // Find the current character (1 -> A, 2 -> B, ..., 26 -> Z)
        char currentChar = (char) ('A' + (n - 1) % 26);

        // Append current character to the result
        return previous + currentChar;
    }
}

// ✅ Time Complexity: O(logₙ), since we're reducing the number by a factor of 26 each time
// ✅ Space Complexity: O(logₙ), due to recursive call stack and result string building

// 💡 Tip:
// Think of it like converting to base-26 but shifting the range from [0–25] to [1–26]
// by adjusting with (n - 1)
