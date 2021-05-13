import characters.Clerics;
import org.junit.Before;
import org.junit.Test;
import playerActions.HealingTool;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    Clerics clerics;
    HealingTool healingTool;

    @Before
    public void setUp(){
        healingTool = new HealingTool("Glass Acorn", 30);
        clerics = new Clerics(healingTool);
    }

    @Test
    public void canGetHealingPower(){
        assertEquals(-30, clerics.playerAction());
    }

}
