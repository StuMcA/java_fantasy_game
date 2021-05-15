import characters.Enemy;
import characters.Species;
import items.HealingObject;
import items.Stash;
import items.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RoomTest {

    private Room room;
    private Enemy enemy1, enemy2;
    private Treasure treasure;
    private Stash stash;
    private HealingObject healingObject;

    @Before
    public void setUp(){
        room = new Room("Seafield Waste Water Treatment Centre");
        enemy1 = new Enemy("Benjamin", Species.GOBLIN, 60);
        enemy1 = new Enemy("Farqhuar", Species.GOBLIN, 60);
        treasure = Treasure.RUBY;
        stash = new Stash(treasure, 5);
        healingObject = new HealingObject("Voodoo Thumb", 50, 2, 60);
    }

    @Test
    public void canAddEnemiesToRoom() {
        room.addEnemy(enemy1);
        room.addEnemy(enemy2);
        assertEquals(2, room.getEnemyList().size());
    }
    @Test
    public void canAddTreasureToRoom() {
        room.addTreasure(stash);
        room.addTreasure(healingObject);
        assertEquals(2, room.getTreasureList().size());
    }
}
