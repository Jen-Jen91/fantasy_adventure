import fantasy.player.Player;
import fantasy.player.fighter.Ranger;
import fantasy.player.fighter.WeaponType;
import fantasy.player.healer.Cleric;
import fantasy.player.healer.ToolType;
import fantasy.player.spellcaster.Creature;
import fantasy.player.spellcaster.SpellType;
import fantasy.player.spellcaster.Warlock;
import fantasy.room.Enemy;
import fantasy.room.Room;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room;
    Treasure treasure;
    Creature creature;
    Enemy enemy1;
    Enemy enemy2;
    Player player1;
    Player player2;
    Player player3;

    @Before
    public void before() {
        treasure = new Treasure("Gem", 100);
        creature = new Creature("cat", 10);
        enemy1 = new Enemy(20, "Orc", 50, 20);
        enemy2 = new Enemy(50, "Dragon", 100, 50);
        player1 = new Ranger(70, 40, 50, WeaponType.CROSSBOW);
        player2 = new Cleric(100, 20, 40, ToolType.POTION);
        player3 = new Warlock(50, 70, 20, SpellType.ACID_ARROW, creature);

        room = new Room(treasure);
    }

    @Test
    public void hasTreasure() {
        assertEquals(treasure, room.getTreasure());
    }

    @Test
    public void canHaveNoTreasure() {
        room = new Room(null);
        assertEquals(null, room.getTreasure());
    }

    @Test
    public void startsWithNoEnemies() {
        assertEquals(0, room.countEnemies());
    }

    @Test
    public void startsWithNoPlayers() {
        assertEquals(0, room.countPlayers());
    }

    @Test
    public void canAddEnemy() {
        room.addEnemy(enemy1);
        room.addEnemy(enemy2);
        assertEquals(2, room.countEnemies());
    }

    @Test
    public void canAddPlayer() {
        room.addPlayer(player1);
        room.addPlayer(player2);
        room.addPlayer(player3);
        assertEquals(3, room.countPlayers());
    }

    @Test
    public void canGetEnemies() {
        room.addEnemy(enemy1);
        room.addEnemy(enemy2);
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enemy1);
        enemies.add(enemy2);
        assertEquals(enemies, room.getEnemies());
    }

    @Test
    public void canGetPlayers() {
        room.addPlayer(player1);
        room.addPlayer(player2);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        assertEquals(players, room.getPlayers());
    }

    @Test
    public void canRemoveEnemies() {
        room.addEnemy(enemy1);
        room.addEnemy(enemy2);
        room.removeEnemy(enemy1);
        assertEquals(1, room.countEnemies());
    }

    @Test
    public void canRemovePlayers() {
        room.addPlayer(player1);
        room.addPlayer(player1);
        room.removePlayer(player1);
        assertEquals(1, room.countPlayers());
    }

    @Test
    public void canClearEnemies() {
        room.addEnemy(enemy1);
        room.addEnemy(enemy2);
        room.clearEnemies();
        assertEquals(0, room.countEnemies());
    }

    @Test
    public void canClearPlayers() {
        room.addPlayer(player1);
        room.addPlayer(player2);
        room.addPlayer(player3);
        room.clearPlayers();
        assertEquals(0, room.countPlayers());
    }

}
