package fantasy;
import fantasy.player.Player;
import fantasy.room.Room;
import fantasy.room.Treasure;
import java.util.ArrayList;

public class Fantasy {

    private ArrayList<Player> players;
    private ArrayList<Room> rooms;

    public Fantasy() {
        this.players = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }


    public int countPlayers() {
        return this.players.size();
    }

    public int countRooms() {
        return this.rooms.size();
    }

    public void createPlayer(Player player) {
        this.players.add(player);
    }

    public void createRoom(Room room) {
        this.rooms.add(room);
    }

    public void addPlayersToRoom() {
        Room room = this.rooms.remove(0);
        for (Player player : this.players) {
            room.addPlayer(player);
        }
    }

    public boolean checkRoomForTreasure(Room room) {
       if (room.getTreasure() != null) {
           return true;
       }
       return false;
    }


    public String pickUpTreasure(Room room) {
        if (checkRoomForTreasure(room)) {
            Treasure treasure = room.getTreasure();

            for (Player player : this.players) {
                player.addTreasure(treasure);
            }

            room.clearPlayers();
            return "You picked up " + treasure.getType();
        }
        return "Sorry, no treasure for you!";
    }


    public boolean checkRoomForEnemies(Room room) {
        if (room.countEnemies() != 0) {
            return true;
        }
        return false;
    }



}

