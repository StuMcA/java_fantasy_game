import characters.Cleric;
import characters.Species;
import items.HealingObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    Cleric cleric;
    HealingObject healingObject;

    @Before
    public void setUp() {
        healingObject = new HealingObject("Glass Acorn", 30, 10, 300);
        cleric = new Cleric("Genevieve", Species.DWARF, 100);
    }

    @Test
    public void canWieldHealingObjectInLeftHand() {
        cleric.setLeftHand(healingObject);
        assertEquals(healingObject, cleric.getLeftHand());
    }
    @Test
    public void canWieldHealingObjectInRightHand() {
        cleric.setRightHand(healingObject);
        assertEquals(healingObject, cleric.getRightHand());
    }

}