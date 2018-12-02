import fantasy.player.Player;
import fantasy.player.fighter.Ranger;
import fantasy.player.fighter.WeaponType;
import fantasy.player.healer.Cleric;
import fantasy.player.healer.ToolType;
import fantasy.room.Enemy;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EnemyTest {

    Enemy enemy;
    Player player1;
    Player player2;

    @Before
    public void before(){
        enemy = new Enemy(30, "Orc", 30, 20);
        player1 = new Ranger(60, 60, 50, WeaponType.AXE);
        player2 = new Cleric(50, 20, 20, ToolType.HERBS);
    }

    @Test
    public void hasHP(){
        assertEquals(30, enemy.getHP());
    }

    @Test
    public void hasSpecies(){
        assertEquals("Orc", enemy.getSpecies());
    }

    @Test
    public void hasAttack(){
        assertEquals(30, enemy.getAttack());
    }

    @Test
    public void hasDefence(){
        assertEquals(20, enemy.getDefence());
    }

    @Test
    public void canSetHP() {
        enemy.setHP(20);
        assertEquals(20, enemy.getHP());
    }

    @Test
    public void canFightLowDamage() {
        assertEquals("Enemy dealt 10 damage", enemy.fight(player1));
    }

    @Test
    public void canFightHighDamage() {
        assertEquals("Enemy dealt 10 damage", enemy.fight(player2));
    }


}