// LeetCode 232: Implement Queue using Stacks — Easy

class MyQueue {
  // Stack to store incoming elements
  private Deque<Integer> input = new ArrayDeque<>();
  // Stack to reverse order for popping/peeking
  private Deque<Integer> output = new ArrayDeque<>();

  // Push element x to the back of queue
  public void push(int x) {
    input.push(x);
  }

  // Removes the element from in front of queue and returns it
  public int pop() {
    peek(); // Ensure output has the current front
    return output.pop();
  }

  // Get the front element
  public int peek() {
    if (output.isEmpty()) {
      // Transfer elements from input to output to reverse order
      while (!input.isEmpty())
        output.push(input.pop());
    }
    return output.peek();
  }

  // Return whether the queue is empty
  public boolean empty() {
    return input.isEmpty() && output.isEmpty();
  }

  /*
   Flashcard Summary:
   ---------------------
   Problem: Implement a FIFO queue using only two LIFO stacks.

   Idea:
     - Use two stacks:
       - `input` stack for incoming elements
       - `output` stack for popping/peeking
     - Only move elements from input to output when output is empty.

   Example:
     Input: ["MyQueue", "push", "push", "peek", "pop", "empty"]
     Values:        [[],     [1],   [2],    [],     [],     []]
     Output:        [null,   null,  null,    1,      1,     false]

   Amortized Time:
     - `push`: O(1)
     - `pop`, `peek`: Amortized O(1) because each element moves once between stacks
     - `empty`: O(1)

   Total Time Complexity: Amortized O(1) per operation
   Space Complexity: O(n)
  */
}
