import characters.Knight;
import characters.Species;
import items.Weapon;
import items.WeaponType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    Knight knight;
    Weapon sword;

    @Before
    public void setUp() {
        knight = new Knight("Archibald", Species.ELF, 150);
        sword = new Weapon(WeaponType.SWORD, 50, 1, 100);
    }

    @Test
    public void canWieldSwordInLeftHand() {
        knight.setLeftHand(sword);
        assertEquals(sword, knight.getLeftHand());
    }
    @Test
    public void canWieldSwordInRightHand() {
        knight.setRightHand(sword);
        assertEquals(sword, knight.getRightHand());
    }

    @Test
    public void canGetName() {
        assertEquals("Archibald", knight.getName());
    }

}
