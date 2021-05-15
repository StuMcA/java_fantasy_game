package items;

import behaviours.IWield;

public class Weapon extends Item {

    private WeaponType weaponType;
    private int damage;
    private int speed;

    public Weapon(WeaponType weaponType, int damage, int speed, int value) {
        super(value);
        this.weaponType = weaponType;
        this.damage = damage;
        this.speed = speed;
    }

    public String getName() {
        return weaponType.getName();
    }

    public int getPower() {
        return this.damage;
    }
}
