class Solution { 
  public String toHex(int num) {
    if (num == 0)
      return "0"; // Edge case: 0 is "0" in hex

    // Mapping for hexadecimal characters (0–15)
    final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7',
                        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    StringBuilder sb = new StringBuilder();

    // Loop until all hex digits are processed (max 8 for 32-bit integer)
    while (num != 0) {
      // Extract last 4 bits (equivalent to % 16)
      sb.append(hex[num & 0xf]);
      // Logical shift right by 4 bits (fills with 0 even if num is negative)
      num >>>= 4;
    }

    // Reverse to get correct order (built from LSB to MSB)
    return sb.reverse().toString();
  }
}
