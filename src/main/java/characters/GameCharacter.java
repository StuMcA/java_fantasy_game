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
    private double healthMultiplier;
    private double damageMultiplier;
    private double defenseMultiplier;
    private boolean isDead;

    public GameCharacter(String name, Species species, int healthPoints){
        this.name = name;
        this.species = species;
        this.healthPoints = healthPoints;
        this.leftHand = null;
        this.rightHand = null;
        this.inventory = new ArrayList<>();
        this.healthMultiplier = 1;
        this.damageMultiplier = 1;
        this.defenseMultiplier = 1;
        this.isDead = false;
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

    public double getHealthMultiplier() {
        return healthMultiplier;
    }

    public void setHealthMultiplier(double healthMultiplier) {
        this.healthMultiplier = healthMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public double getDefenseMultiplier() {
        return defenseMultiplier;
    }

    public void setDefenseMultiplier(double defenseMultiplier) {
        this.defenseMultiplier = defenseMultiplier;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        isDead = true;
    }

    public double getDamageMultiplier(GameCharacter character) {
        return character.getSpecies().getDamageMultiplier() * character.getDamageMultiplier();
    }

    public int attack(GameCharacter target) {
        int damageDone = 0;
        if (!(this.getLeftHand() == null)) {
            damageDone += this.getLeftHand().getPower();
        }
        if (!(this.getRightHand() == null)) {
            damageDone += this.getRightHand().getPower();

        }
        damageDone = (int) (damageDone * getDamageMultiplier() / target.getDefenseMultiplier());
        target.setHealthPoints(target.getHealthPoints() - damageDone);
        return damageDone;
    }


    public int heal(GameCharacter target) {
        int healingDone = 0;
        if (!(this.getLeftHand() == null)) {
            healingDone += this.getLeftHand().getPower();
        }
        if (!(this.getRightHand() == null)) {
            healingDone += this.getRightHand().getPower();
        }
        target.setHealthPoints(target.getHealthPoints() + healingDone);
        return healingDone;
    }
}
