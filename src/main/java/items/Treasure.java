package items;

public enum Treasure {
    COIN (1),
    RUBY (5),
    DIAMOND (10);

    private final int value;

    Treasure(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
