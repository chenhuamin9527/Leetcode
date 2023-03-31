import java.util.Deque;
import java.util.LinkedList;

// 排序栈主要算法实现在push操作内完成
class SortedStack {
    public Deque<Integer> stack = new LinkedList<Integer>();
    public Deque<Integer> tempStack = new LinkedList<Integer>();

    public SortedStack() {

    }

    public void push(int val) {
        // stack为空时直接插入
        if (stack.isEmpty()) {
            stack.push(val);

        } else {
            while (true) {
                // 每次插入前比较栈顶元素，小于等于可以直接push
                if (stack.isEmpty() || val <= stack.peek()) {
                    stack.push(val);

                    break;
                } else {// 如果大于stack顶时将栈顶push到tempStack中，重复比较stack的栈顶。
                    tempStack.push(stack.pop());

                }
            }
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty())
            stack.pop();
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */