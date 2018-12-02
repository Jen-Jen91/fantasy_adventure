package fantasy.player.spellcaster;

public class Wizard extends Spellcaster {

    public Wizard(int HP, int attack, int defence, SpellType spell, Creature creature) {
        super(HP, attack, defence, spell, creature);
    }

    public void healSelf() {
        this.attack -= 20;
        this.HP += 20;
    }

}
