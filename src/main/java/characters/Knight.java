package characters;

public class Knight extends GameCharacter{


    public Knight(String name, Species species, int healthPoints) {
        super(name, species, healthPoints);
        super.setHealthMultiplier(1.1);
        super.setDamageMultiplier(1.1);
        super.setDefenseMultiplier(1.1);
    }

}



