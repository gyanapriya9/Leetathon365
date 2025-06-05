// LeetCode 1061: Lexicographically Smallest Equivalent String

// 🧠 Problem:
/*
You are given two strings `s1` and `s2` of equal length, and a string `baseStr`.

Characters s1[i] and s2[i] are considered equivalent.

Return the lexicographically smallest equivalent string of baseStr 
using the equivalency information from s1 and s2.
*/


// 🧪 Examples:
/*
Input:  s1 = "parker", s2 = "morris", baseStr = "parser"
Output: "makkek"

Input:  s1 = "hello", s2 = "world", baseStr = "hold"
Output: "hdld"

Input:  s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
Output: "aauaaaaada"
*/


// 💡 Approach (Union-Find / Disjoint Set):
/*
- Build equivalency groups using union-find (Disjoint Set Union)
- Always attach the lexicographically larger character to the smaller one
- For each character in baseStr, replace with the smallest equivalent character
*/


// ✅ Java Code:
class UnionFind {
  private int[] parent;

  public UnionFind(int n) {
    parent = new int[n];
    for (int i = 0; i < n; ++i)
      parent[i] = i;
  }

  // Find with path compression
  public int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);
    return parent[x];
  }

  // Union by smallest lexicographic value
  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX == rootY) return;
    if (rootX < rootY)
      parent[rootY] = rootX;
    else
      parent[rootX] = rootY;
  }

  public int getSmallest(int x) {
    return find(x);
  }
}

class Solution {
  public String smallestEquivalentString(String s1, String s2, String baseStr) {
    UnionFind uf = new UnionFind(26); // Only 26 lowercase English letters

    // Step 1: Union equivalent characters
    for (int i = 0; i < s1.length(); ++i) {
      uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
    }

    // Step 2: Build result using smallest equivalent characters
    StringBuilder sb = new StringBuilder();
    for (char c : baseStr.toCharArray()) {
      int smallest = uf.getSmallest(c - 'a');
      sb.append((char)(smallest + 'a'));
    }

    return sb.toString();
  }
}


// ⏱ Time Complexity: O(n + m + k*α(26))
// - n = length of s1/s2
// - m = length of baseStr
// - α is the inverse Ackermann function (very slow-growing), nearly constant

// 🧠 Space Complexity: O(1)
// - Uses fixed-size array of 26 for union-find (since only lowercase letters are involved)
