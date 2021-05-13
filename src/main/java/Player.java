import behaviours.IPlay;
import rooms.Treasure;

import java.util.ArrayList;

public class Player {


    private String name;
    private int health;
    private IPlay character;
    private ArrayList<Treasure> treasureBag;

    public Player(String name, int health, IPlay character){
        this.name = name;
        this.health = health;
        this.character = character;
        this.treasureBag = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public IPlay getCharacter() {
        return character;
    }

    public void setCharacter(IPlay character) {
        this.character = character;
    }

    public void collectTreasure(Treasure treasure){
        this.treasureBag.add(treasure);
    }

    public int getTreasureBagSize(){
        return this.treasureBag.size();
    }
}
