package items;

public enum Treasure {
    COIN ("Coin", 1),
    RUBY ("Ruby", 5),
    DIAMOND ("Diamond", 10);

    private final String name;
    private final int value;

    Treasure(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
