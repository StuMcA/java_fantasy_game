package characters;

public class Familiar extends GameCharacter {

    public Familiar(String name, Species species, int healthPoints) {
        super(name, species, healthPoints);
        this.setBaseAttackPower(50);
    }


}
