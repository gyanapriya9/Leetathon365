// 551. Student Attendance Record I
// -------------------------------------------------------------
// Problem Summary (Flashcard format):
// Check if a student qualifies for an attendance award based on:
// 1. Less than 2 'A' (Absent) entries.
// 2. No 3 or more consecutive 'L' (Late) entries.

// Approach Used:
// We check:
// - If there's at most one 'A' by comparing first and last index of 'A'.
// - If the string doesn't contain "LLL" (which means 3 consecutive 'L').

// If both conditions are satisfied, return true; else, return false.

class Solution {
  public boolean checkRecord(String s) {
    // Check if 'A' occurs only once or not at all
    boolean atMostOneAbsent = s.indexOf("A") == s.lastIndexOf("A");

    // Check for absence of "LLL" (i.e., no 3 consecutive late days)
    boolean noThreeConsecutiveLate = !s.contains("LLL");

    // Return true only if both conditions are met
    return atMostOneAbsent && noThreeConsecutiveLate;
  }
}

// Time Complexity: O(n) - scanning the string a few times
// Space Complexity: O(1) - no extra space used
