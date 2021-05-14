import characters.Species;
import characters.Wizard;
import items.Spell;
import items.SpellType;
import items.Weapon;
import items.WeaponType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Wizard wizard;
    Spell fireSpell;
    Weapon staff;

    @Before
    public void setUp() {
        wizard = new Wizard("Henri", Species.HUMAN, 60);
        fireSpell = new Spell(SpellType.ATTACKING, 60, 1);
        staff = new Weapon(WeaponType.STAFF, 20, 1, 100);
    }

    @Test
    public void canEquipSpell() {
        wizard.equipSpell(fireSpell);
        assertEquals(fireSpell, wizard.getSpell());
    }

    @Test
    public void canEquipStaff() {
        wizard.equipStaff(staff);
        assertEquals(staff, wizard.getStaff());
    }
}
