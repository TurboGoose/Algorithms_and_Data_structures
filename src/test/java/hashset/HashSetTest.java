package hashset;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {
    @Test
    public void whenAddThenContainsThenRemove() {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        assertTrue(set.contains(5));
        set.remove(5);
        assertFalse(set.contains(5));
    }

    @Test
    public void whenAddTwoEqualElements() {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        assertTrue(set.contains(5));
        set.add(5);
        assertTrue(set.contains(5));
        set.remove(5);
        assertFalse(set.contains(5));
    }

    @Test
    public void removeNonExistentElement() {
        HashSet<Integer> set = new HashSet<>();
        assertFalse(set.contains(5));
        set.add(6);
        assertTrue(set.contains(6));
        assertFalse(set.contains(5));
    }
}