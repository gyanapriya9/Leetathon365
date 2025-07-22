// 575. Distribute Candies
// Question: Given an array representing types of candies Alice has,
// return the maximum number of different types she can eat if she only eats n/2 of them.
// Alice wants maximum unique types within limit of n/2 candies.
//
// Approach: We use a BitSet (for space-efficient uniqueness tracking) to count the distinct candy types.
// Then we return the minimum of the number of distinct types and n/2 (which is the number she can eat).

class Solution {
  public int distributeCandies(int[] candies) {
    // BitSet of size 200001 to cover range [-100000, 100000]
    BitSet bitset = new BitSet(200001);

    // Set bit for each candy type encountered
    for (final int candy : candies)
      bitset.set(candy + 100000); // shifting index to handle negatives

    // Minimum of (number of types Alice can eat) and (actual different types present)
    return Math.min(candies.length / 2, bitset.cardinality());
  }
}

// Time Complexity: O(n) — we loop through the candies once
// Space Complexity: O(1) — BitSet size is constant (200001 bits ~ 25KB)
