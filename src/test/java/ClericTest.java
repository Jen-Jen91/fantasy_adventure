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
        cleric = new Cleric(100, 10, 60, ToolType.POTION);
        player = new Dwarf(20, 30, 50, WeaponType.AXE);

    }

    @Test
    public void hasHP() {
        assertEquals(100, cleric.getHP());
    }

    @Test
    public void hasAttack() {
        assertEquals(10, cleric.getAttack());
    }

    @Test
    public void hasDefence() {
        assertEquals(60, cleric.getDefence());
    }

    @Test
    public void hasTool() {
        assertEquals(ToolType.POTION, cleric.getTool());
    }

    @Test
    public void canChangeTool() {
        cleric.setTool(ToolType.HERBS);
        assertEquals(ToolType.HERBS, cleric.getTool());
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
