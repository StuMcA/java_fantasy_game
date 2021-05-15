import characters.Enemy;
import characters.Knight;
import characters.Species;
import items.Stash;
import items.Treasure;
import items.Weapon;
import items.WeaponType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnemyTest {

    private Enemy goblin;
    private Treasure treasure;
    private Stash stash;
    private Knight knight;
    private Weapon weapon;

    @Before
    public void setUp() {
        this.goblin = new Enemy("Loz", Species.GOBLIN, 20);
        this.treasure = Treasure.COIN;
        this.stash = new Stash(treasure, 100);
        this.knight = new Knight("Dave", Species.HUMAN, 150);
        this.weapon = new Weapon(WeaponType.SPEAR, 50, 1, 100);
        this.knight.setLeftHand(weapon);
    }

    @Test
    public void goblinHasLoot() {
        goblin.addLoot(stash);
        assertEquals(100, goblin.getLoot().get(0).getValue());
    }

    @Test
    public void canDropLoot() {
        goblin.addLoot(stash);
        goblin.dropLoot();
        assertEquals(0, goblin.getLootSize());
    }

    @Test
    public void canAttackWithBasePowerOnly() {
        goblin.attack(knight);
        assertTrue(knight.getHealthPoints() < 150);
    }
}
