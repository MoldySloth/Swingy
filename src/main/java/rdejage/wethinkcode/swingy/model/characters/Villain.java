package rdejage.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotNull;

public class Villain {
    @NotNull
    protected Integer   posX;
    @NotNull
    protected Integer   posY;
    @NotNull
    protected String    villainType;
    @NotNull
    protected Integer   attack;
    @NotNull
    protected Integer   armor;
    @NotNull
    protected Integer   hitPoints;

    public      Villain(String villainType, Integer xPos, Integer yPos, Integer attack, Integer armor, Integer hitPoints) {
        this.villainType = villainType;
        this.posX = xPos;
        this.posY = yPos;
        this.attack = attack;
        this.armor = armor;
        this.hitPoints = hitPoints;
    }

    public Integer getPosX() {
        return posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public String getVillainType() {
        return villainType;
    }

    public String getInfo() {
        String  info = "";
        info += this.villainType + " has appeared!\n";
        info += "Showing no mercy your enemy has...\n";
        info += "an attack of " + this.attack + ", armor " + this.armor + ", hit points " + this.hitPoints;
        return info;
    }
}
