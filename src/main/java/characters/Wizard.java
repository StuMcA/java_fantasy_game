package characters;

import behaviours.ICast;
import behaviours.IWield;

public class Wizard extends GameCharacter implements ICast {

        public Wizard(String name, Species species, int healthPoints){
            super(name, species, healthPoints);
            super.setHealthMultiplier(1.5);
            super.setDamageMultiplier(0.4);
            super.setDefenseMultiplier(0.3);
        }

    public IWield getSpell() {
        return super.getLeftHand();
    }

    public void equipSpell(IWield spell) {
        super.setLeftHand(spell);
    }

    public IWield getStaff() {
        return super.getRightHand();
    }

    public void equipStaff(IWield staff) {
        super.setRightHand(staff);
    }
}
