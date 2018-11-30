package fantasy.player.fighter;
import fantasy.interfaces.IFight;
import fantasy.player.Player;
import fantasy.room.Enemy;

public abstract class Fighter extends Player implements IFight {

    protected WeaponType weapon;

    public Fighter(int HP, int strength, WeaponType weapon) {
        super(HP, strength);
        this.weapon = weapon;
    }

    public String fight(Enemy enemy) {
        if (this.strength > enemy.getStrength()) {
            return "Player wins!";
        } else if (this.strength < enemy.getStrength()) {
            int difference = enemy.getStrength() - this.strength;
            this.HP -= difference;
            return "Enemy wins!";
        }
        return "It's a draw!";
    }

    public WeaponType getWeapon() {
        return this.weapon;
    }

    public void increaseStrength() {
        this.strength += this.weapon.getValue();
    }

}
