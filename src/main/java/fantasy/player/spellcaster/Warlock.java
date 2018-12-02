package fantasy.player.spellcaster;

public class Warlock extends Spellcaster {

    public Warlock(int HP, int attack, int defence, SpellType spell, Creature creature) {
        super(HP, attack, defence, spell, creature);
    }

    public void sacrificeHealth() {
        this.HP -= 20;
        this.attack += 20;
    }

}
