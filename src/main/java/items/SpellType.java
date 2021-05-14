package items;

public enum SpellType {
    HEALING (-1),
    ATTACKING (1),
    SUMMONING (0);

    private int damageMultiplier;

    SpellType(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }
}

