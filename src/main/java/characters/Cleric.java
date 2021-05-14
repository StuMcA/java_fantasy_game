package characters;

import behaviours.ICast;
import behaviours.IHeal;

public class Cleric extends GameCharacter implements ICast, IHeal {


    public Cleric(String name, Species species, int healthPoints){
        super(name, species, healthPoints);
    }


}
