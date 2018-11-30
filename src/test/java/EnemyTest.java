import fantasy.room.Enemy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyTest {

    Enemy enemy;

    @Before
    public void before(){
        enemy = new Enemy(30, "Orc", 30, 20);
    }

    @Test
    public void hasHP(){
        assertEquals(30, enemy.getHP());
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

    @Test
    public void canSetHP() {
        enemy.setHP(20);
        assertEquals(20, enemy.getHP());
    }

}