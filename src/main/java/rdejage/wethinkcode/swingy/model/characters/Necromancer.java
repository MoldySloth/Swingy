package rdejage.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotNull;

public class Necromancer extends Character {
    public Necromancer(String name) {
        // save as a character
        super(name, "Necromancer", 50, 150, 150);
        System.out.println("Necromancer named " + name + " with " + attack_base + " attack, " + armor_base + " armor and " + hitPoints_base + " hit points.\n");
    }

//    public Necromancer(String name, String type, Integer level, Integer experience, String weapon, String artifact) {
//        super(name, type, level, experience, weapon, artifact);
//    }

    @Override
    public Integer  getBaseAttack() {
        return 50;
    }

    @Override
    public Integer  getBaseArmor() {
        return 150;
    }

    @Override
    public Integer  getBaseHitPoints() {
        return 150;
    }
}
