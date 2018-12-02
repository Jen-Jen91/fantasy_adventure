package fantasy.player.spellcaster;
import fantasy.interfaces.ICastSpell;
import fantasy.player.Player;
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

    public void setSpell(SpellType spell) {
        this.spell = spell;
    }

    public Creature getCreature() {
        return this.creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public void creatureAddsDefence() {
        this.defence += this.creature.getDefence();
    }

    public void increaseAttack() {
        this.attack += this.spell.getValue();
    }

//    public String castSpell(Enemy enemy) {
//        if (this.attack > enemy.getAttack()) {
//            return "Player wins!";
//        } else if (this.attack < enemy.getAttack()) {
//            int difference = enemy.getAttack() - this.attack;
//            this.HP -= difference;
//            return "Enemy wins!";
//        }
//        return "It's a draw!";
//    }

    public String castSpell(Enemy enemy) {
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
