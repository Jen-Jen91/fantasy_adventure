package fantasy.player.spellcaster;
import fantasy.interfaces.ICastSpell;
import fantasy.player.Player;
import fantasy.player.fighter.WeaponType;
import fantasy.room.Enemy;

public abstract class Spellcaster extends Player implements ICastSpell {

    protected SpellType spell;
    protected Creature creature;

    public Spellcaster(int HP, int strength, SpellType spell, Creature creature) {
        super(HP, strength);
        this.spell = spell;
        this.creature = creature;
    }

    public SpellType getSpell() {
        return this.spell;
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

    public void increaseStrength() {
        this.strength += this.spell.getValue();
    }
}
