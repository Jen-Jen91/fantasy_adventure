package fantasy.player.fighter;

public enum WeaponType {

    AXE(50),
    CLUB(30),
    SWORD(40),
    MACE(40),
    DAGGER(10),
    SPEAR(20);

    private final int value;

    WeaponType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
