import fantasy.player.spellcaster.Creature;
import fantasy.player.spellcaster.Witch;
import fantasy.player.spellcaster.Wizard;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

        Wizard wizard;
        Creature creature;
        Treasure treasure;
        Enemy enemy1;
        Enemy enemy2;
        Enemy enemy3;

        @Before
        public void before() {
            creature = new Creature("Raven", 20);
            wizard = new Wizard(70, 50, "staff", creature);
            treasure = new Treasure("gold", 100);
            enemy1 = new Enemy("Orc", 20);
            enemy2 = new Enemy("Ogre", 50);
            enemy3 = new Enemy("Werewolf", 70);
        }
    @Test
    public void hasHP() {
        assertEquals(70, wizard.getHP());
    }

    @Test
    public void hasStrength() {
        assertEquals(50, wizard.getStrength());
    }

    @Test
    public void hasEquipment() {
        assertEquals("staff", wizard.getEquipment());
    }

    @Test
    public void hasCreature() {
        assertEquals(creature, wizard.getCreature());
    }
    @Test
    public void creatureCanAddStrength() {
        wizard.creatureAddsStrength();
        assertEquals(70, wizard.getStrength());
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
    public void canCastSpellWin() {
        assertEquals("Player wins!", wizard.castSpell(enemy1));
    }

    @Test
    public void canCastSpellDraw() {
        assertEquals("It's a draw!", wizard.castSpell(enemy2));
    }

    @Test
    public void canCastSpellLose() {
        assertEquals("Enemy wins!", wizard.castSpell(enemy3));
        assertEquals(50, wizard.getHP());
    }

}
