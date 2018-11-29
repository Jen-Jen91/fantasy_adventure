package fantasy.room;

public class Enemy {
    private String species;
    private int strength;

    public Enemy(String species, int strength){
        this.species = species;
        this.strength = strength;
    }

    public String getSpecies(){
        return this.species;
    }

    public int getStrength(){
        return this.strength;
    }
}
