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

    public void increaseAttack() {
        this.attack += this.weapon.getValue();
    }

    public String fight(Enemy enemy) {
        if (this.attack > enemy.getAttack()) {
            return "Player wins!";
        } else if (this.attack < enemy.getAttack()) {
            int difference = enemy.getAttack() - this.attack;
            this.HP -= difference;
            return "Enemy wins!";
        }
        return "It's a draw!";
    }


}
