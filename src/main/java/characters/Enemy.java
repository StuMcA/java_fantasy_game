package characters;

import behaviours.IStore;

import java.util.ArrayList;

public class Enemy extends GameCharacter {

    private ArrayList<IStore> loot;
    private int attackPower;

    public Enemy(String name, Species species, int healthPoints) {
        super(name, species, healthPoints);
        this.loot = new ArrayList<>();
        this.attackPower = 30;
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

    public int getAttackPower() {
        return attackPower;
    }


    public int attack(GameCharacter target) {
        int damageDone = this.getAttackPower();
        target.setHealthPoints(target.getHealthPoints() - damageDone);
        return damageDone;
    }
}
