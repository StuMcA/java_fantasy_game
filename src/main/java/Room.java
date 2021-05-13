import characters.Enemy;
import rooms.Treasure;

import java.util.ArrayList;

public class Room {

    private String roomName;
    private ArrayList<Treasure> treasureList;
    private Enemy enemy;
    private boolean roomComplete;

    public Room(String roomName, Enemy enemy){
        this.roomName = roomName;
        this.treasureList = new ArrayList<>();
        this.enemy = enemy;
        this.roomComplete = false;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getTreasureSize() {
        return this.treasureList.size();
    }

    public void addTreasure(Treasure treasure) {
        this.treasureList.add(treasure);
    }

    public void removeTreasure(){
        this.treasureList.removeAll(this.treasureList);
    }

    public ArrayList<Treasure> getTreasureList(){
        return this.treasureList;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public boolean isRoomComplete() {
        return roomComplete;
    }

    public void setRoomComplete() {
        this.roomComplete = true;
    }
}
