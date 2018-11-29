package fantasy.player.healer;

import fantasy.interfaces.IHeal;
import fantasy.player.Player;

public abstract class Healer extends Player implements IHeal {
    public Healer(int HP, int strength, String equipment){
        super(HP, strength, equipment);
    }

    public String heal(Player player){
        int HP = player.getHP();
        int newHP = HP + 5;
        player.setHP(newHP);
        return "Player has been healed!";
    }

}
