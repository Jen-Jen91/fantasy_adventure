import fantasy.Fantasy;
import fantasy.player.Player;
import fantasy.player.fighter.Ranger;
import fantasy.player.fighter.Fighter;
import fantasy.player.fighter.WeaponType;
import fantasy.player.healer.Cleric;
import fantasy.player.healer.ToolType;
import fantasy.player.spellcaster.Creature;
import fantasy.player.spellcaster.SpellType;
import fantasy.player.spellcaster.Spellcaster;
import fantasy.player.spellcaster.Wizard;
import fantasy.room.Enemy;
import fantasy.room.Room;
import fantasy.room.Treasure;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        player1 = new Ranger(50, 30, 40, WeaponType.CROSSBOW);
        player2 = new Cleric(60, 20, 50, ToolType.POTION);
        player3 = new Wizard(60, 20, 50, SpellType.FIREBALL, creature);

        fantasy.createRoom(room);
        fantasy.createPlayer(player1);
        fantasy.createPlayer(player2);
        fantasy.createPlayer(player3);
    }

    @Test
    public void canCountRooms() {
        assertEquals(1, fantasy.countRooms());
    }

    @Test
    public void canCountPlayers() {
        assertEquals(3, fantasy.countPlayers());
    }

    @Test
    public void canAddPlayers() {
        fantasy.createPlayer(player1);
        assertEquals(4, fantasy.countPlayers());
    }

    @Test
    public void canAddRooms() {
        fantasy.createRoom(room);
        assertEquals(2, fantasy.countRooms());
    }

    @Test
    public void canCheckRoomsAvailable() {
        fantasy.createRoom(room);
        assertEquals(true, fantasy.checkRoomsAvailable());
    }

    @Test
    public void canAddPlayerToRoom() {
        fantasy.addPlayersToRoom();
        assertEquals(3, room.countPlayers());
    }

    @Test
    public void canCompleteQuest() {
        fantasy.addPlayersToRoom();
        assertEquals("Congratulations! You have completed your quest", fantasy.completeQuest());
    }

    @Test
    public void canCheckForTreasure() {
        assertTrue(fantasy.checkRoomForTreasure(room));
    }

    @Test
    public void canPickUpTreasure() {
        fantasy.addPlayersToRoom();
        assertEquals("You picked up Gem", fantasy.pickUpTreasure(room));
        assertEquals(1, player1.countTreasure());
        assertEquals(1, player2.countTreasure());
        assertEquals(1, player3.countTreasure());
    }

    @Test
    public void canCheckForEnemies() {
        room.addEnemy(enemy);
        assertTrue(fantasy.checkRoomForEnemies(room));
    }

    @Test
    public void enemiesCanAttack() {
        room.addEnemy(enemy);
        fantasy.enemiesAttack(room, player1);
        assertEquals(40, player1.getHP());
    }

    @Test
    public void fightersCanAttack() {
        room.addEnemy(enemy);
        fantasy.fightersAttack((Fighter) player1, room);
        assertEquals(10, enemy.getHP());
    }

    @Test
    public void spellcastersCanAttack() {
        room.addEnemy(enemy);
        fantasy.spellcastersAttack((Spellcaster) player3, room);
        assertEquals(10, enemy.getHP());
    }

    @Test
    public void clericsCanHeal() {
        room.addPlayer(player1);
        room.addPlayer(player3);
        fantasy.clericsHeal((Cleric) player2, room);
        assertEquals(100, player1.getHP());
        assertEquals(110, player3.getHP());
    }

    @Test
    public void canCheckEnemyHP() {
        room.addEnemy(enemy);
        assertEquals("Enemy still has HP", fantasy.checkEnemyHP(room));
    }

    @Test
    public void canCheckEnemyDead() {
        room.addEnemy(enemy);
        enemy.setHP(0);
        assertEquals("Enemy is dead", fantasy.checkEnemyHP(room));
        assertEquals(0, room.countEnemies());
    }

    @Test
    public void canCheckPlayerHP() {
        room.addPlayer(player1);
        assertEquals("Player still has HP", fantasy.checkPlayerHP(room));
    }

    @Test
    public void canCheckPlayerDead() {
        room.addPlayer(player1);
        player1.setHP(0);
        assertEquals("Player is dead", fantasy.checkPlayerHP(room));
        assertEquals(0, room.countPlayers());
    }

//    @Test
//    public void canFightEnemies() {
//        room.addEnemy(enemy);
//        room.addPlayer(player1);
//        fantasy.fightEnemies(room);
//        assertEquals(0, room.countEnemies());
//    }

}


