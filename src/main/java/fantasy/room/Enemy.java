package fantasy.room;

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

}
