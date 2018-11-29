package rdejage.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import rdejage.wethinkcode.swingy.model.artifacts.Armor;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.artifacts.Weapon;

import javax.validation.constraints.NotNull;
import java.io.*;

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
    }

    public Character(String name, String type, Integer level, Integer experience, String weapon, String artifact) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.exp = experience;

        // Get the weapon type from string
        System.out.println("The following weapon was found " + weapon);

        // Get the artifact type from string
        System.out.println("The following artifact was was found " + artifact);
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
}
