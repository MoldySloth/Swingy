package rdejage.wethinkcode.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.artifacts.Weapon;

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

    public void     fight(Villain villain) {
        // Simulate a fight with the villain
        System.out.println("The hero is fighting " + villain.getVillainType());
        while(this.status) {
            villain.takeDamage(this.getAttack());
            if(villain.getStatus()) {
                takeDamage(villain.attack);
            }
        }

    }

    private void     takeDamage(Integer damage) {
        // use armor as a buff for damage
        Integer     trueDamage = damage - getAromr();
        if(trueDamage >= getHitPoints()) {
            // This villain dies
            this.hitPoints_base = 0;
        } else {
            // villain takes damage update armor and hitPoints
            this.hitPoints_base = getHitPoints() - damage;
        }
    }

    public boolean  run() {
        Random      rand = new Random();
        int         n = rand.nextInt(2);
        if(n == 1) {
            return true;
        }
        return false;
    }

    public void     addItem(Artifact item) {
        // check if Item can be added, drop item if needed
        System.out.println(item.getArtifactName() + " has been added to your inventory");
    }

    public String   getInfo() {
        // Some hard coded info
        String weapon = "Plastic sword";
        String artifact = "Cardboard box";
        String  info = "";
        info += this.name + " the " + this.type + "," + this.level + "," + this.exp + "," + weapon + "," + artifact;
        return info;
    }

    private Integer  getAttack() {
        // return attack value based on weapon and base attack
        if(weapon != null) {
            return this.attack_base + 10;
        }
        return this.attack_base;
    }

    private Integer  getAromr() {
        // return attack value based on weapon and base attack
        if(artifact != null) {
            if(artifact.getBuffType().equals("Armor")) {
                return this.armor_base + 10;
            }
        }
        return this.armor_base;
    }

    private Integer  getHitPoints() {
        // return attack value based on weapon and base attack
        if(artifact != null) {
            if(artifact.getBuffType().equals("Helm")) {
                return this.hitPoints_base + 10;
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
    }

    private void     setPosX(Integer posX) {
        this.posX = posX;
    }

    private void     setPosY(Integer posY) {
        this.posY = posY;
    }


}
