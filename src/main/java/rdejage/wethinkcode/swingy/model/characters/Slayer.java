package rdejage.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotNull;

public class Slayer extends Character {
    public Slayer(String name) {
        // save as a character
        super(name, "Slayer", 150, 100, 50);
        System.out.println("Slayer named " + name + " with " + attack_base + " attack, " + armor_base + " armor and " + hitPoints_base + " hit points.\n");
    }

//    public Slayer(String name, String type, Integer level, Integer experience, String weapon, String artifact) {
//        super(name, type, level, experience, weapon, artifact);
//    }

    @Override
    public Integer  getBaseAttack() {
        return 150;
    }

    @Override
    public Integer  getBaseArmor() {
        return 100;
    }

    @Override
    public Integer  getBaseHitPoints() {
        return 50;
    }
}
