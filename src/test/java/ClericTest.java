import fantasy.player.Player;
import fantasy.player.fighter.Dwarf;
import fantasy.player.fighter.WeaponType;
import fantasy.player.healer.Cleric;
import fantasy.player.healer.ToolType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    Cleric cleric;
    Player player;

    @Before
    public void before() {
        cleric = new Cleric(100, 10, ToolType.POTION);
        player = new Dwarf(20, 30, WeaponType.AXE);

    }

    @Test
    public void hasHP() {
        assertEquals(100, cleric.getHP());
    }

    @Test
    public void hasStrength() {
        assertEquals(10, cleric.getStrength());
    }

    @Test
    public void hasEquipment() {
        assertEquals(ToolType.POTION, cleric.getTool());
    }

    @Test
    public void canSetHP() {
        cleric.setHP(15);
        assertEquals(15, cleric.getHP());
    }

    @Test
    public void canHeal() {
        cleric.heal(player);
        assertEquals(70, player.getHP());
    }

}
