import fantasy.player.spellcaster.Creature;
import fantasy.player.spellcaster.SpellType;
import fantasy.player.spellcaster.Warlock;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WarlockTest {

    Warlock warlock;
    Creature creature1;
    Creature creature2;
    Treasure treasure;
    Enemy enemy1;
    Enemy enemy2;

    @Before
    public void before() {
        creature1 = new Creature("Cat", 10);
        creature2 = new Creature("Dragon", 30);
        warlock = new Warlock(70, 50, 20, SpellType.FIREBALL, creature1);
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy(20, "Orc", 20, 10);
        enemy2 = new Enemy(50, "Werewolf", 70, 50);
    }

    @Test
    public void hasHP() {
        assertEquals(70, warlock.getHP());
    }

    @Test
    public void hasAttack() {
        assertEquals(50, warlock.getAttack());
    }

    @Test
    public void hasDefence() {
        assertEquals(20, warlock.getDefence());
    }

    @Test
    public void hasSpell() {
        assertEquals(SpellType.FIREBALL, warlock.getSpell());
    }

    @Test
    public void canChangeSpell() {
        warlock.setSpell(SpellType.ACID_ARROW);
        assertEquals(SpellType.ACID_ARROW, warlock.getSpell());
    }

    @Test
    public void hasCreature() {
        assertEquals(creature1, warlock.getCreature());
    }

    @Test
    public void canChangeCreature() {
        warlock.setCreature(creature2);
        assertEquals(creature2, warlock.getCreature());
    }

    @Test
    public void creatureCanAddDefence() {
        warlock.creatureAddsDefence();
        assertEquals(30, warlock.getDefence());
    }

    @Test
    public void startsWithNoTreasure() {
        assertEquals(0, warlock.countTreasure());
    }

    @Test
    public void canAddTreasure() {
        warlock.addTreasure(treasure);
        assertEquals(1, warlock.countTreasure());
    }

    @Test
    public void spellCanIncreaseAttack() {
        warlock.increaseAttack();
        assertEquals(90, warlock.getAttack());
    }

    @Test
    public void canCastSpellLowDamage() {
        assertEquals("Player dealt 10 damage", warlock.castSpell(enemy2));
    }

    @Test
    public void canCastSpellHighDamage() {
        assertEquals("Player dealt 40 damage", warlock.castSpell(enemy1));
    }

    @Test
    public void canSacrificeHealthToAddAttack() {
        warlock.sacrificeHealth();
        assertEquals(50, warlock.getHP());
        assertEquals(70, warlock.getAttack());
    }

}
