import behaviours.IWield;
import characters.*;
import items.Spell;
import items.SpellType;
import items.Weapon;
import items.WeaponType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WizardTest {

    Wizard wizard;
    Spell fireSpell;
    Weapon staff;
    Game game;
    Familiar familiar;
    Enemy goblin;

    @Before
    public void setUp() {
        wizard = new Wizard("Henri", Species.HUMAN, 60);
        fireSpell = new Spell(SpellType.ATTACKING, 60, 1);
        staff = new Weapon(WeaponType.STAFF, 20, 1, 100);
        game = new Game();
        familiar = new Familiar("Demon", Species.DEMON, 100);
        goblin = new Enemy("Goblin", Species.GOBLIN, 90);
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

    @Test
    public void canSummonFamiliar() {
        game.addPlayer(wizard);
        wizard.summonFamiliar();
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    public void familiarCanTakeDamage() {
        wizard.setFamiliar(familiar);
        goblin.attack(wizard);
        assertEquals(60, wizard.getHealthPoints());
        assertTrue(familiar.getHealthPoints() < 100);
    }

    @Test
    public void familiarCanAttack() {
        wizard.setFamiliar(familiar);
        wizard.setDamageMultiplier(0);
        wizard.attack(goblin);
        assertTrue(goblin.getHealthPoints() < 100);
    }

    @Test
    public void wizardCanAttackWithNoFamiliar() {
        wizard.setLeftHand(staff);
        wizard.attack(goblin);
        assertTrue(goblin.getHealthPoints() < 100);
    }

    @Test
    public void canCastSpell() {
        wizard.equipSpell(fireSpell);
        wizard.castSpell(goblin);
        assertTrue(goblin.getHealthPoints() <100);
    }

    @Test
    public void staffIncreasesSpellPower() {
        wizard.equipSpell(fireSpell);
        wizard.equipStaff(staff);
        wizard.castSpell(goblin);
        assertTrue(goblin.getHealthPoints() < 0);
    }
}
