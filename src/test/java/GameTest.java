import behaviours.IStore;
import characters.*;
import items.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Room room1, room2, room3, room4;
    GameCharacter cleric1, knight1;
    IStore treasure1, treasure2;
    Enemy enemy1, enemy2, enemy3;
    HealingObject healingObject;
    Weapon weapon;

    @Before
    public void setUp(){
        weapon = new Weapon(WeaponType.MACE, 30, 1, 500);
        healingObject = new HealingObject("Snake Milk", 25, 30, 150);
        treasure1 = new Stash(Treasure.DIAMOND, 5);
        treasure2 = new Stash(Treasure.RUBY, 10);
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
        knight1.setLeftHand(weapon);
        cleric1.setLeftHand(healingObject);
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

    @Test
    public void canGetPlayer(){
        game.addPlayer(knight1);
        game.addPlayer(cleric1);
        assertEquals("Colin", game.getPlayer(0).getName());
    }

    @Test
    public void canCheckRoomNoEnemy(){
        room2.addTreasure(treasure1);
        room2.addTreasure(treasure2);
        game.checkRoom(room2, knight1);
        assertEquals(2, knight1.getInventorySize());
        assertEquals(0, room2.getTreasureSize());
    }

    @Test
    public void hitterCanHit() {
        knight1.attack(enemy1);
        assertEquals(67, enemy1.getHealthPoints());
    }
    @Test
    public void hitterCanHitWithBothHands() {
        knight1.setRightHand(weapon);
        knight1.attack(enemy1);
        assertEquals(34, enemy1.getHealthPoints());
    }

    @Test
    public void healerCanHeal() {
        cleric1.heal(knight1);
        assertEquals(145, knight1.getHealthPoints());
    }
    @Test
    public void canFight(){
        game.addPlayer(knight1);
        game.addPlayer(cleric1);
        room1.addEnemy(enemy1);
        game.battle(room1);
        assertEquals(0, room1.getEnemyList().size());
    }

    @Test
    public void canRemoveDeadPlayer(){
        game.addPlayer(knight1);
        room1.addEnemy(enemy1);
        game.enemyTurn(room1);
        game.enemyTurn(room1);
        game.enemyTurn(room1);
        game.enemyTurn(room1);
        assertEquals(0, game.getPlayersSize());
    }

    @Test
    public void canLoopRoomsAndWin(){
        game.addPlayer(knight1);
        game.addPlayer(cleric1);
        game.addRoom(room1);
        room1.addEnemy(enemy1);
        game.addRoom(room2);
        room2.addEnemy(enemy2);
        game.addRoom(room3);
        room3.addEnemy(enemy1);
        room3.addEnemy(enemy2);
        game.exploreRoomsInDungeon();
        assertEquals(2, game.getPlayersSize());
    }

    @Test
    public void canLoopRoomsAndLose(){
        game.addPlayer(knight1);
        game.addRoom(room1);
        room1.addEnemy(enemy1);
        room1.addEnemy(enemy2);
        game.addRoom(room2);
        room2.addEnemy(enemy3);
        game.addRoom(room4);
        room4.addEnemy(enemy3);
        room4.addEnemy(enemy3);
        room4.addEnemy(enemy3);
        room4.addEnemy(enemy3);
        room4.addEnemy(enemy3);
        game.exploreRoomsInDungeon();
        assertEquals(0, game.getPlayersSize());
    }

    @Test
    public void canTakeEnemyLoot() {
        enemy3.addLoot(treasure1);
        room1.addEnemy(enemy3);
        knight1.attack(enemy3);
        knight1.attack(enemy3);
        game.checkForDead(knight1, room1.getEnemyList());
        assertEquals(1, knight1.getInventorySize());
    }

}
