package rdejage.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.artifacts.ArtifactFactory;

import javax.validation.constraints.NotNull;
import java.util.Random;

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
    protected Artifact  weapon;
    protected Artifact  artifact;
    protected Integer   posX;
    protected Integer   posY;
    protected Integer[] previousPos = new Integer[2];
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

    public Character(String name, String type, Integer level, Integer experience, String weapon, String artifact, String buffType) {
        this.name = name;
        this.type = type;
        this.exp = experience;
        this.level = level;

        // Get game type and then get base values
        switch(type) {
            case "Paladin":
                this.attack_base = 100;
                this.armor_base = 150;
                this.hitPoints_base = 150;
                break;
            case "Bruser":
                this.attack_base = 100;
                this.armor_base = 250;
                this.hitPoints_base = 100;
                break;
            case "Necromancer":
                this.attack_base = 50;
                this.armor_base = 150;
                this.hitPoints_base = 150;
                break;
            case "Slayer":
                this.attack_base = 150;
                this.armor_base = 100;
                this.hitPoints_base = 50;
                break;
            default:
                break;
        }

        // Get the weapon type from string
        if(!weapon.equals("null")) {
            this.weapon = ArtifactFactory.buildArtifact(weapon, "Weapon");
        } else {
            this.weapon = null;
        }

        // Get the artifact type from string
        if(!artifact.equals("null")) {
            if(buffType.equals("Helm")) {
                this.weapon = ArtifactFactory.buildArtifact(weapon, "Helm");
            } else if(buffType.equals("Armor")) {
                this.weapon = ArtifactFactory.buildArtifact(weapon, "Armor");
            }
        } else {
            this.artifact = null;
        }

        this.status = true;
    }

    public void     moveCharacter(Integer direction) {
        setPreviousPos();
        switch (direction) {
            case 1:
                // move up
                setPosY(posY - 1);
                break;
            case 2:
                // move right
                setPosX(posX + 1);
                break;
            case 3:
                // move down
                setPosY(posY + 1);
                break;
            case 4:
                // move left
                setPosX(posX - 1);
                break;
            default:
                break;
        }
    }

    public boolean     takesDamage(Integer damage) {
        // use armor as a buff for damage
        Integer     trueDamage = damage - getAromr();
        if(trueDamage >= getHitPoints()) {
            // This villain dies
            this.hitPoints_base = 0;
            this.status = false;
            return false;
        } else {
            // villain takes damage update armor and hitPoints
            this.hitPoints_base = getHitPoints() - damage;
            this.armor_base -= 50;
            return true;
        }
    }

    public boolean  run() {
        Random      rand = new Random();
        int         n = rand.nextInt(2);
        if(n == 1) {
            setPosX(this.previousPos[0]);
            setPosY(this.previousPos[1]);
            return true;
        }
        return false;
    }

    public void     addItem(Artifact item) {
        // check if Item can be added, drop item if needed
        if(item.getBuffType().equals("Weapon")) {
            this.weapon = item;
        } else {
            this.artifact = item;
        }
    }

    public String   getInfo() {
        String  info = "";
        String  weaponName = "none";
        String  artifactName = "none";
        String  artifactType = "none";
        if(weapon != null) {
            weaponName = weapon.getArtifactName();
        }

        if(artifact != null) {
            artifactName = artifact.getArtifactName();
            artifactType = artifact.getBuffType();
        }

        info += this.name + " the " + this.type + "," + this.level + "," + this.exp + "," + weaponName + "," + artifactName + "," + artifactType;
        return info;
    }

    public String getName() { return name; }

    public Integer  getAttack() {
        // return attack value based on weapon and base attack
        if(weapon != null) {
            return this.attack_base + weapon.getBuffValue();
        }
        return this.attack_base;
    }

    public Integer  getAromr() {
        // return attack value based on weapon and base attack
        if(artifact != null) {
            if(artifact.getBuffType().equals("Armor")) {
                return this.armor_base + artifact.getBuffValue();
            }
        }
        return this.armor_base;
    }

    public Integer  getHitPoints() {
        // return attack value based on weapon and base attack
        if(artifact != null) {
            if(artifact.getBuffType().equals("Helm")) {
                return this.hitPoints_base + artifact.getBuffValue();
            }

        }
        return this.hitPoints_base;
    }

    public Integer  getLevel() {
        return this.level;
    }

    public Integer  getPosX() {
        return this.posX;
    }

    public Integer  getPosY() {
        return this.posY;
    }

    public boolean  getStatus() {
        return status;
    }

    public void     setPosition(Integer mapSize) {
        setPosX(mapSize/2);
        setPosY(mapSize/2);
        setPreviousPos();
    }

    private void     setPosX(Integer posX) {
        this.posX = posX;
    }

    private void     setPosY(Integer posY) {
        this.posY = posY;
    }

    private void    setPreviousPos() {
        this.previousPos[0] = this.posX;
        this.previousPos[1] = this.posY;
    }
}
