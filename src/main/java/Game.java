import behaviours.IHeal;
import behaviours.IStore;
import characters.GameCharacter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private ArrayList<GameCharacter> playerCharacters;
    private ArrayList<Room> rooms;
    private boolean gameOver;

    public Game(){
        this.playerCharacters = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.gameOver = false;
    }

    public int getPlayersSize(){
        return this.playerCharacters.size();
    }

    public void addPlayer(GameCharacter gameCharacter){
        this.playerCharacters.add(gameCharacter);
    }

    public int getRoomsSize(){
        return this.rooms.size();
    }

    public void addRoom(Room room){
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

        public void loopRooms() {
        for (Room room : this.rooms) {
            if (this.gameOver) {
                break;
            }
            this.checkRoom(room, this.getPlayer(0));
        }
         System.out.println(this.gameOver ? "" : "You've won, woohoo!");
    }

    public void checkRoom(Room room, GameCharacter gameCharacter) {
        System.out.println("You've entered " + room.getRoomName());
        if (room.getEnemyList().size() == 0) {
            for (IStore treasure : room.getTreasureList()) {
                gameCharacter.addToInventory(treasure);
                System.out.println("You picked up " + treasure.getName() + " worth £" + treasure.getValue());
            }
            room.removeTreasure();
        } else {
            this.battle(room);
        }

    }

    public int generateRandomTarget(ArrayList<GameCharacter> characterList) {
        Random target = new Random();
        return target.nextInt(characterList.size());
    }

    public GameCharacter findLowestHealthPlayer() {
        for (int i=1 ; i < this.getPlayersSize()-1; i++) {
            GameCharacter playerSort1 = this.getPlayer(i);
            GameCharacter playerSort2 = this.getPlayer(i+1);
            if (playerSort1.getHealthPoints() > playerSort2.getHealthPoints()) {
                this.removePlayer(playerSort1);
                this.addPlayer(playerSort1);
            }
        }
        return this.getPlayer(0);
    }

    public void fighterTurn(Room room) {

        for (GameCharacter fighter : playerCharacters) {
            if(room.getEnemyList().size() > 0) {
                GameCharacter targetEnemy = room.getEnemyList().get(generateRandomTarget(room.getEnemyList()));
                int damageDone = fighter.attack(targetEnemy);
                System.out.println(fighter.getName() + " hit " + targetEnemy.getName() + " for " + damageDone + " damage");
                this.checkForDead(room.getEnemyList());
            }
        }
    }

    public void enemyTurn(Room room) {
        for (GameCharacter enemy : room.getEnemyList()) {
            if (this.getPlayersSize() > 0) {
                GameCharacter targetPlayer = this.getPlayer(generateRandomTarget(this.getPlayerCharacters()));
                int damageDone = enemy.attack(targetPlayer);
                System.out.println(enemy.getName() + " attacked " + targetPlayer.getName() + ". It did " + damageDone + " damage.");
                this.checkForDead(this.getPlayerCharacters());
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

    public void checkForDead(ArrayList<GameCharacter> characterList) {
        for (GameCharacter gameCharacter : characterList)
            if (gameCharacter.getHealthPoints() <= 0) {
                gameCharacter.setDead();
                System.out.println(gameCharacter.getName() + " died");
        }
        characterList.removeIf(GameCharacter::isDead);
    }

    public void battleTurn(Room room) {
        this.fighterTurn(room);
        this.enemyTurn(room);
        this.healerTurn();
        System.out.println("Press Enter to continue!");
        UserInputHandler scanner = new UserInputHandler();
        Scanner input = scanner.getScanner(System.in);
//        input.nextLine();
    }

    public void battle(Room room) {
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
