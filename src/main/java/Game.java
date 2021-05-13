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

    public void loopRooms() {
        for (Room room : this.rooms) {
            this.checkRoom(room, this.getPlayer(0));
        }
        System.out.println("You've won, woohoo!");
    }

    public void checkRoom(Room room, Player player) {
        System.out.println("You've entered " + room.getRoomName());
        if (room.getEnemy() == null) {
            for (Treasure treasure : room.getTreasureList()) {
                player.collectTreasure(treasure);
            }
            room.removeTreasure();
        } else {
            this.getTotals(room);
        }

    }
    public void getTotals(Room room) {
        System.out.println("In the room there is a " + room.getEnemy().getType());
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
            playerDamage(enemyAttackPower, room);
            healPlayers(totalHealing);
            if(this.getPlayersSize() > 0 && room.getEnemy().getHealthPoints() < 1){
                System.out.println("You killed it!");
                room.setRoomComplete();
            }  else {
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
        System.out.println("You did " + totalAttack + "damage");
    }

    public void playerDamage(int damage, Room room){
        for(Player player : this.players){
            player.setHealth(player.getHealth() - damage);
            System.out.println();
            if (player.getHealth() <= 0) {
                this.players.remove(player);
                System.out.println(player.getName() + " died");
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
