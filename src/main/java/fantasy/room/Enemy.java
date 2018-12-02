package fantasy.room;
import fantasy.player.Player;

public class Enemy {

    private int HP;
    private String species;
    private int attack;
    private int defence;

    public Enemy(int HP, String species, int attack, int defence) {
        this.HP = HP;
        this.species = species;
        this.attack = attack;
        this.defence = defence;
    }

    public int getHP() {
        return this.HP;
    }

    public String getSpecies() {
        return this.species;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefence() {
        return this.defence;
    }

    public void setHP(int newHP) {
        this.HP = newHP;
    }

    public String fight(Player player) {
        int difference = this.attack - player.getDefence();
        int playerHP = player.getHP();

        if (difference <= 0) {
            player.setHP(playerHP - 10);
            return "Enemy dealt 10 damage";
        } else {
            player.setHP(playerHP - difference);
            return "Enemy dealt " + difference + " damage";
        }
    }

}
