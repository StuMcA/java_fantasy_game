package items;

public enum SpellType {
    HEALING ("Heal", -1),
    ATTACKING ("Attack", 1),
    SUMMONING ("Summon", 0);

    private String type;
    private int damageMultiplier;

    SpellType(String type, int damageMultiplier) {
        this.type = type;
        this.damageMultiplier = damageMultiplier;
    }

    public String getType() {
        return this.type;
    }

    public int getSpellMultiplier() {
        return this.damageMultiplier;
    }
}

