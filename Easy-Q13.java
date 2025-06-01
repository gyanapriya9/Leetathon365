// LeetCode 13: Roman to Integer (Level: Easy)


// 🧠 Question Explanation:
/*
In Roman numerals, certain characters represent specific values:
I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000

Usually, these are written from largest to smallest, left to right.
But in some cases, a smaller value appears before a larger one — this means we need to subtract instead of add.
Examples:
- IV = 4 (5 - 1)
- IX = 9 (10 - 1)
- MCMXCIV = 1000 + 900 + 90 + 4 = 1994

So the task is to convert a string like "MCMXCIV" into its integer form.
*/


// 💡 Approach:
/*
1. First, map each Roman character to its corresponding integer value.
2. Traverse the input string from left to right.
3. For each character, compare its value with the value of the next character.
   → If the current one is smaller, subtract it.
   → Otherwise, add it.
4. At the end, add the value of the last character, since the loop skips it.
*/


// ✅ Solution:
class Solution {
    public int romanToInt(String s) {
        int result = 0;                     // This will store our final number
        int[] map = new int[128];          // To map Roman characters using ASCII indexing

        // Assigning Roman numeral values
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;

        // Loop through the string except the last character
        for (int i = 0; i < s.length() - 1; i++) {
            int current = map[s.charAt(i)];
            int next = map[s.charAt(i + 1)];

            if (current < next) {
                result -= current;   // Subtract if current symbol is smaller than the next one
            } else {
                result += current;   // Else, simply add the current symbol value
            }
        }

        // Finally, add the value of the last character
        result += map[s.charAt(s.length() - 1)];

        return result;
    }
}
