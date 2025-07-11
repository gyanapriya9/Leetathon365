class Solution {
  public int mostBooked(int n, int[][] meetings) {
    // Custom record to store (endTime, roomId)
    record T(long endTime, int roomId) {}

    int[] count = new int[n]; // Count of meetings each room has hosted

    // Sort meetings by their start time
    Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));

    // Priority queue of occupied rooms ordered by (endTime, roomId)
    Queue<T> occupied = new PriorityQueue<>(
      Comparator.comparingLong(T::endTime).thenComparingInt(T::roomId)
    );

    // Min-heap of available room IDs
    Queue<Integer> availableRoomIds = new PriorityQueue<>();
    for (int i = 0; i < n; ++i)
      availableRoomIds.offer(i);

    for (int[] meeting : meetings) {
      int start = meeting[0];
      int end = meeting[1];

      // Free up rooms that have completed their meetings by `start`
      while (!occupied.isEmpty() && occupied.peek().endTime <= start)
        availableRoomIds.offer(occupied.poll().roomId);

      if (availableRoomIds.isEmpty()) {
        // All rooms busy, delay the meeting to when the earliest one is free
        T t = occupied.poll(); // Get the room that frees earliest
        ++count[t.roomId]; // Increment meeting count for that room
        // Reschedule the meeting: starts after `t.endTime`, same duration
        occupied.offer(new T(t.endTime + (end - start), t.roomId));
      } else {
        // Assign to the available room with the lowest ID
        int roomId = availableRoomIds.poll();
        ++count[roomId];
        occupied.offer(new T(end, roomId));
      }
    }

    // Find the room with the most meetings (return smallest ID in case of tie)
    int maxIndex = 0;
    for (int i = 1; i < n; ++i)
      if (count[i] > count[maxIndex])
        maxIndex = i;

    return maxIndex;
  }
}
