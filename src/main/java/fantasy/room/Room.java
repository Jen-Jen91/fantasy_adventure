package fantasy.room;

import fantasy.player.Player;
import java.util.ArrayList;

public class Room {

    private ArrayList<Enemy> enemies;
    private ArrayList<Player> players;
    private Treasure treasure;

    public Room(Treasure treasure){
        this.enemies = new ArrayList<>();
        this.players = new ArrayList<>();
        this.treasure = treasure;
    }

    public int countEnemies(){
        return this.enemies.size();
    }

    public void addEnemy(Enemy enemy){
        this.enemies.add(enemy);
    }

    public Treasure getTreasure(){
        return this.treasure;
    }

    public int countPlayers(){
        return this.players.size();
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
