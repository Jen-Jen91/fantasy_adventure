import fantasy.room.Enemy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyTest {
    Enemy enemy;

    @Before
    public void before(){
        enemy = new Enemy("Orc", 30);
    }
    @Test
    public void canGetSpecies(){
        assertEquals("Orc", enemy.getSpecies());
    }
    @Test
    public void canGetStrength(){
        assertEquals(30, enemy.getStrength());
    }
}
