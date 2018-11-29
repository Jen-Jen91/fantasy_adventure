import fantasy.player.fighter.Barbarian;
import fantasy.player.fighter.Dwarf;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {
    Barbarian barbarian;
    Treasure treasure;
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;

    @Before
    public void before() {
        barbarian = new Barbarian(100, 50, "club");
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy("Orc", 20);
        enemy2 = new Enemy("Ogre", 50);
        enemy3 = new Enemy("Werewolf", 140);
    }

    @Test
    public void hasHP() {
        assertEquals(100, barbarian.getHP());
    }

    @Test
    public void hasStrength() {
        assertEquals(50, barbarian.getStrength());
    }

    @Test
    public void hasEquipment() {
        assertEquals("club", barbarian.getEquipment());
    }

    @Test
    public void startsWithNoTreasure() {
        assertEquals(0, barbarian.countTreasure());
    }

    @Test
    public void canAddTreasure() {
        barbarian.addTreasure(treasure);
        assertEquals(1, barbarian.countTreasure());
    }
    @Test
    public void canFightWin() {
        assertEquals("Player wins!", barbarian.fight(enemy1));
    }

    @Test
    public void canFightDraw() {
        assertEquals("It's a draw!", barbarian.fight(enemy2));
    }

    @Test
    public void canFightLose() {
        assertEquals("Enemy wins!", barbarian.fight(enemy3));
        assertEquals(10, barbarian.getHP());
    }

}

