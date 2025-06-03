// LeetCode 1298: Maximum Candies You Can Get from Boxes (Hard)

// 🧠 Problem Explanation:
/*
You are given:
- status[i]: 1 if box i is open, 0 if closed.
- candies[i]: number of candies in box i.
- keys[i]: list of boxes that can be opened using keys in box i.
- containedBoxes[i]: list of boxes found inside box i.
- initialBoxes: boxes initially in your possession.

Rules:
- You can open a box if it's open or you have its key.
- From an opened box, you can collect candies, keys to new boxes, and boxes.

Goal:
Collect the maximum candies possible by opening boxes in a valid sequence.
*/


// 🧪 Example:
/*
Input:
status = [1,0,1,0]
candies = [7,5,4,100]
keys = [[],[],[1],[]]
containedBoxes = [[1,2],[3],[],[]]
initialBoxes = [0]

Output: 16

Explanation:
Start with box 0 → 7 candies, get boxes 1 & 2.
Box 2 is open → 4 candies, key to box 1.
Now open box 1 → 5 candies, box 3 (no key for it).
Total = 7 + 4 + 5 = 16
*/


// 💡 Approach (BFS + Queue):
/*
1. Use a Queue for BFS traversal of accessible boxes.
2. Track visited/seen boxes that are closed but in your possession.
3. When a key is found for a seen box, enqueue it.
4. Keep collecting candies, keys, and boxes as you go.
*/


// ✅ Code:
import java.util.*;

class Solution {
  public int maxCandies(int[] status, int[] candies, int[][] keys,
                        int[][] containedBoxes, int[] initialBoxes) {
    int n = status.length;
    boolean[] seen = new boolean[n];
    Queue<Integer> q = new LinkedList<>();
    int totalCandies = 0;

    // Helper function to process a box
    for (int box : initialBoxes) {
      if (status[box] == 1) {
        q.offer(box);
      } else {
        seen[box] = true;
      }
    }

    while (!q.isEmpty()) {
      int curr = q.poll();
      totalCandies += candies[curr];

      // Add keys from current box
      for (int key : keys[curr]) {
        if (status[key] == 0) {
          status[key] = 1; // unlock the box
          if (seen[key]) {
            q.offer(key); // was previously seen but closed
          }
        }
      }

      // Add contained boxes
      for (int next : containedBoxes[curr]) {
        if (status[next] == 1) {
          q.offer(next);
        } else {
          seen[next] = true;
        }
      }
    }

    return totalCandies;
  }
}


// ⏱ Time Complexity: O(N + K)
// - N = number of boxes
// - K = total keys and contained boxes processed
// Each box is processed once, and each key/box reference is seen once.

// 🧠 Space Complexity: O(N)
// - Queue for BFS and arrays (seen, status) are of size N
