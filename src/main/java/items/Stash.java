package items;

import behaviours.IStore;

public class Stash implements IStore {

    private Treasure treasure;
    private int quantity;

    public Stash(Treasure treasure, int quantity) {
        this.treasure = treasure;
        this.quantity = quantity;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getValue() {
        return this.treasure.getValue() * this.quantity;
    }
}
