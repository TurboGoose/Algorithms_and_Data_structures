package minqueue;

public class Pair {
    private final int value;
    private final int min;

    public Pair(int value, int min) {
        this.value = value;
        this.min = min;
    }

    public int getValue() {
        return value;
    }

    public int getMin() {
        return min;
    }
}
