package fantasy.player.spellcaster;

public enum SpellType {

    FIREBALL(40),
    LIGHTNING_STRIKE(50),
    ACID_ARROW(30),
    DISINTEGRATE(50),
    DRAGON_BREATH(20),
    ERUPTING_EARTH(10);

    private final int value;

    SpellType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
