package characters;

public enum Species  {
    DWARF ("Dwarf", 0.9, 1.1, 1.0),
    ELF ("Elf", 1.1, 1.0, 0.9),
    HUMAN ("Human", 1.0, 1.0, 1.0),
    GOBLIN ("Goblin", 1.0, 1.0, 1.0),
    WEREWOLF ("Werewolf", 1.3, 1.4, 1.1),
    ZOMBIE ("Zombie", 0.4, 0.3, 0.6),
    DEMON ("Demon", 1.5, 1.5, 0.7);

    private final String speciesName;
    private final double healthMultiplier;
    private final double damageMultiplier;
    private final double defenseMultiplier;

    Species(String speciesName, double healthMultiplier, double damageMultiplier, double defenseMultiplier) {
        this.speciesName = speciesName;
        this.healthMultiplier = healthMultiplier;
        this.damageMultiplier = damageMultiplier;
        this.defenseMultiplier = defenseMultiplier;
    }

    public String getSpeciesName() {
        return this.speciesName;
    }

    public double getHealthMultiplier() {
        return healthMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public double getDefenseMultiplier() {
        return defenseMultiplier;
    }
}
