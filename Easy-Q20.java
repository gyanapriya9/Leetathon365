// LeetCode 20: Valid Parentheses (Level: Easy)


// 🧠 Problem Explanation:
/*
Given a string containing just the characters: '(', ')', '{', '}', '[' and ']',
we need to check if the input string is valid.

A string is valid if:
1. Every opening bracket has a matching closing bracket.
2. Brackets are closed in the correct order and nesting.
*/


// 🧪 Examples:
/*
Input: "()"         → Output: true
Input: "()[]{}"     → Output: true
Input: "(]"         → Output: false
Input: "([])"       → Output: true
*/


// 💡 Approach:
/*
1. Use a stack to track opening brackets.
2. For each character in the string:
   - If it's an opening bracket, push the expected closing bracket.
   - If it's a closing bracket, check if it matches the top of the stack.
3. At the end, if the stack is empty, return true (all brackets matched properly).
*/


// ✅ Solution:
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();  // Stack to track expected closing brackets

        for (char c : s.toCharArray()) {
            // Push the expected closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If closing bracket doesn't match or stack is empty → invalid
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // If stack is empty, all brackets matched properly
        return stack.isEmpty();
    }
}
