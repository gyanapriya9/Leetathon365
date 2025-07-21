// 1957. Delete Characters to Make Fancy String

/*
Flashcard:
Problem: Given a string `s`, remove the minimum number of characters so that no three consecutive characters are the same.
Return the final valid string.

Approach:
- Use a StringBuilder to construct the result.
- Traverse the string character by character.
- For each character, check if the last two characters in the result are the same as the current one.
- If they are not, append the current character to the result.
- This ensures that no three consecutive characters will ever be equal.
*/

class Solution {
  public String makeFancyString(String s) {
    StringBuilder sb = new StringBuilder(); // To build the final string without three consecutive equal characters

    for (char c : s.toCharArray()) {
      // If there are less than 2 characters in result OR current character is not same as last two
      if (sb.length() < 2 || 
          sb.charAt(sb.length() - 1) != c || 
          sb.charAt(sb.length() - 2) != c) {
        sb.append(c); // Append the character as it does not form three equal consecutive characters
      }
      // else: do not append current character to skip forming three consecutive same characters
    }

    return sb.toString(); // Return the modified string
  }
}

/*
Time Complexity: O(n), where n is the length of the input string
Space Complexity: O(n), for the StringBuilder used to build the result
*/
