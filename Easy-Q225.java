// LeetCode 225: Implement Stack using Queues — Easy

class MyStack {
  // ✅ Use a single queue (rotate newly pushed item to front to simulate LIFO)
  private Queue<Integer> q = new ArrayDeque<>();

  public void push(int x) {
    q.offer(x); // Step 1: Add to back
    // Step 2: Rotate all elements except the new one to back
    for (int i = 0; i < q.size() - 1; ++i)
      q.offer(q.poll());
  }

  public int pop() {
    return q.poll(); // Front of queue acts as top of stack
  }

  public int top() {
    return q.peek(); // Peek front = top of stack
  }

  public boolean empty() {
    return q.isEmpty();
  }

  /*
   🧠 Flashcard-Style Summary:
   ----------------------------
   ✅ Problem: Implement a Stack (LIFO) using standard Queue operations.

   ✅ Strategy:
     - Use a single queue.
     - On push(x), rotate all existing elements to the back after adding x.
       Example: push(1) → [1]
                push(2) → [2,1]
                push(3) → [3,2,1] → LIFO preserved!
     - pop(): remove from front of queue
     - top(): peek front of queue
     - empty(): isEmpty check

   ⏱ Time:
     - push: O(n)
     - pop/top/empty: O(1)

   📦 Space: O(n)
  */
}
