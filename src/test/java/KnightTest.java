import fantasy.player.fighter.Knight;
import fantasy.player.fighter.WeaponType;
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
        knight = new Knight(120, 60, 30, WeaponType.SWORD);
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy(20, "Orc", 20, 10);
        enemy2 = new Enemy(30, "Ogre", 60, 30);
        enemy3 = new Enemy(60, "Werewolf", 90, 50);
    }

    @Test
    public void hasHP() {
        assertEquals(120, knight.getHP());
    }

    @Test
    public void hasAttack() {
        assertEquals(60, knight.getAttack());
    }

    @Test
    public void hasDefence() {
        assertEquals(30, knight.getDefence());
    }

    @Test
    public void hasWeapong() {
        assertEquals(WeaponType.SWORD, knight.getWeapon());
    }

    @Test
    public void canChangeWeapon() {
        knight.setWeapon(WeaponType.AXE);
        assertEquals(WeaponType.AXE, knight.getWeapon());
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
    public void weaponCanIncreaseAttack() {
        knight.increaseAttack();
        assertEquals(100, knight.getAttack());
    }

//    @Test
//    public void canFightWin() {
//        assertEquals("Player wins!", knight.fight(enemy1));
//    }
//
//    @Test
//    public void canFightDraw() {
//        assertEquals("It's a draw!", knight.fight(enemy2));
//    }
//
//    @Test
//    public void canFightLose() {
//        assertEquals("Enemy wins!", knight.fight(enemy3));
//        assertEquals(90, knight.getHP());
//    }

    @Test
    public void canFightLowDamage() {
        assertEquals("Player dealt 10 damage", knight.fight(enemy3));
    }

    @Test
    public void canFightHighDamage() {
        assertEquals("Player dealt 50 damage", knight.fight(enemy1));
    }

}
