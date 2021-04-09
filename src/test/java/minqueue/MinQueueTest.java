package minqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinQueueTest {
    @Test
    public void oneElement() {
        MinQueue queue = new MinQueue();
        queue.push(1);
        assertEquals(1, queue.min());
        assertEquals(1, queue.pop());
    }

    @Test
    public void twoAscendingElements() {
        MinQueue queue = new MinQueue();
        queue.push(1);
        assertEquals(1, queue.min());
        queue.push(2);
        assertEquals(1, queue.min());
        assertEquals(1, queue.pop());
        assertEquals(2, queue.min());
        assertEquals(2, queue.pop());
    }

    @Test
    public void twoDescendingElements() {
        MinQueue queue = new MinQueue();
        queue.push(2);
        assertEquals(2, queue.min());
        queue.push(1);
        assertEquals(1, queue.min());
        assertEquals(2, queue.pop());
        assertEquals(1, queue.min());
        assertEquals(1, queue.pop());
    }

    @Test
    public void twoEqualElements() {
        MinQueue queue = new MinQueue();
        queue.push(1);
        assertEquals(1, queue.min());
        queue.push(1);
        assertEquals(1, queue.min());
        assertEquals(1, queue.pop());
        assertEquals(1, queue.min());
        assertEquals(1, queue.pop());
    }
}
