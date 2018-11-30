package fantasy.room;

public class Enemy {

    private String species;
    private int attack;
    private int defence;

    public Enemy(String species, int attack, int defence) {
        this.species = species;
        this.attack = attack;
        this.defence = defence;
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

}
