package characters;

import behaviours.ICast;
import behaviours.IHeal;
import behaviours.IWield;
import items.Spell;

public class Cleric extends GameCharacter implements ICast, IHeal {


    public Cleric(String name, Species species, int healthPoints){
        super(name, species, healthPoints);
        super.setHealthMultiplier(0.8);
        super.setDamageMultiplier(0.7);
        super.setDefenseMultiplier(0.8);
    }
    public IWield getSpell() {
        if (super.getLeftHand() instanceof Spell) {
            return super.getLeftHand();
        }
        return null;
    }

    public void equipSpell(IWield spell) {
        super.setLeftHand(spell);
    }

    public IWield getHealingObject() {
        return super.getRightHand();
    }

    public void equipHealingObject(IWield healingObject) {
        super.setRightHand(healingObject);
    }
    public int castSpell(GameCharacter target) {
        int spellPower = 0;
        if (getLeftHand() instanceof Spell) {
            spellPower += getLeftHand().getPower();
        }
        if (getRightHand() instanceof Spell) {
            spellPower += getRightHand().getPower();
        }
        target.setHealthPoints(target.getHealthPoints() - spellPower);
        return (int) (spellPower * getRandomMultiplier());
    }
}
