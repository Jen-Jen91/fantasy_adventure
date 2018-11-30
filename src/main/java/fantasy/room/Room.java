package fantasy.room;

import fantasy.player.Player;
import java.util.ArrayList;

public class Room {

    private Treasure treasure;
    private ArrayList<Enemy> enemies;
    private ArrayList<Player> players;

    public Room(Treasure treasure) {
        this.treasure = treasure;
        this.enemies = new ArrayList<>();
        this.players = new ArrayList<>();
    }


    public Treasure getTreasure(){
        return this.treasure;
    }

    public int countEnemies(){
        return this.enemies.size();
    }

    public int countPlayers(){
        return this.players.size();
    }

    public void addEnemy(Enemy enemy){
        this.enemies.add(enemy);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void clearEnemies() {
        this.enemies.clear();
    }

    public void clearPlayers() {
        this.players.clear();
    }

}
