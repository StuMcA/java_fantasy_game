package items;

import behaviours.IWield;

public class Spell implements IWield {

    private SpellType spellType;
    private int spellPower;
    private int speed;

    public Spell(SpellType spellType, int spellPower, int speed) {
        this.spellType = spellType;
        this. spellPower = spellPower;
        this.speed = speed;
    }

}


