package characters;

public enum Species  {
    DWARF (0.9, 1.1, 1.0),
    ELF (1.1, 1.0, 0.9),
    HUMAN (1.0, 1.0, 1.0),
    GOBLIN (1.0, 1.0, 1.0);

    private double healthMultiplier;
    private double damageMultiplier;
    private double defenseMultiplier;

    Species(double healthMultiplier, double damageMultiplier, double defenseMultiplier) {
        this.healthMultiplier = healthMultiplier;
        this.damageMultiplier = damageMultiplier;
        this.defenseMultiplier = defenseMultiplier;
    }
}
