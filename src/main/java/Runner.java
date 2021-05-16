import characters.*;
import items.*;

public class Runner {

    public static void main(String[] args) {
        Wizard wizard1 = new Wizard("Genevieve",Species.ELF, 80);
        Wizard wizard2 = new Wizard("Shanon",Species.DEMON, 100);
        Knight knight1 = new Knight("Janice", Species.HUMAN, 120);
        Knight knight2 = new Knight("Henri", Species.ELF, 90);
        Cleric cleric = new Cleric("Peter", Species.WEREWOLF, 80);
        Spell fireSpell = new Spell(SpellType.ATTACKING, 40, 1);
        Spell healingSpell = new Spell(SpellType.HEALING, 20, 1);
        Weapon sword = new Weapon(WeaponType.SWORD, 50, 1, 60);
        Weapon spear = new Weapon(WeaponType.SPEAR, 60, 1, 80);
        Weapon staff = new Weapon(WeaponType.STAFF, 15, 1, 90);
        Weapon mace = new Weapon(WeaponType.MACE, 60, 1, 80);
        HealingObject healingObject = new HealingObject("Witches Finger", 30, 20, 200);
        Enemy goblin1 = new Enemy("Butterfinger", Species.GOBLIN, 40);
        Enemy goblin2 = new Enemy("Chump", Species.GOBLIN, 60);
        Enemy goblin3 = new Enemy("Priti", Species.GOBLIN, 50);
        Enemy werewolf1 = new Enemy("Sternly", Species.WEREWOLF, 90);
        Enemy werewolf2 = new Enemy("Jake", Species.WEREWOLF, 100);
        Enemy werewolf3 = new Enemy("Snap", Species.WEREWOLF, 95);
        Enemy zombie1 = new Enemy("Snap", Species.ZOMBIE, 60);
        Enemy zombie2 = new Enemy("A massive ned", Species.ZOMBIE, 80);
        Enemy zombie3 = new Enemy("Ginger", Species.ZOMBIE, 70);
        Room room1 = new Room("Morningside Retirement Home");
        Room room2 = new Room("Meadow's Public Toilet");
        Room room3 = new Room("My kitchen");
        Game game = new Game();

        room1.addEnemy(goblin1);
        room1.addEnemy(zombie1);
        room2.addEnemy(werewolf1);
        room2.addEnemy(werewolf2);
        room2.addEnemy(goblin2);
        room3.addEnemy(goblin3);
        room3.addEnemy(zombie2);
        room3.addEnemy(zombie3);
        room3.addEnemy(werewolf3);

        game.addRoom(room1);
        game.addRoom(room2);
        game.addRoom(room3);

        wizard1.equipStaff(staff);
        wizard1.equipSpell(fireSpell);
        wizard2.equipSpell(healingSpell);

        cleric.equipHealingObject(healingObject);
        cleric.setLeftHand(mace);

        knight1.setLeftHand(sword);
        knight2.setRightHand(spear);

        game.addPlayer(knight1);
        game.addPlayer(knight2);
        game.addPlayer(cleric);
        game.addPlayer(wizard1);
        game.addPlayer(wizard2);

        game.exploreRoomsInDungeon();

    }
}
