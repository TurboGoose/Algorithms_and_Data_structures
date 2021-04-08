package queue;

import java.util.Stack;

public class MinStack {
    private final Stack<Pair> stack = new Stack<>();

    public void push(int value) {
        int min = stack.isEmpty() ? value : Math.min(value, stack.peek().getMin());
        stack.push(new Pair(value, min));
    }

    public int pop() {
        return stack.pop().getValue();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int min() {
        return stack.peek().getMin();
    }
}
