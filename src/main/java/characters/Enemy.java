package characters;

import behaviours.IStore;

import java.util.ArrayList;

public class Enemy extends GameCharacter {

    private ArrayList<IStore> loot;

    public Enemy(String name, Species species, int healthPoints) {
        super(name, species, healthPoints);
        this.loot = new ArrayList<>();
        this.setBaseAttackPower(30);
    }

    public ArrayList<IStore> getLoot() {
        return loot;
    }

    public int getLootSize() {
        return this.loot.size();
    }

    public void addLoot(IStore loot) {
        this.loot.add(loot);
    }

    public void dropLoot() {
        this.loot.removeAll(loot);
    }




}
