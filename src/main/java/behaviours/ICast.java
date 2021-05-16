package behaviours;

import characters.GameCharacter;
import items.Spell;

public interface ICast {

    public IWield getSpell();

    int castSpell(GameCharacter target);

}
