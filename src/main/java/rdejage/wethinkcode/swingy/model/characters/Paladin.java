package rdejage.wethinkcode.swingy.model.characters;

import lombok.Getter;

@Getter
public class Paladin extends Character {
    public Paladin(String name) {
        // save as a character
        super(name, "Paladin", 100, 150, 150);
    }

    public Paladin(String name, Integer level, Integer experience, String weapon, String artifact, String artifactType) {
        super(name, "Paladin", level, experience, weapon, artifact, artifactType);
    }
}

//    John the Teenager,Knight,2,540,short sword,leather armor
