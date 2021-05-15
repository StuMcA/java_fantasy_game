package items;

public enum WeaponType {
    SWORD ("Sword"),
    MACE ("Mace"),
    SPEAR ("Spear"),
    BOW ("Bow"),
    STAFF ("Staff");

    private final String name;

    WeaponType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
