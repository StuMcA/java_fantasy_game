import behaviours.ICast;
import behaviours.IHeal;
import behaviours.IStore;
import characters.Enemy;
import characters.GameCharacter;
import characters.Wizard;

import java.util.*;

public class Game {

    private ArrayList<GameCharacter> playerCharacters;
    private ArrayList<Room> rooms;
    private boolean gameOver;

    public Game() {
        this.playerCharacters = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.gameOver = false;
    }

    public int getPlayersSize() {
        return this.playerCharacters.size();
    }

    public void addPlayer(GameCharacter gameCharacter) {
        this.playerCharacters.add(gameCharacter);
    }

    public int getRoomsSize() {
        return this.rooms.size();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public GameCharacter getPlayer(int index) {
        return this.playerCharacters.get(index);
    }

    public void removePlayer(GameCharacter player) {
        this.playerCharacters.remove(player);
    }

    public ArrayList<GameCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

    public void exploreRoomsInDungeon() {
        for (Room room : this.rooms) {
            if (this.gameOver) {
                break;
            }
            this.checkRoom(room, this.getPlayer(0));
        }
        System.out.println(this.gameOver ? "" : "You've won, woohoo!");
    }

    public void checkRoom(Room room, GameCharacter gameCharacter) {
        System.out.println("-------------------------------------");
        System.out.println("You've entered " + room.getRoomName());
        if (room.getEnemyList().size() == 0) {
            this.lootTaken(gameCharacter, room.getTreasureList());
            room.removeTreasure();
        } else {
            System.out.println("There are " + room.getEnemyList().size() + " enemies:");
            for (GameCharacter enemy : room.getEnemyList()) {
                System.out.println(enemy.getName() + " the " + enemy.getSpecies().getSpeciesName() + ": " + enemy.getHealthPoints() + "HP");
            }
            System.out.println("-------------------------------------");
            this.battle(room);
        }

    }

    public int generateRandomTarget(ArrayList<GameCharacter> characterList) {
        Random target = new Random();
        return target.nextInt(characterList.size());
    }

    public GameCharacter findLowestHealthPlayer() {
        return Collections.min(this.getPlayerCharacters(), Comparator.comparing(GameCharacter::getHealthPoints));
    }



    public void fighterTurn(Room room) {
        for (GameCharacter fighter : playerCharacters) {
            if(room.getEnemyList().size() > 0) {
                GameCharacter targetEnemy = room.getEnemyList().get(generateRandomTarget(room.getEnemyList()));
                int damageDone = fighter.attack(targetEnemy);
                System.out.println(fighter.getName() + " hit " + targetEnemy.getName() + " for " + damageDone + " damage");
                this.checkForDead(fighter, room.getEnemyList());
            }
        }
    }

    public void spellCasterTurn(Room room) {
        for (GameCharacter gameCharacter : playerCharacters) {
            if(gameCharacter instanceof ICast) {
                GameCharacter target;
                if (!(((ICast) gameCharacter).getSpell() == null )) {
                    if(((ICast) gameCharacter).getSpell().getPower() < 0) {
                        target  = findLowestHealthPlayer();
                    } else {
                        target = room.getEnemyList().get((generateRandomTarget(room.getEnemyList())));
                    }
                    int spellPower = ((ICast) gameCharacter).castSpell(target);
                    System.out.println(gameCharacter.getName() + " cast a spell. it did " + spellPower + " damage.");
                }
            }
            this.checkForDead(gameCharacter, room.getEnemyList());
        }
    }

    public void enemyTurn(Room room) {
        for (GameCharacter enemy : room.getEnemyList()) {
            if (this.getPlayersSize() > 0) {
                GameCharacter targetPlayer = this.getPlayer(generateRandomTarget(this.getPlayerCharacters()));
                int damageDone = enemy.attack(targetPlayer);
                System.out.println(enemy.getName() + " attacked " + targetPlayer.getName() + ". It did " + damageDone + " damage.");
                this.checkForDead(enemy, this.getPlayerCharacters());
            }
        }
    }

    public void healerTurn() {
        for (GameCharacter player : playerCharacters) {
            if (player instanceof IHeal) {
                int healingDone = player.heal(findLowestHealthPlayer());
                System.out.println(player.getName() + " healed " + findLowestHealthPlayer().getName() + " " + healingDone + "HP");
            }
        }
    }

    public void summonerTurn() {
        for (GameCharacter player : playerCharacters) {
            if (player instanceof Wizard) {
                if (((Wizard) player).getFamiliar() == null) {
                    ((Wizard) player).summonFamiliar();
                }
            }
        }
    }


    public void checkForDead(GameCharacter attacker, ArrayList<GameCharacter> characterList) {
        for (GameCharacter gameCharacter : characterList)
            if (gameCharacter.getHealthPoints() <= 0) {
                gameCharacter.setDead();
                System.out.println(gameCharacter.getName() + " died");
                if (gameCharacter instanceof Enemy) {
                    Enemy enemy = (Enemy) gameCharacter;
                    this.lootTaken(attacker,  enemy.getLoot());
                    enemy.dropLoot();
                }
        }
        characterList.removeIf(GameCharacter::isDead);
    }

    public void lootTaken(GameCharacter player, ArrayList<IStore> loot) {
        for (IStore lootItem : loot) {
            player.addToInventory(lootItem);
            System.out.println(lootItem.getName() + " was found by " + player.getName());
        }
    }


    public void battleTurn(Room room) {
        if (room.getEnemyList().size() > 0) {
            this.fighterTurn(room);
        }
        if (room.getEnemyList().size() > 0) {
            this.spellCasterTurn(room);
        }
        this.enemyTurn(room);
        this.healerTurn();
        System.out.println("Press Enter to continue!");
        UserInputHandler scanner = new UserInputHandler();
        Scanner input = scanner.getScanner(System.in);
        input.nextLine();
        System.out.println("-------------------------------------");
    }

    public void battle(Room room) {
        this.summonerTurn();
        this.battleTurn(room);
        if(this.getPlayersSize() == 0) {
            this.loseGame(room);
        } else if(room.getEnemyList().size() == 0) {
            this.roomComplete(room);
        } else {
            this.battle(room);
        }
    }

    public void roomComplete(Room room) {
        room.setRoomComplete();
        System.out.println("You've survived " + room.getRoomName() + "!");
    }

    public void loseGame(Room room){
        System.out.println("YOU LOSE, YOU DIED IN " + room.getRoomName());
        this.gameOver = true;
    }



}
