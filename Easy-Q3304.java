class Solution {
  public char kthCharacter(int k) {
    // The k-th character depends on how many times the character at index k-1
    // has been transformed (i.e., how many 1s are there in binary representation of k-1)
    // Because for each operation, the "next character" is added and appended.
    
    return (char) ('a' + Integer.bitCount(k - 1));  
    // 'a' + number of 1s in binary representation of (k - 1)
    // Gives the final character after all transformations
  }
}
