package fantasy.player.fighter;
import fantasy.interfaces.IFight;
import fantasy.player.Player;
import fantasy.room.Enemy;

public abstract class Fighter extends Player implements IFight {

    protected WeaponType weapon;

    public Fighter(int HP, int attack, int defence, WeaponType weapon) {
        super(HP, attack, defence);
        this.weapon = weapon;
    }

    public WeaponType getWeapon() {
        return this.weapon;
    }

    public void setWeapon(WeaponType weapon) {
        this.weapon = weapon;
    }

    public void increaseAttack() {
        this.attack += this.weapon.getValue();
    }

    public String fight(Enemy enemy) {
        int difference = this.attack - enemy.getDefence();
        int enemyHP = enemy.getHP();

        if (difference <= 0) {
            enemy.setHP(enemyHP - 10);
            return "Player dealt 10 damage";
        } else {
            enemy.setHP(enemyHP - difference);
            return "Player dealt " + difference + " damage";
        }
    }

}
