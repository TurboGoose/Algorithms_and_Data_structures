package antiquicksort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AntiQuickSortTest {
    @Test
    public void nEqualsOne() {
        assertEquals(List.of(1), Main.generateWorstCaseTest(1));
    }

    @Test
    public void nEqualsTwo() {
        assertEquals(List.of(1, 2), Main.generateWorstCaseTest(2));
    }

    @Test
    public void nEqualsThree() {
        assertEquals(List.of(2, 1, 3), Main.generateWorstCaseTest(3));
    }

    @Test
    public void nEqualsFour() {
        assertEquals(List.of(3, 1, 2, 4), Main.generateWorstCaseTest(4));
    }

    @Test
    public void nEqualsFive() {
        assertEquals(List.of(4, 2, 1, 3, 5), Main.generateWorstCaseTest(5));
    }

    @Test
    public void nEqualsSix() {
        assertEquals(List.of(5, 3, 1, 2, 4, 6), Main.generateWorstCaseTest(6));
    }
}
