package minqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {
    @Test
    public void oneElement() {
        MinStack stack = new MinStack();
        stack.push(1);
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void twoAscendingElements() {
        MinStack stack = new MinStack();
        stack.push(1);
        assertEquals(1, stack.min());
        stack.push(2);
        assertEquals(1, stack.min());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void twoDescendingElements() {
        MinStack stack = new MinStack();
        stack.push(2);
        assertEquals(2, stack.min());
        stack.push(1);
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.min());
        assertEquals(2, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void twoEqualElements() {
        MinStack stack = new MinStack();
        stack.push(1);
        assertEquals(1, stack.min());
        stack.push(1);
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
