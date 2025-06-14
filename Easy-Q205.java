// LeetCode 205. Isomorphic Strings — Easy
// Determine if two strings are isomorphic (characters map one-to-one and preserve order)

class Solution {
  public boolean isIsomorphic(String s, String t) {
    // Create two maps to track the last index of characters in s and t
    Map<Character, Integer> charToIndex_s = new HashMap<>();
    Map<Character, Integer> charToIndex_t = new HashMap<>();

    for (int i = 0; i < s.length(); ++i) {
      // Put returns previous value or null; compare both previous values
      if (charToIndex_s.put(s.charAt(i), i) != charToIndex_t.put(t.charAt(i), i))
        return false; // If mapping differs, it's not isomorphic
    }

    return true;
  }

  /*
    🧠 Flashcard-Style Summary:
    ---------------------------
    ✅ Goal: Return true if characters in string `s` can map one-to-one to string `t`.
    ✅ Rule: Each character in `s` must map to one character in `t` (no two-to-one mappings allowed).
    ✅ Strategy:
       - Use two hash maps to track last seen indices of characters from `s` and `t`.
       - If characters at same index don’t match in their mappings → return false.

    📌 Example:
    s = "egg", t = "add"
    Maps will store:
      e → 0, g → 2    AND    a → 0, d → 2
    Result: true

    ❌ Example:
    s = "foo", t = "bar"
    f → 0, o → 2    BUT    b → 0, a → 1, r → 2 → mapping conflict → false

    ⏱️ Time: O(n) | 📦 Space: O(1) — bounded by ASCII charset
  */
}
