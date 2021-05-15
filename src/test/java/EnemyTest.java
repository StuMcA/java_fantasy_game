import characters.Enemy;
import characters.Species;
import items.Stash;
import items.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyTest {

    private Enemy goblin;
    private Treasure treasure;
    private Stash stash;

    @Before
    public void setUp() {
        this.goblin = new Enemy("Loz", Species.GOBLIN, 20);
        this.treasure = Treasure.COIN;
        this.stash = new Stash(treasure, 100);
    }

    @Test
    public void goblinHasLoot() {
        goblin.addLoot(stash);
        assertEquals(100, goblin.getLoot().get(0).getValue());
    }
}
