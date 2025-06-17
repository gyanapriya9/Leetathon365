// LeetCode 228: Summary Ranges — Easy

class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    int n = nums.length;

    if (n == 0)
      return result;

    int start = nums[0]; // Start of a potential range

    for (int i = 1; i <= n; ++i) {
      // Check if end of range or end of array
      if (i == n || nums[i] != nums[i - 1] + 1) {
        if (start == nums[i - 1])
          result.add(String.valueOf(start)); // Single number
        else
          result.add(start + "->" + nums[i - 1]); // Range
        if (i < n) start = nums[i]; // Start next range
      }
    }

    return result;
  }

  /*
   🧠 Flashcard-Style Summary:
   ----------------------------
   ✅ Problem: Summarize a sorted array of unique integers into range strings.

   ✅ Idea:
     - Track the start of each new range.
     - Iterate over array; if a break in consecutive numbers is found:
       → If start == end → it's a single number.
       → Else → it's a range "start->end".
     - Add to result and move to next range.

   ⏱ Time: O(n)
   📦 Space: O(n)

   🧾 Examples:
     Input:  [0,1,2,4,5,7]
     Output: ["0->2", "4->5", "7"]

     Input:  [0,2,3,4,6,8,9]
     Output: ["0", "2->4", "6", "8->9"]
  */
}
