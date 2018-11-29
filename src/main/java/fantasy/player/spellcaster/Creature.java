package fantasy.player.spellcaster;

public class Creature {

    private String species;
    private int defence;

    public Creature(String species, int defence) {
        this.species = species;
        this.defence = defence;
    }

    public String getSpecies() {
        return this.species;
    }

    public int getDefence() {
        return this.defence;
    }
}
