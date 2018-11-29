import fantasy.player.fighter.Dwarf;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DwarfTest {

    Dwarf dwarf;
    Treasure treasure;
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;

    @Before
    public void before() {
        dwarf = new Dwarf(50, 30, "axe");
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy("Orc", 20);
        enemy2 = new Enemy("Ogre", 30);
        enemy3 = new Enemy("Werewolf", 40);
    }

    @Test
    public void hasHP() {
        assertEquals(50, dwarf.getHP());
    }

    @Test
    public void hasStrength() {
        assertEquals(30, dwarf.getStrength());
    }

    @Test
    public void hasEquipment() {
        assertEquals("axe", dwarf.getEquipment());
    }

    @Test
    public void startsWithNoTreasure() {
        assertEquals(0, dwarf.countTreasure());
    }

    @Test
    public void canAddTreasure() {
        dwarf.addTreasure(treasure);
        assertEquals(1, dwarf.countTreasure());
    }

    @Test
    public void canFightWin() {
        assertEquals("Player wins!", dwarf.fight(enemy1));
    }

    @Test
    public void canFightDraw() {
        assertEquals("It's a draw!", dwarf.fight(enemy2));
    }

    @Test
    public void canFightLose() {
        assertEquals("Enemy wins!", dwarf.fight(enemy3));
        assertEquals(40, dwarf.getHP());
    }

}
