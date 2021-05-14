package items;

import behaviours.IStore;

public abstract class Item implements IStore {

    private int value;

    public Item(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
