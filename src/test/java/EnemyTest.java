import fantasy.room.Enemy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyTest {

    Enemy enemy;

    @Before
    public void before(){
        enemy = new Enemy("Orc", 30, 20);
    }

    @Test
    public void hasSpecies(){
        assertEquals("Orc", enemy.getSpecies());
    }

    @Test
    public void hasAttack(){
        assertEquals(30, enemy.getAttack());
    }

    @Test
    public void hasDefence(){
        assertEquals(20, enemy.getDefence());
    }

}