import behaviours.IStore;
import characters.GameCharacter;

import java.util.ArrayList;

public class Game {

    private ArrayList<GameCharacter> playerCharacters;
    private ArrayList<Room> rooms;

    public Game(){
        this.playerCharacters = new ArrayList<>();
        this.rooms = new ArrayList<>();
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

//    public void loopRooms() {
//        for (Room room : this.rooms) {
//            this.checkRoom(room, this.getPlayer(0));
//        }
//        System.out.println("You've won, woohoo!");
//    }

    public void checkRoom(Room room, GameCharacter gameCharacter) {
        System.out.println("You've entered " + room.getRoomName());
        if (room.getEnemyList().size() == 0) {
            for (IStore treasure : room.getTreasureList()) {
                gameCharacter.addToInventory(treasure);
            }
            room.removeTreasure();
        } else {
//            this.getTotals(room);
        }

    }
//    public void getTotals(Room room) {
//        System.out.println("In the room there is a " + room.getEnemyList().get(0).getSpecies().getSpeciesName());
//            int totalAttack = 0;
//            int totalHealing = 0;
//            int enemyAttackPower = 0;
//            for (GameCharacter playerCharacter : this.playerCharacters) {
//                if (playerCharacter.getCharacter().playerAction() > 0) {
//                    totalAttack += playerCharacter.getCharacter().playerAction();
//                } else {
//                    totalHealing += playerCharacter.getCharacter().playerAction();
//                }
//            }
//            enemyAttackPower += room.getEnemy().getAttackPoints();
//            attackEnemy(totalAttack, room);
//            playerDamage(enemyAttackPower, room);
//            healPlayers(totalHealing);
//            if(this.getPlayersSize() > 0 && room.getEnemy().getHealthPoints() < 1){
//                System.out.println("You killed it!");
//                room.setRoomComplete();
//            }  else {
//                this.getTotals(room);
//            }
//    }


//    public void healPlayers(int totalHealing){
//        for (GameCharacter gameCharacter : this.playerCharacters){
//            int playerHealth = gameCharacter.getHealthPoints();
//            gameCharacter.setHealthPoints(playerHealth + totalHealing);
//        }
//    }

//    public void attackEnemy(int totalAttack, Room room){
//        room.getEnemy().setHealthPoints(
//                room.getEnemy().getHealthPoints() - totalAttack
//        );
//        System.out.println("You did " + totalAttack + "damage");
//    }

    public void playerDamage(int damage, Room room){
        for(GameCharacter gameCharacter : this.playerCharacters){
            gameCharacter.setHealthPoints(gameCharacter.getHealthPoints() - damage);
            System.out.println();
            if (gameCharacter.getHealthPoints() <= 0) {
                this.playerCharacters.remove(gameCharacter);
                System.out.println(gameCharacter.getName() + " died");
            }
            if (this.getPlayersSize() == 0){
                this.loseGame(room);
            }
        }
    }

    public void loseGame(Room room){
        System.out.println("YOU LOSE, YOU DIED IN " + room.getRoomName());
        System.exit(0);
    }



}
