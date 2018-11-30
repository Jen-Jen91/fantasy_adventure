package fantasy.player.healer;
import fantasy.interfaces.IHeal;
import fantasy.player.Player;
import fantasy.player.fighter.WeaponType;

public abstract class Healer extends Player implements IHeal {

    protected ToolType tool;

    public Healer(int HP, int attack, int defence, ToolType tool) {
        super(HP, attack, defence);
        this.tool = tool;
    }

    public String heal(Player player) {
        int HP = player.getHP();
        int newHP = HP + this.tool.getValue();
        player.setHP(newHP);
        return "Player has been healed!";
    }

    public ToolType getTool() {
        return this.tool;
    }

}
