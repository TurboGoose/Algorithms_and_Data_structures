package lsd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LsdSortTest {
    final char[][] data = {{'b', 'b', 'b', 'a'}, {'a', 'b', 'a', 'a'}, {'a', 'a', 'b', 'b'}};

    @Test
    public void whenKEquals1() {
        assertArrayEquals(new int[] {2, 3, 1}, Main.lsdSort(data, 1));
    }

    @Test
    public void whenKEquals2() {
        assertArrayEquals(new int[] {3, 2, 1}, Main.lsdSort(data, 2));
    }

    @Test
    public void whenKEquals3() {
        assertArrayEquals(new int[] {2, 3, 1}, Main.lsdSort(data, 3));
    }
}
