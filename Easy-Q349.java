class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    List<Integer> ans = new ArrayList<>(); // Stores the result
    //  Convert nums1 into a set to remove duplicates and allow O(1) lookups
    Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

    // Iterate through nums2
    for (final int num : nums2)
      //  If num is in the set, it's a common element
      //  Also remove it to avoid duplicates in the answer
      if (set.remove(num))
        ans.add(num);

    // Convert List<Integer> to int[]
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }
}
