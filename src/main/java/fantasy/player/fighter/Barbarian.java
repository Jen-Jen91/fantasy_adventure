package fantasy.player.fighter;

public class Barbarian extends Fighter {

    public Barbarian(int HP, int attack, int defence, WeaponType weapon) {
        super(HP, attack, defence, weapon);
    }

    public void berserk() {
        if (this.HP <= 10) {
            this.attack += 30;
        }
    }

}
