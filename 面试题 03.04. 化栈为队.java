class MyQueue {
    public Deque<Integer> frontStack = new LinkedList<>();
    public Deque<Integer> backStack = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        frontStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!backStack.isEmpty()) {
            return backStack.pop();
        } else {
            while (!frontStack.isEmpty()) {
                backStack.push(frontStack.pop());
            }
            return backStack.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!backStack.isEmpty()) {
            return backStack.peek();
        } else {
            while (!frontStack.isEmpty()) {
                backStack.push(frontStack.pop());
            }
            return backStack.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return frontStack.isEmpty() && backStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */