package fantasy.player;
import fantasy.room.Treasure;
import java.util.ArrayList;

public abstract class Player {

    protected int HP;
    protected int attack;
    protected int defence;
    protected ArrayList<Treasure> treasure;

    public Player(int HP, int attack, int defence) {
        this.HP = HP;
        this.attack = attack;
        this.defence = defence;
        this.treasure = new ArrayList<>();
    }

    public int getHP() {
        return this.HP;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefence() {
        return this.defence;
    }

    public int countTreasure() {
        return this.treasure.size();
    }

    public void addTreasure(Treasure treasure) {
        this.treasure.add(treasure);
    }

    public void setHP(int newHP) {
        this.HP = newHP;
    }
}
