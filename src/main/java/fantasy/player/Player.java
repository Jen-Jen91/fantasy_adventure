package fantasy.player;

import fantasy.room.Treasure;

import java.util.ArrayList;

public abstract class Player {

    protected int HP;
    protected int strength;
    protected String equipment;
    protected ArrayList<Treasure> treasure;

    public Player(int HP, int strength, String equipment) {
        this.HP = HP;
        this.strength = strength;
        this.equipment = equipment;
        this.treasure = new ArrayList<>();
    }

    public int getHP(){
        return this.HP;
    }

    public int getStrength(){
        return this.strength;
    }

    public String getEquipment(){
        return this.equipment;
    }

    public int countTreasure(){
        return this.treasure.size();
    }

    public void addTreasure(Treasure treasure){ this.treasure.add(treasure);
    }


    public void setHP(int newHP){
        this.HP = newHP;
    }
}
