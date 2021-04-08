package queue;

public class MinQueue {
    private final MinStack stack1 = new MinStack();
    private final MinStack stack2 = new MinStack();

    public void push(int value) {
        stack1.push(value);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int min() {
        if (stack1.isEmpty() || stack2.isEmpty()) {
            return stack1.isEmpty() ? stack2.min() : stack1.min();
        }
        return Math.min(stack1.min(), stack2.min());
    }
}
