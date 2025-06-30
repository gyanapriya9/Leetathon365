class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    // Always iterate over the smaller array for better performance
    if (nums1.length > nums2.length)
      return intersect(nums2, nums1);

    List<Integer> ans = new ArrayList<>(); // Stores the intersection result
    Map<Integer, Integer> count = new HashMap<>(); // Stores frequency of elements in nums1

    // Count frequency of each number in nums1
    for (final int num : nums1)
      count.put(num, count.getOrDefault(num, 0) + 1);

    // Traverse nums2 and match with count map
    for (final int num : nums2)
      if (count.containsKey(num) && count.get(num) > 0) {
        ans.add(num); // Add to result if present in map
        count.put(num, count.get(num) - 1); // Decrease count
      }

    // Convert List<Integer> to int[]
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }
}
