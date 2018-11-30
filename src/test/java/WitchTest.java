import fantasy.player.spellcaster.Creature;
import fantasy.player.spellcaster.SpellType;
import fantasy.player.spellcaster.Witch;
import fantasy.room.Enemy;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WitchTest {

    Witch witch;
    Creature creature;
    Treasure treasure;
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;

    @Before
    public void before() {
        creature = new Creature("Cat", 10);
        witch = new Witch(70, 50, 20, SpellType.FIREBALL, creature);
        treasure = new Treasure("gold", 100);
        enemy1 = new Enemy(20, "Orc", 20, 10);
        enemy2 = new Enemy(30, "Ogre", 50, 40);
        enemy3 = new Enemy(50, "Werewolf", 70, 50);
    }

    @Test
    public void hasHP() {
        assertEquals(70, witch.getHP());
    }

    @Test
    public void hasAttack() {
        assertEquals(50, witch.getAttack());
    }

    @Test
    public void hasDefence() {
        assertEquals(20, witch.getDefence());
    }

    @Test
    public void hasEquipment() {
        assertEquals(SpellType.FIREBALL, witch.getSpell());
    }

    @Test
    public void hasCreature() {
        assertEquals(creature, witch.getCreature());
    }

    @Test
    public void creatureCanAddDefence() {
        witch.creatureAddsDefence();
        assertEquals(30, witch.getDefence());
    }

    @Test
    public void startsWithNoTreasure() {
        assertEquals(0, witch.countTreasure());
    }

    @Test
    public void canAddTreasure() {
        witch.addTreasure(treasure);
        assertEquals(1, witch.countTreasure());
    }

    @Test
    public void spellCanIncreaseAttack() {
        witch.increaseAttack();
        assertEquals(90, witch.getAttack());
    }

//    @Test
//    public void canCastSpellWin() {
//        assertEquals("Player wins!", witch.castSpell(enemy1));
//    }
//
//    @Test
//    public void canCastSpellDraw() {
//        assertEquals("It's a draw!", witch.castSpell(enemy2));
//    }
//
//    @Test
//    public void canCastSpellLose() {
//        assertEquals("Enemy wins!", witch.castSpell(enemy3));
//        assertEquals(50, witch.getHP());
//    }

    @Test
    public void canCastSpellLowDamage() {
        assertEquals("Player dealt 10 damage", witch.castSpell(enemy3));
    }

    @Test
    public void canCastSpellHighDamage() {
        assertEquals("Player dealt 40 damage", witch.castSpell(enemy1));
    }

}
