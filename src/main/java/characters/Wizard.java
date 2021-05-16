package characters;

import behaviours.ICast;
import behaviours.IWield;

import java.util.Random;

public class Wizard extends GameCharacter implements ICast {

    private GameCharacter familiar;

        public Wizard(String name, Species species, int healthPoints){
            super(name, species, healthPoints);
            super.setHealthMultiplier(1.5);
            super.setDamageMultiplier(0.4);
            super.setDefenseMultiplier(0.5);
            this.familiar = null;
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

    public GameCharacter getFamiliar() {
        return familiar;
    }

    public void setFamiliar(GameCharacter familiar) {
        this.familiar = familiar;
    }

    public void equipStaff(IWield staff) {
        super.setRightHand(staff);
    }

    public void summonFamiliar() {
        Random random = new Random();
        double generatedNumber = random.nextDouble();
        String familiarName = "";
        if (generatedNumber > 0.9 ) {
            familiarName = "Destroyer of Worlds";
        } else if(generatedNumber > 0.7) {
            familiarName = "T2000";
        } else if (generatedNumber > 0.5) {
            familiarName = "Karen";
        } else if (generatedNumber > 0.3) {
            familiarName = "Napoleon Dynamite";
        } else {
            familiarName = "Kenny";
        }
            GameCharacter summonedFamiliar = new Familiar(familiarName, Species.DEMON, 100);
            summonedFamiliar.setDamageMultiplier(generatedNumber);
            summonedFamiliar.setHealthMultiplier(generatedNumber);
            summonedFamiliar.setDefenseMultiplier(generatedNumber);
            summonedFamiliar.setHealthPoints( (int) Math.round(summonedFamiliar.getHealthPoints() * summonedFamiliar.getHealthMultiplier()));
    }

    public int defend(int damageDone) {
            if (this.familiar != null) {
                damageDone = (int) Math.round(damageDone / familiar.getDefenseMultiplier());
                familiar.setHealthPoints(familiar.getHealthPoints() - damageDone);
                if  (this.familiar.getHealthPoints() < 0) {
                    this.familiar = null;
                }
                return 0;
            }
            return damageDone;
    }
}
