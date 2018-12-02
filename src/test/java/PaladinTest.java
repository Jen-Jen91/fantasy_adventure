import fantasy.player.fighter.Paladin;
import fantasy.player.fighter.WeaponType;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PaladinTest {

    Paladin paladin;
    Treasure treasure;
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;

    @Before
    public void before() {
        paladin = new Paladin(120, 60, 30, WeaponType.SWORD);
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy(20, "Orc", 20, 10);
        enemy2 = new Enemy(30, "Ogre", 60, 30);
        enemy3 = new Enemy(60, "Werewolf", 90, 50);
    }

    @Test
    public void hasHP() {
        assertEquals(120, paladin.getHP());
    }

    @Test
    public void hasAttack() {
        assertEquals(60, paladin.getAttack());
    }

    @Test
    public void hasDefence() {
        assertEquals(30, paladin.getDefence());
    }

    @Test
    public void hasWeapon() {
        assertEquals(WeaponType.SWORD, paladin.getWeapon());
    }

    @Test
    public void hasArmour() {
        assertEquals(10, paladin.getArmour());
    }

    @Test
    public void canChangeArmour() {
        paladin.setArmour(15);
        assertEquals(15, paladin.getArmour());
    }

    @Test
    public void armourIncreasesDefence() {
        paladin.armourAddsDefence();
        assertEquals(40, paladin.getDefence());
    }

    @Test
    public void canChangeWeapon() {
        paladin.setWeapon(WeaponType.AXE);
        assertEquals(WeaponType.AXE, paladin.getWeapon());
    }

    @Test
    public void startsWithNoTreasure() {
        assertEquals(0, paladin.countTreasure());
    }

    @Test
    public void canAddTreasure() {
        paladin.addTreasure(treasure);
        assertEquals(1, paladin.countTreasure());
    }

    @Test
    public void weaponCanIncreaseAttack() {
        paladin.increaseAttack();
        assertEquals(100, paladin.getAttack());
    }

    @Test
    public void canFightLowDamage() {
        assertEquals("Player dealt 10 damage", paladin.fight(enemy3));
    }

    @Test
    public void canFightHighDamage() {
        assertEquals("Player dealt 50 damage", paladin.fight(enemy1));
    }

}
