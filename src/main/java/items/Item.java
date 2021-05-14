package items;

import behaviours.IStore;
import behaviours.IWield;

public abstract class Item implements IStore, IWield {

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
