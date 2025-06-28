class Solution {
  public int[] maxSubsequence(int[] nums, int k) {
    int[] ans = new int[k];

    // Step 1: Clone and sort the array to find the k largest values
    int[] arr = nums.clone();
    Arrays.sort(arr);

    // Step 2: The smallest value among the k largest values
    int threshold = arr[arr.length - k];

    // Step 3: Count how many numbers are strictly greater than threshold
    int larger = (int) Arrays.stream(nums).filter(num -> num > threshold).count();

    // Step 4: Figure out how many values equal to threshold can be included
    int equal = k - larger;

    // Step 5: Traverse original array and pick values to form subsequence
    int i = 0;
    for (int num : nums) {
      if (num > threshold) {
        ans[i++] = num; // Add all values greater than threshold
      } else if (num == threshold && equal > 0) {
        ans[i++] = num; // Add required count of values equal to threshold
        --equal;
      }
    }

    return ans; // Return the selected subsequence in original order
  }
}
