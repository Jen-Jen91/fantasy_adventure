package fantasy.player.spellcaster;

import fantasy.interfaces.ICastSpell;
import fantasy.player.Player;
import fantasy.room.Enemy;

public abstract class Spellcaster extends Player implements ICastSpell {

    protected Creature creature;

    public Spellcaster(int HP, int strength, String equipment, Creature creature) {
        super(HP, strength, equipment);
        this.creature = creature;
    }

    public Creature getCreature() {
        return this.creature;
    }

    public void creatureAddsStrength() {
        this.strength += this.creature.getDefence();
    }

    public String castSpell(Enemy enemy) {
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
