package fantasy;
import fantasy.player.Player;
import fantasy.player.fighter.Fighter;
import fantasy.player.healer.Cleric;
import fantasy.player.spellcaster.Spellcaster;
import fantasy.room.Enemy;
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

    public boolean checkRoomsAvailable() {
        if (this.rooms.size() > 0) {
            return true;
        }
        return false;
    }

    public String completeQuest() {
        if (!checkRoomsAvailable()) {
            return "Congratulations! You have completed your quest";
        }
        return "Your journey continues...";
    }

    public void addPlayersToRoom() {
        if (checkRoomsAvailable()) {
            Room room = this.rooms.remove(0);
            for (Player player : this.players) {
                room.addPlayer(player);
            }
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

    public void enemiesAttack(Room room, Player player) {
        for (Enemy enemy : room.getEnemies()) {
            enemy.fight(player);
        }
    }

    public void fightersAttack(Fighter fighter, Room room) {
        for (Enemy enemy : room.getEnemies()) {
            fighter.fight(enemy);
        }
    }

    public void spellcastersAttack(Spellcaster spellcaster, Room room) {
        for (Enemy enemy : room.getEnemies()) {
            spellcaster.castSpell(enemy);
        }
    }

    public void clericsHeal(Cleric cleric, Room room) {
        for (Player player : room.getPlayers()) {
            cleric.heal(player);
        }
    }

    public String checkEnemyHP(Room room) {
        for (Enemy enemy : room.getEnemies()) {
            if (enemy.getHP() <= 0) {
                room.removeEnemy(enemy);
                return "Enemy is dead";
            }
        }
        return "Enemy still has HP";
    }

    public String checkPlayerHP(Room room) {
        for (Player player : room.getPlayers()) {
            if (player.getHP() <= 0) {
                room.removePlayer(player);
                return "Player is dead";
            }
        }
        return "Player still has HP";
    }


//    public void fightEnemies(Room room) {
//        if (checkRoomForEnemies(room)) {
//
//            while (room.countEnemies() > 0 && room.countPlayers() > 0) {
//                for (Player player : this.players) {
//                    if (player instanceof Fighter) {
//                        Fighter fighter = (Fighter) player;
//                        fightersAttack(fighter, room);
//                    } else if (player instanceof Spellcaster) {
//                        Spellcaster spellcaster = (Spellcaster) player;
//                        spellcastersAttack(spellcaster, room);
//                    } else if (player instanceof Cleric) {
//                        Cleric cleric = (Cleric) player;
//                        clericsHeal(cleric, room);
//                    }
//                    checkEnemyHP(room);
//                    enemiesAttack(room, player);
//                    checkPlayerHP(room);
//                }
//            }
//        }
//    }

}

