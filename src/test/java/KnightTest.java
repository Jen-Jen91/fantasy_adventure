import fantasy.player.fighter.Knight;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    Knight knight;
    Treasure treasure;
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;

    @Before
    public void before() {
        knight = new Knight(120, 60, "sword");
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy("Orc", 20);
        enemy2 = new Enemy("Ogre", 60);
        enemy3 = new Enemy("Werewolf", 90);
    }

    @Test
    public void hasHP() {
        assertEquals(120, knight.getHP());
    }

    @Test
    public void hasStrength() {
        assertEquals(60, knight.getStrength());
    }

    @Test
    public void hasEquipment() {
        assertEquals("sword", knight.getEquipment());
    }

    @Test
    public void startsWithNoTreasure() {
        assertEquals(0, knight.countTreasure());
    }

    @Test
    public void canAddTreasure() {
        knight.addTreasure(treasure);
        assertEquals(1, knight.countTreasure());
    }

    @Test
    public void canFightWin() {
        assertEquals("Player wins!", knight.fight(enemy1));
    }

    @Test
    public void canFightDraw() {
        assertEquals("It's a draw!", knight.fight(enemy2));
    }

    @Test
    public void canFightLose() {
        assertEquals("Enemy wins!", knight.fight(enemy3));
        assertEquals(90, knight.getHP());
    }


}
