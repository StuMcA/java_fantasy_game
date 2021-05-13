package characters;

import behaviours.IPlay;
import playerActions.HealingTool;

public class Clerics implements IPlay {

    private HealingTool healingTool;

    public Clerics(HealingTool healingTool){
        this.healingTool = healingTool;
    }

    public HealingTool getHealingTool() {
        return healingTool;
    }

    public void setHealingTool(HealingTool healingTool) {
        this.healingTool = healingTool;
    }

    public int playerAction() {
        int negPower = this.healingTool.getHealingPower();
        return -negPower;

    }
}
