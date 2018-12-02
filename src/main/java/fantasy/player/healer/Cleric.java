package fantasy.player.healer;

public class Cleric extends Healer {

    private int holySymbol;

    public Cleric(int HP, int attack, int defence, ToolType tool) {
        super(HP, attack, defence, tool);
        this.holySymbol = 10;
    }

    public int getHolySymbol() {
        return this.holySymbol;
    }

    public void setHolySymbol(int holySymbol) {
        this.holySymbol = holySymbol;
    }

    public void holySymbolAddsDefence() {
        this.defence += this.holySymbol;
    }

}
