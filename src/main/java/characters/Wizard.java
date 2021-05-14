package characters;

import behaviours.ICast;
import behaviours.IWield;

public class Wizard extends GameCharacter implements ICast {

        public Wizard(String name, Species species, int healthPoints){
            super(name, species, healthPoints);
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
