import characters.Clerics;
import characters.DwarvesBarbariansKnights;
import characters.Enemy;
import org.junit.Before;
import org.junit.Test;
import playerActions.HealingTool;
import playerActions.Weapon;
import rooms.Treasure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameTest {

    Game game;
    Room room, room2;
    Player player1, player2;
    Treasure treasure;
    Enemy enemy;
    DwarvesBarbariansKnights character1;
    Clerics character2;
    HealingTool healingTool;
    Weapon weapon;

    @Before
    public void setUp(){
        weapon = new Weapon("Mace", 30);
        healingTool = new HealingTool("Snake Milk", 25);
        character1 = new DwarvesBarbariansKnights(weapon);
        character2 = new Clerics(healingTool);
        treasure = new Treasure("Gold Doubloons", 15);
        enemy = new Enemy("Goblin", 50, 20, treasure);
        player1 = new Player("Colin", 120, character1);
        player2 = new Player("Samantha", 130, character2);
        room = new Room("Leith Walk Costa", enemy);
        game = new Game();

    }

    @Test
    public void canAddPlayer(){
        game.addPlayer(player1);
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    public void canAddRoom(){
        game.addRoom(room);
        assertEquals(1, game.getRoomsSize());
    }

    @Test
    public void canGetPlayer(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals("Colin", game.getPlayer(0).getName());
    }

    @Test
    public void canCheckRoomNoEnemy(){
        room2 = new Room("Tesco", null);
        room2.addTreasure(treasure);
        room2.addTreasure(treasure);
        game.checkRoom(room2, player1);
        assertEquals(2, player1.getTreasureBagSize());
        assertEquals(0, room2.getTreasureSize());
    }

    @Test
    public void canInitiateAttack(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.getTotals(room);
        assertEquals(20, room.getEnemy().getHealthPoints());
    }

    @Test
    public void canHealPlayer(){
        game.addPlayer(player1);
        game.healPlayers(20);
        assertEquals(140, player1.getHealth());
    }

    @Test
    public void canAttackEnemy(){
        game.attackEnemy(20, room);
        assertEquals(30, room.getEnemy().getHealthPoints());
    }

    @Test
    public void canDamagePlayers(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.playerDamage(20);
        assertEquals(100, game.getPlayer(0).getHealth());
    }

    @Test
    public void canRemoveDeadPlayer(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.playerDamage(120);
        assertEquals(1, game.getPlayersSize());
    }

}
