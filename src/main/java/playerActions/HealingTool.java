package playerActions;

public class HealingTool {

    private String type;
    private int healingPower;

    public HealingTool(String type, int healingPower){
        this.type = type;
        this.healingPower = healingPower;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }
}
