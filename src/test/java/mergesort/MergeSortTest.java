package mergesort;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    @Test
    @Disabled
    public void emptyArray() {
        int[] arr = new int[0];
        assertArrayEquals(arr, Main.mergeSort(arr, System.out));
    }

    @Test
    @Disabled
    public void oneElement() {
        int[] arr = new int[]{1};
        assertArrayEquals(arr, Main.mergeSort(arr, System.out));
    }

    @Test
    @Disabled
    public void twoElements() {
        int[] arr = new int[]{2, 1};
        assertArrayEquals(new int[]{1, 2}, Main.mergeSort(arr, System.out));
    }

    @Test
    @Disabled
    public void evenNumberOfElements() {
        int[] arr = new int[]{4, 1, 3, 2};
        assertArrayEquals(new int[]{1, 2, 3, 4}, Main.mergeSort(arr, System.out));
    }

    @Test
    @Disabled
    public void oddNumberOfElements() {
        int[] arr = new int[]{4, 1, 5, 1, 2};
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Main.mergeSort(arr, System.out));
    }
}
