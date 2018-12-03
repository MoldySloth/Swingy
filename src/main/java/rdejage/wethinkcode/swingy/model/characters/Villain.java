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
    @NotNull
    protected boolean   status;

    public      Villain(String villainType, Integer xPos, Integer yPos, Integer attack, Integer armor, Integer hitPoints) {
        this.villainType = villainType;
        this.posX = xPos;
        this.posY = yPos;
        this.attack = attack;
        this.armor = armor;
        this.hitPoints = hitPoints;
        this.status = true;
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

    public boolean  takesDamage(Integer damage) {
        // use armor as a buff for damage
        damage -= armor;
        if(damage >= hitPoints) {
            // This villain dies
            this.hitPoints = 0;
            this.status = false;
            return false;
        } else {
            // villain takes damage update armor and hitPoints
            this.hitPoints -= damage;
            armor -= 25;
            return true;
        }
    }

    public boolean getStatus() {
        return status;
    }

    public Integer getAttack() { return attack; }

    public Integer getArmor() { return armor; }

    public Integer getHitPoints() { return hitPoints; }
}
