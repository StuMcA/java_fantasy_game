import behaviours.IStore;
import characters.GameCharacter;

import java.util.ArrayList;

public class Room {

    private String roomName;
    private ArrayList<IStore> treasureList;
    private ArrayList<GameCharacter> enemies;
    private boolean roomComplete;

    public Room(String roomName){
        this.roomName = roomName;
        this.treasureList = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.roomComplete = false;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getTreasureSize() {
        return this.treasureList.size();
    }

    public void addTreasure(IStore treasure) {
        this.treasureList.add(treasure);
    }

    public void removeTreasure(){
        this.treasureList.removeAll(this.treasureList);
    }

    public ArrayList<IStore> getTreasureList(){
        return this.treasureList;
    }

    public ArrayList<GameCharacter> getEnemyList() {
        return enemies;
    }

    public void addEnemy(GameCharacter enemy) {
        this.enemies.add(enemy);
    }

    public boolean isRoomComplete() {
        return roomComplete;
    }

    public void setRoomComplete() {
        this.roomComplete = true;
    }
}
