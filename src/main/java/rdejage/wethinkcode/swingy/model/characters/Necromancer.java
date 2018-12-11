package rdejage.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotNull;

public class Necromancer extends Character {
    public Necromancer(String name) {
        // save as a character
        super(name, "Necromancer", 50, 150, 150);
    }

    public Necromancer(String name, Integer level, Integer experience, String weapon, String artifact, String artifactType) {
        super(name, "Necromancer", level, experience, weapon, artifact, artifactType);
    }
}
