package characters;

import behaviours.IPlay;
import playerActions.Weapon;

public class DwarvesBarbariansKnights implements IPlay {

    private Weapon weapon;

    public DwarvesBarbariansKnights(Weapon weapon){
        this.weapon = weapon;
    }

    public void playerAction() {

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
