import fantasy.player.fighter.Ranger;
import fantasy.player.fighter.WeaponType;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RangerTest {

    Ranger ranger;
    Treasure treasure;
    Enemy enemy1;
    Enemy enemy2;

    @Before
    public void before() {
        ranger = new Ranger(50, 30, 30, WeaponType.CROSSBOW);
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy(20, "Orc", 20, 10);
        enemy2 = new Enemy(50, "Werewolf", 40, 30);
    }

    @Test
    public void hasHP() {
        assertEquals(50, ranger.getHP());
    }

    @Test
    public void hasAttack() {
        assertEquals(30, ranger.getAttack());
    }

    @Test
    public void hasDefence() {
        assertEquals(30, ranger.getDefence());
    }

    @Test
    public void hasWeapon() {
        assertEquals(WeaponType.CROSSBOW, ranger.getWeapon());
    }

    @Test
    public void canChangeWeapon() {
        ranger.setWeapon(WeaponType.CLUB);
        assertEquals(WeaponType.CLUB, ranger.getWeapon());
    }

    @Test
    public void startsWithNoTreasure() {
        assertEquals(0, ranger.countTreasure());
    }

    @Test
    public void canAddTreasure() {
        ranger.addTreasure(treasure);
        assertEquals(1, ranger.countTreasure());
    }

    @Test
    public void weaponCanIncreaseAttack() {
        ranger.increaseAttack();
        assertEquals(70, ranger.getAttack());
    }

    @Test
    public void canFightLowDamage() {
        assertEquals("Player dealt 10 damage", ranger.fight(enemy2));
    }

    @Test
    public void canFightHighDamage() {
        assertEquals("Player dealt 20 damage", ranger.fight(enemy1));
    }

    @Test
    public void canUsePoisonArrow() {
        ranger.poisonArrow();
        assertEquals(40, ranger.getAttack());
    }

}
