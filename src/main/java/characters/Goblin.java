package characters;

import behaviours.IStore;

import java.util.ArrayList;

public class Goblin extends GameCharacter {

    private ArrayList<IStore> loot;
    private int attackPower;

    public Goblin(String name, Species species, int healthPoints) {
        super(name, species, healthPoints);
        this.loot = new ArrayList<>();
        this.attackPower = 30;
    }

    public ArrayList<IStore> getLoot() {
        return loot;
    }

    public void addLoot(IStore loot) {
        this.loot.add(loot);
    }

    public int getAttackPower() {
        return attackPower;
    }
}
