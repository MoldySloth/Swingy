package rdejage.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotNull;

public class Bruser extends Character {
    public Bruser(String name) {
        // save as a character
        super(name, "Bruser", 100, 250, 100);
        System.out.println("Bruser named " + name + " with " + attack_base + " attack, " + armor_base + " armor and " + hitPoints_base + " hit points.\n");
    }

    public Bruser(String name, Integer level, Integer experience, String weapon, String artifact) {
        super(name, "Bruser", level, experience, weapon, artifact);
    }

    @Override
    public Integer  getBaseAttack() {
        return 100;
    }

    @Override
    public Integer  getBaseArmor() {
        return 250;
    }

    @Override
    public Integer  getBaseHitPoints() {
        return 100;
    }
}
