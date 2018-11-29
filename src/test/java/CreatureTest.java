import fantasy.player.spellcaster.Creature;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreatureTest {

    Creature creature;

    @Before
    public void before() {
        creature = new Creature("Dragon", 10);
    }

    @Test
    public void hasSpecies() {
        assertEquals("Dragon", creature.getSpecies());
    }

    @Test
    public void hasDefence() {
        assertEquals(10, creature.getDefence());
    }

}
