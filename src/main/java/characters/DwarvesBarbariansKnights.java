package characters;

import behaviours.IPlay;
import playerActions.Weapon;

public class DwarvesBarbariansKnights implements IPlay {

    private Weapon weapon;

    public DwarvesBarbariansKnights(Weapon weapon){
        this.weapon = weapon;
    }

    public int playerAction() {
        return this.weapon.getDamage();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
