package characters;

import items.Treasure;

public class Enemy {

    private String type;
    private int healthPoints;
    private int attackPoints;
    private Treasure treasure;

    public Enemy(String type, int healthPoints, int attackPoints, Treasure treasure) {
        this.type = type;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.treasure = treasure;
    }

}
