import rooms.Treasure;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private ArrayList<Room> rooms;

    public Game(){
        this.players = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public int getPlayersSize(){
        return this.players.size();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public int getRoomsSize(){
        return this.rooms.size();
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public Player getPlayer(int index) {
        return this.players.get(index);
    }

    public void checkRoom(Room room, Player player) {
        if (room.getEnemy() == null) {
            for (Treasure treasure : room.getTreasureList()) {
                player.collectTreasure(treasure);
            }
            room.removeTreasure();
        } else {
            this.getTotals(room);
        }

//        room.setRoomComplete();
//        this.nextRoom();
    }
    public void getTotals(Room room) {

            int totalAttack = 0;
            int totalHealing = 0;
            int enemyAttackPower = 0;
            for (Player player : this.players ) {
                if (player.getCharacter().playerAction() > 0) {
                    totalAttack += player.getCharacter().playerAction();
                } else {
                    totalHealing += player.getCharacter().playerAction();
                }
            }
            enemyAttackPower += room.getEnemy().getAttackPoints();
            attackEnemy(totalAttack, room);
            playerDamage(enemyAttackPower);
            healPlayers(totalHealing);
            if(this.getPlayersSize() > 0 && room.getEnemy().getHealthPoints() < 1){
                room.setRoomComplete();
            } else if(this.getPlayersSize() == 0){
                this.loseGame();
            } else {
                this.getTotals(room);
            }
    }


    public void healPlayers(int totalHealing){
        for (Player player : this.players){
            int playerHealth = player.getHealth();
            player.setHealth(playerHealth + totalHealing);
        }
    }

    public void attackEnemy(int totalAttack, Room room){
        room.getEnemy().setHealthPoints(
                room.getEnemy().getHealthPoints() - totalAttack
        );
    }

    public void playerDamage(int damage){
        for(Player player : this.players){
            player.setHealth(player.getHealth() - damage);
            if (player.getHealth() <= 0) {
                this.players.remove(player);
            }
        }
    }

    public void loseGame(){
        System.out.println("YOU LOSE, LOSER");
    }




}
