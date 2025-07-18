// 2163. Minimum Difference in Sums After Removal of Elements
// -------------------------------------------------------------
// ❖ Problem Summary (Flashcard format):
// Given an array of 3n elements, remove n elements so that the remaining
// 2n elements can be split into two equal halves. Goal is to minimize:
//    (sum of first half) - (sum of second half)

// ❖ Approach Used:
// - Use a max heap to track the smallest possible sum of n elements from the left 2n portion
// - Use a min heap to track the largest possible sum of n elements from the right 2n portion
// - Precompute prefix sums from the left and right using heap properties
// - At each valid partition point, compute difference and track the minimum

class Solution {
  public long minimumDifference(int[] nums) {
    final int n = nums.length / 3;
    long ans = Long.MAX_VALUE;
    long leftSum = 0;
    long rightSum = 0;

    // Max heap for left part (we want smallest possible sum of n largest elements)
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    // Min heap for right part (we want largest possible sum of n smallest elements)
    Queue<Integer> minHeap = new PriorityQueue<>();

    // minLeftSum[i] stores minimum sum of n elements from nums[0..i)
    long[] minLeftSum = new long[nums.length];

    // Build left sums using max heap
    for (int i = 0; i < 2 * n; ++i) {
      maxHeap.offer(nums[i]);
      leftSum += nums[i];

      // Maintain size of n
      if (maxHeap.size() == n + 1)
        leftSum -= maxHeap.poll();

      if (maxHeap.size() == n)
        minLeftSum[i] = leftSum;
    }

    // Build right sums using min heap and compute minimum difference
    for (int i = nums.length - 1; i >= n; --i) {
      minHeap.offer(nums[i]);
      rightSum += nums[i];

      // Maintain size of n
      if (minHeap.size() == n + 1)
        rightSum -= minHeap.poll();

      if (minHeap.size() == n)
        ans = Math.min(ans, minLeftSum[i - 1] - rightSum);
    }

    return ans;
  }
}

// ⏱️ Time Complexity: O(n log n) 
//     - Each heap operation is log n and we do it for up to 2n elements
// 🧠 Space Complexity: O(n) 
//     - For storing prefix sums and maintaining heaps
