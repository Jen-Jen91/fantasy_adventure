package fantasy.player.fighter;

import fantasy.interfaces.IFight;
import fantasy.player.Player;
import fantasy.room.Enemy;

public abstract class Fighter extends Player implements IFight {

    public Fighter(int HP, int strength, String equipment) {
        super(HP, strength, equipment);
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

}
