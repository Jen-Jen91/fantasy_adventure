import fantasy.Fantasy;
import fantasy.player.Player;
import fantasy.player.fighter.Dwarf;
import fantasy.player.fighter.WeaponType;
import fantasy.room.Room;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FantasyTest {

    Fantasy fantasy;
    Room room;
    Treasure treasure;
    Player player;

    @Before
    public void before() {
        fantasy = new Fantasy();
        treasure = new Treasure("Gem", 150);
        room = new Room(treasure);
        player = new Dwarf(50, 60, 40, WeaponType.AXE);

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
        fantasy.createPlayer(player);
        assertEquals(1, fantasy.countPlayers());
    }

    @Test
    public void canAddRooms() {
        fantasy.createRoom(room);
        assertEquals(1, fantasy.countRooms());
    }

    @Test
    public void canAddPlayerToRoom() {
        fantasy.createRoom(room);
        fantasy.createPlayer(player);
        fantasy.addPlayersToRoom();
        assertEquals(1, room.countPlayers());
    }

    @Test
    public void canCheckForTreasure() {
        fantasy.createPlayer(player);
        fantasy.createRoom(room);
        fantasy.addPlayersToRoom();
        assertEquals("You picked up Gem", fantasy.checkRoomForTreasure(room, player));
        assertEquals(1, player.countTreasure());
    }

}


