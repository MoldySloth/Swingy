package rdejage.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.artifacts.Weapon;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Character {
    @NotNull
    public String       name;
    @NotNull
    public String       type;
    @NotNull
    protected Integer   attack_base;
    @NotNull
    protected Integer   armor_base;
    @NotNull
    protected Integer   hitPoints_base;
    protected Integer   exp;
    protected Integer   level;
    protected Weapon    weapon;
    protected Artifact  artifact;
    protected Integer   posX;
    protected Integer   posY;
    protected boolean   status;

    public Character(String name, String type, Integer attack, Integer armor, Integer hitPoints) {
        this.name = name;
        this.type = type;
        this.exp = 0;
        this.level = 1;
        this.attack_base = attack;
        this.armor_base = armor;
        this.hitPoints_base = hitPoints;
        this.weapon = null;
        this.artifact = null;
        this.status = true;
    }

    public Character(String name, String type, Integer level, Integer experience, String weapon, String artifact) {
        this.name = name;
        this.type = type;
        this.exp = 0;
        this.level = 1;
//        this.attack_base = attack;
//        this.armor_base = armor;
//        this.hitPoints_base = hitPoints;
        this.weapon = null;
        this.artifact = null;
        this.status = true;

        // Get the weapon type from string
        System.out.println("The following weapon was found " + weapon);

        // Get the artifact type from string
        System.out.println("The following artifact was was found " + artifact);
    }

    public void     moveCharacter(Integer direction) {
        switch (direction) {
            case 1:
                // move up
                System.out.println("Moving player North");
                setPosY(posY - 1);
                break;
            case 2:
                // move right
                System.out.println("Moving player East");
                setPosX(posX + 1);
                break;
            case 3:
                // move down
                System.out.println("Moving player South");
                setPosY(posY + 1);
                break;
            case 4:
                // move left
                System.out.println("Moving player West");
                setPosX(posX - 1);
                break;
            default:
                break;
        }
    }

    public String   getInfo() {
        // Some hard coded info
        String weapon = "Plastic sword";
        String artifact = "Cardboard box";
        String  info = "";
        info += this.name + " the " + this.type + "," + this.level + "," + this.exp + "," + weapon + "," + artifact;
        return info;
    }

    public Integer  getBaseAttack() {
        return this.attack_base;
    }

    public Integer  getBaseArmor() {
        return this.armor_base;
    }

    public Integer  getBaseHitPoints() {
        return this.hitPoints_base;
    }

    public Integer  getLevel() {
        return this.level;
    }

    public Integer getPosX() {
        return this.posX;
    }

    public Integer getPosY() {
        return this.posY;
    }

    public boolean  getStatus() {
        return status;
    }

    public void     setPosition(Integer mapSize) {
        setPosX(mapSize/2);
        setPosY(mapSize/2);
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }
}
