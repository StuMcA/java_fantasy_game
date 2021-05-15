import characters.*;
import items.HealingObject;
import items.WeaponType;
import org.junit.Before;
import org.junit.Test;
import items.Weapon;
import items.Treasure;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Room room1, room2, room3, room4;
    GameCharacter cleric1, knight1;
    Treasure treasure1, treasure2;
    Enemy enemy1, enemy2, enemy3;
    Knight character1;
    Cleric character2;
    HealingObject healingObject;
    Weapon weapon;

    @Before
    public void setUp(){
        weapon = new Weapon(WeaponType.MACE, 30, 1, 500);
        healingObject = new HealingObject("Snake Milk", 25, 30, 150);
        character1 = new Knight("Hansel", Species.ELF, 80);
        character2 = new Cleric("Genevieve", Species.HUMAN, 100);
        treasure1 = Treasure.DIAMOND;
        treasure2 = Treasure.RUBY;
        enemy1 = new Enemy("Goblin", Species.GOBLIN, 100);
        enemy2 = new Enemy("Harpy", Species.GOBLIN, 120);
        enemy3 = new Enemy("Giant Ned",Species.GOBLIN, 60);
        knight1 = new Knight("Colin", Species.HUMAN, 120);
        cleric1 = new Cleric("Samantha", Species.ELF, 130);
        room1 = new Room("Leith Walk Costa");
        room2 = new Room("Tesco");
        room3 = new Room("The Harp and Castle");
        room4 = new Room("The Meadows");
        game = new Game();

    }

    @Test
    public void canAddPlayer(){
        game.addPlayer(knight1);
        assertEquals(1, game.getPlayersSize());
    }

    @Test
    public void canAddRoom(){
        game.addRoom(room1);
        assertEquals(1, game.getRoomsSize());
    }

//    @Test
//    public void canGetPlayer(){
//        game.addPlayer(knight1);
//        game.addPlayer(cleric1);
//        assertEquals("Colin", game.getPlayer(0).getName());
//    }

//    @Test
//    public void canCheckRoomNoEnemy(){
//        room2.addTreasure(treasure1);
//        room2.addTreasure(treasure2);
//        game.checkRoom(room2, knight1);
//        assertEquals(2, knight1.getInventorySize());
//        assertEquals(0, room2.getTreasureSize());
//    }

//    @Test
//    public void canInitiateAttack(){
//        game.addPlayer(knight1);
//        game.addPlayer(cleric1);
//        game.getTotals(room1);
//        assertEquals(20, room1.getEnemy().getHealthPoints());
//    }

//    @Test
//    public void canHealPlayer(){
//        game.addPlayer(knight1);
//        game.healPlayers(20);
//        assertEquals(140, knight1.getHealthPoints());
//    }

//    @Test
//    public void canAttackEnemy(){
//        game.attackEnemy(20, room1);
//        assertEquals(30, room1.getEnemy().getHealthPoints());
//    }

//    @Test
//    public void canDamagePlayers(){
//        game.addPlayer(knight1);
//        game.addPlayer(cleric1);
//        game.playerDamage(20, room1);
//        assertEquals(100, game.getPlayer(0).getHealthPoints());
//    }

    @Test
    public void canRemoveDeadPlayer(){
        game.addPlayer(knight1);
        game.addPlayer(cleric1);
        game.playerDamage(120, room1);
        assertEquals(1, game.getPlayersSize());
    }

//    @Test
//    public void canLoopRoomsAndWin(){
//        game.addPlayer(knight1);
//        game.addPlayer(cleric1);
//        game.addRoom(room1);
//        game.addRoom(room2);
//        game.addRoom(room3);
//        game.loopRooms();
//        assertEquals(1, game.getPlayersSize());
//    }

//    @Test
//    public void canLoopRoomsAndLose(){
//        game.addPlayer(knight1);
//        game.addRoom(room1);
//        game.addRoom(room2);
//        game.addRoom(room4);
//        game.loopRooms();
//        assertEquals(0, game.getPlayersSize());
//    }

}
