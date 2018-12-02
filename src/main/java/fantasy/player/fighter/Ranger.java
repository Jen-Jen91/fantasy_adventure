package fantasy.player.fighter;

public class Ranger extends Fighter{

    public Ranger(int HP, int attack, int defence, WeaponType weapon) {
        super(HP, attack, defence, weapon);
    }

    public void poisonArrow() {
        if (this.weapon == WeaponType.CROSSBOW) {
            this.attack += 10;
        }
    }

}
