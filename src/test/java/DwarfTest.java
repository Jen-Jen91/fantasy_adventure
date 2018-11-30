import fantasy.player.fighter.Dwarf;
import fantasy.player.fighter.WeaponType;
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
        dwarf = new Dwarf(50, 30, 60, WeaponType.AXE);
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy("Orc", 20, 10);
        enemy2 = new Enemy("Ogre", 30, 20);
        enemy3 = new Enemy("Werewolf", 40, 30);
    }

    @Test
    public void hasHP() {
        assertEquals(50, dwarf.getHP());
    }

    @Test
    public void hasAttack() {
        assertEquals(30, dwarf.getAttack());
    }

    @Test
    public void hasDefence() {
        assertEquals(60, dwarf.getDefence());
    }

    @Test
    public void hasEquipment() {
        assertEquals(WeaponType.AXE, dwarf.getWeapon());
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

    @Test
    public void weaponCanIncreaseAttack() {
        dwarf.increaseAttack();
        assertEquals(80, dwarf.getAttack());
    }

}
