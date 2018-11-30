package fantasy.player.healer;

public enum ToolType {

    POTION(50),
    HERBS(30),
    BANDAGE(10);

    private final int value;

    ToolType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
