import fantasy.player.spellcaster.Creature;
import fantasy.player.spellcaster.SpellType;
import fantasy.player.spellcaster.Wizard;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WizardTest {

    Wizard wizard;
    Creature creature1;
    Creature creature2;
    Treasure treasure;
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;

    @Before
    public void before() {
        creature1 = new Creature("Raven", 20);
        creature2 = new Creature("Dragon", 30);
        wizard = new Wizard(70, 50, 20, SpellType.LIGHTNING_STRIKE, creature1);
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy(20, "Orc", 20, 20);
        enemy2 = new Enemy(40, "Ogre", 50, 30);
        enemy3 = new Enemy(60, "Werewolf", 70, 40);
    }

    @Test
    public void hasHP() {
        assertEquals(70, wizard.getHP());
    }

    @Test
    public void hasAttack() {
        assertEquals(50, wizard.getAttack());
    }

    @Test
    public void hasDefence() {
        assertEquals(20, wizard.getDefence());
    }

    @Test
    public void hasSpell() {
        assertEquals(SpellType.LIGHTNING_STRIKE, wizard.getSpell());
    }

    @Test
    public void canChangeSpell() {
        wizard.setSpell(SpellType.ACID_ARROW);
        assertEquals(SpellType.ACID_ARROW, wizard.getSpell());
    }

    @Test
    public void hasCreature() {
        assertEquals(creature1, wizard.getCreature());
    }

    @Test
    public void canChangeCreature() {
        wizard.setCreature(creature2);
        assertEquals(creature2, wizard.getCreature());
    }

    @Test
    public void creatureCanAddDefence() {
        wizard.creatureAddsDefence();
        assertEquals(40, wizard.getDefence());
    }

    @Test
    public void startsWithNoTreasure() {
        assertEquals(0, wizard.countTreasure());
    }

    @Test
    public void canAddTreasure() {
        wizard.addTreasure(treasure);
        assertEquals(1, wizard.countTreasure());
    }

    @Test
    public void spellCanIncreaseAttack() {
        wizard.increaseAttack();
        assertEquals(100, wizard.getAttack());
    }

    @Test
    public void canCastSpellLowDamage() {
        assertEquals("Player dealt 10 damage", wizard.castSpell(enemy3));
    }

    @Test
    public void canCastSpellHighDamage() {
        assertEquals("Player dealt 30 damage", wizard.castSpell(enemy1));
    }

    @Test
    public void canHealSelf() {
        wizard.healSelf();
        assertEquals(90, wizard.getHP());
        assertEquals(30, wizard.getAttack());
    }

}
