package playerActions;

public class Creature {

    private String type;
    private int healthPoints;

    public Creature(String type, int healthPoints){
        this.type = type;
        this.healthPoints = healthPoints;
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
}
