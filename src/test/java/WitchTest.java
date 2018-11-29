import fantasy.player.spellcaster.Creature;
import fantasy.player.spellcaster.Witch;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WitchTest {

    Witch witch;
    Creature creature;
    Treasure treasure;
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;

    @Before
    public void before() {
        creature = new Creature("Cat", 10);
        witch = new Witch(70, 50, "wand", creature);
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy("Orc", 20);
        enemy2 = new Enemy("Ogre", 50);
        enemy3 = new Enemy("Werewolf", 70);
    }

    @Test
    public void hasHP() {
        assertEquals(70, witch.getHP());
    }

    @Test
    public void hasStrength() {
        assertEquals(50, witch.getStrength());
    }

    @Test
    public void hasEquipment() {
        assertEquals("wand", witch.getEquipment());
    }

    @Test
    public void hasCreature() {
        assertEquals(creature, witch.getCreature());
    }

    @Test
    public void creatureCanAddStrength() {
        witch.creatureAddsStrength();
        assertEquals(60, witch.getStrength());
    }

    @Test
    public void startsWithNoTreasure() {
        assertEquals(0, witch.countTreasure());
    }

    @Test
    public void canAddTreasure() {
        witch.addTreasure(treasure);
        assertEquals(1, witch.countTreasure());
    }

    @Test
    public void canCastSpellWin() {
        assertEquals("Player wins!", witch.castSpell(enemy1));
    }

    @Test
    public void canCastSpellDraw() {
        assertEquals("It's a draw!", witch.castSpell(enemy2));
    }

    @Test
    public void canCastSpellLose() {
        assertEquals("Enemy wins!", witch.castSpell(enemy3));
        assertEquals(50, witch.getHP());
    }

}
