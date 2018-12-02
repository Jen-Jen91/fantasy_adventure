package fantasy.player.fighter;

public class Paladin extends Fighter {

    private int armour;

    public Paladin(int HP, int attack, int defence, WeaponType weapon) {
        super(HP, attack, defence, weapon);
        this.armour = 10;
    }

    public int getArmour() {
        return this.armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public void armourAddsDefence() {
        this.defence += this.armour;
    }
}
