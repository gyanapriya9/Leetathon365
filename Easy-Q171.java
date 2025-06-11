// 171. Excel Sheet Column Number
// Easy

// ✅ Problem Statement:
// Given a string columnTitle that represents the column title as in Excel,
// return its corresponding column number.

// ✅ Examples:
// "A"   → 1
// "AB"  → 28
// "ZY"  → 701

// ✅ Approach:
// Treat the title like a base-26 number system, where:
// 'A' = 1, ..., 'Z' = 26
// For each character, multiply the accumulated value by 26 and add the character value.

class Solution { 
  public int titleToNumber(String columnTitle) {
    // Convert the string to a stream of characters
    // For each character c:
    // - Subtract '@' (i.e., 64) to convert 'A' to 1, 'B' to 2, ..., 'Z' to 26
    // - Accumulate: total = total * 26 + (c - '@')
    return columnTitle.chars().reduce(0, (subtotal, c) -> subtotal * 26 + c - '@');
  }
}

// ✅ Example Walkthrough for "AB":
// 'A' → subtotal = 0 * 26 + (65 - 64) = 1
// 'B' → subtotal = 1 * 26 + (66 - 64) = 28
// Output = 28

// ✅ Time Complexity: O(n), where n = columnTitle.length()
// ✅ Space Complexity: O(1), constant extra space

// 💡 Trick: In ASCII, 'A' = 65 → 'A' - '@' = 1 (because '@' = 64)
