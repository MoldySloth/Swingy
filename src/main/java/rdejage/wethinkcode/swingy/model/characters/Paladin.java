package rdejage.wethinkcode.swingy.model.characters;

import lombok.Getter;

@Getter
public class Paladin extends Character {
    public Paladin(String name) {
        // save as a character
        super(name, "Paladin", 100, 150, 150);
        System.out.println("Paladin named " + name + " with " + attack_base + " attack, " + armor_base + " armor and " + hitPoints_base + " hit points.\n");
    }

    public Paladin(String name, Integer level, Integer experience, String weapon, String artifact) {
        super(name, "Paladin", level, experience, weapon, artifact);
    }
}

//    John the Teenager,Knight,2,540,short sword,leather armor
