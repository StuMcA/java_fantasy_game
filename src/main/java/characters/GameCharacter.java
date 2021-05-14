package characters;

import behaviours.IHit;
import behaviours.IStore;
import behaviours.IWield;

import java.util.ArrayList;

public abstract class GameCharacter implements IHit {


    private String name;
    private Species species;
    private int healthPoints;
    private ArrayList<IStore> inventory;
    private IWield leftHand;
    private IWield rightHand;

    public GameCharacter(String name, Species species, int healthPoints){
        this.name = name;
        this.species = species;
        this.healthPoints = healthPoints;
        this.leftHand = null;
        this.rightHand = null;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int health) {
        this.healthPoints = health;
    }

    public Species getSpecies() {
        return species;
    }

    public void addToInventory(IStore item){
        this.inventory.add(item);
    }

    public int getInventorySize(){
        return this.inventory.size();
    }

    public IWield getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(IWield weaponOrSpell) {
        this.leftHand = weaponOrSpell;
    }

    public IWield getRightHand() {
        return rightHand;
    }

    public void setRightHand(IWield weapon) {
        this.rightHand = weapon;
    }
}
