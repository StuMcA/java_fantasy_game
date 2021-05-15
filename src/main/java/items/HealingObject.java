package items;

import behaviours.IWield;

public class HealingObject extends Item {

    private String type;
    private int healingPower;
    private int numberUses;


    public HealingObject(String type, int healingPower, int numberUses, int value){
        super(value);
        this.type = type;
        this.healingPower = healingPower;
        this.numberUses = numberUses;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public int getNumberUses() {
        return numberUses;
    }

    public void setNumberUses(int numberUses) {
        this.numberUses = numberUses;
    }
}
