package fantasy.player.spellcaster;
import fantasy.interfaces.ICastSpell;
import fantasy.player.Player;
import fantasy.player.fighter.WeaponType;
import fantasy.room.Enemy;

public abstract class Spellcaster extends Player implements ICastSpell {

    protected SpellType spell;
    protected Creature creature;

    public Spellcaster(int HP, int attack, int defence, SpellType spell, Creature creature) {
        super(HP, attack, defence);
        this.spell = spell;
        this.creature = creature;
    }

    public SpellType getSpell() {
        return this.spell;
    }

    public Creature getCreature() {
        return this.creature;
    }

    public void creatureAddsDefence() {
        this.defence += this.creature.getDefence();
    }

    public String castSpell(Enemy enemy) {
        if (this.attack > enemy.getAttack()) {
            return "Player wins!";
        } else if (this.attack < enemy.getAttack()) {
            int difference = enemy.getAttack() - this.attack;
            this.HP -= difference;
            return "Enemy wins!";
        }
        return "It's a draw!";
    }

    public void increaseAttack() {
        this.attack += this.spell.getValue();
    }
}
