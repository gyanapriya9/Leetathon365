class Solution {
  public int[] constructRectangle(int area) {
    // Start with the square root of area to minimize the difference |L - W|
    int width = (int) Math.sqrt(area);

    // Decrease width until it perfectly divides the area
    while (area % width != 0)
      --width;

    // Length is area / width, ensuring L >= W
    return new int[] {area / width, width};
  }
}
