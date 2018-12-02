import fantasy.Fantasy;
import fantasy.player.Player;
import fantasy.player.fighter.Dwarf;
import fantasy.player.fighter.WeaponType;
import fantasy.player.healer.Cleric;
import fantasy.player.healer.ToolType;
import fantasy.player.spellcaster.Creature;
import fantasy.player.spellcaster.SpellType;
import fantasy.player.spellcaster.Wizard;
import fantasy.room.Enemy;
import fantasy.room.Room;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FantasyTest {

    Fantasy fantasy;
    Room room;
    Treasure treasure;
    Enemy enemy;
    Creature creature;
    Player player1;
    Player player2;
    Player player3;

    @Before
    public void before() {
        fantasy = new Fantasy();
        treasure = new Treasure("Gem", 150);
        enemy = new Enemy(20, "Orc", 20, 20);
        room = new Room(treasure);
        creature = new Creature("Raven", 20);
        player1 = new Dwarf(50, 60, 40, WeaponType.AXE);
        player2 = new Cleric(60, 20, 50, ToolType.POTION);
        player3 = new Wizard(60, 20, 50, SpellType.FIREBALL, creature);
    }

    @Test
    public void startsWithNoRooms() {
        assertEquals(0, fantasy.countRooms());
    }

    @Test
    public void startsWithNoPlayers() {
        assertEquals(0, fantasy.countPlayers());
    }

    @Test
    public void canAddPlayers() {
        fantasy.createPlayer(player1);
        fantasy.createPlayer(player2);
        assertEquals(2, fantasy.countPlayers());
    }

    @Test
    public void canAddRooms() {
        fantasy.createRoom(room);
        assertEquals(1, fantasy.countRooms());
    }

    @Test
    public void canAddPlayerToRoom() {
        fantasy.createRoom(room);
        fantasy.createPlayer(player1);
        fantasy.createPlayer(player2);
        fantasy.createPlayer(player3);
        fantasy.addPlayersToRoom();
        assertEquals(3, room.countPlayers());
    }

    @Test
    public void canCheckForTreasure() {
        assertEquals(true, fantasy.checkRoomForTreasure(room));
    }

    @Test
    public void canPickUpTreasure() {
        fantasy.createPlayer(player1);
        fantasy.createPlayer(player2);
        fantasy.createRoom(room);
        fantasy.addPlayersToRoom();
        assertEquals("You picked up Gem", fantasy.pickUpTreasure(room));
        assertEquals(1, player1.countTreasure());
        assertEquals(1, player2.countTreasure());
    }

    @Test
    public void canCheckForEnemies() {
        room.addEnemy(enemy);
        assertEquals(true, fantasy.checkRoomForEnemies(room));
    }


}


