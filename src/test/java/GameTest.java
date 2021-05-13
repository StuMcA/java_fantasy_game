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
    Room room1, room2, room3, room4;
    Player player1, player2;
    Treasure treasure1, treasure2;
    Enemy enemy1, enemy2, enemy3;
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
        treasure1 = new Treasure("Gold Doubloons", 15);
        treasure2 = new Treasure("Rubies", 150);
        enemy1 = new Enemy("Goblin", 50, 20, treasure1);
        enemy2 = new Enemy("Harpy", 40, 25, treasure2);
        enemy3 = new Enemy("Giant Ned", 40, 5000, treasure2);
        player1 = new Player("Colin", 120, character1);
        player2 = new Player("Samantha", 130, character2);
        room1 = new Room("Leith Walk Costa", enemy1);
        room2 = new Room("Tesco", null);
        room3 = new Room("The Harp and Castle", enemy2);
        room4 = new Room("The Meadows", enemy3);
        game = new Game();

    }

    @Test
    public void canAddPlayer(){
        game.addPlayer(player1);
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    public void canAddRoom(){
        game.addRoom(room1);
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
        room2.addTreasure(treasure1);
        room2.addTreasure(treasure2);
        game.checkRoom(room2, player1);
        assertEquals(2, player1.getTreasureBagSize());
        assertEquals(0, room2.getTreasureSize());
    }

    @Test
    public void canInitiateAttack(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.getTotals(room1);
        assertEquals(20, room1.getEnemy().getHealthPoints());
    }

    @Test
    public void canHealPlayer(){
        game.addPlayer(player1);
        game.healPlayers(20);
        assertEquals(140, player1.getHealth());
    }

    @Test
    public void canAttackEnemy(){
        game.attackEnemy(20, room1);
        assertEquals(30, room1.getEnemy().getHealthPoints());
    }

    @Test
    public void canDamagePlayers(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.playerDamage(20, room1);
        assertEquals(100, game.getPlayer(0).getHealth());
    }

    @Test
    public void canRemoveDeadPlayer(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.playerDamage(120, room1);
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    public void canLoopRoomsAndWin(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addRoom(room1);
        game.addRoom(room2);
        game.addRoom(room3);
        game.loopRooms();
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    public void canLoopRoomsAndLose(){
        game.addPlayer(player1);
        game.addRoom(room1);
        game.addRoom(room2);
        game.addRoom(room4);
        game.loopRooms();
        assertEquals(0, game.getPlayersSize());
    }

}
