// 496. Next Greater Element I
// Question:
// Given two arrays nums1 and nums2 where nums1 is a subset of nums2,
// find the next greater element for each element in nums1 based on its position in nums2.
// The next greater element of an element x in nums2 is the first greater element to the right of x in nums2.
// If no such element exists, return -1 for that entry.

// Approach:
// - Use a decreasing monotonic stack while traversing nums2 to track the next greater element for each number.
// - Store the mapping of each number to its next greater value in a hashmap.
// - Iterate through nums1 and fetch the next greater values from the hashmap (or -1 if not present).

class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> numToNextGreater = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>(); // Stack to maintain decreasing elements

    // Traverse nums2 and fill the map with the next greater element for each number
    for (final int num : nums2) {
      // While current number is greater than top of stack, it is the next greater for the top element
      while (!stack.isEmpty() && stack.peek() < num)
        numToNextGreater.put(stack.pop(), num);
      // Push current number onto the stack
      stack.push(num);
    }

    // For each number in nums1, get its next greater from the map or return -1
    for (final int num : nums1)
      ans.add(numToNextGreater.getOrDefault(num, -1));

    // Convert list to array and return
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }
}

// Time Complexity: O(m + n), where m = nums1.length, n = nums2.length
// Space Complexity: O(n) for hashmap and stack (used to store nums2 elements and their next greater mapping)
