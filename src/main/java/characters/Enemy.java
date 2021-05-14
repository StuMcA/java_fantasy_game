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


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }
}
