package rdejage.wethinkcode.swingy.model.characters;

public class Slayer extends Character {
    public Slayer(String name) {
        // save as a character
        super(name, "Slayer", 150, 100, 50);
    }

    public Slayer(String name, Integer level, Integer experience, String weapon, String artifact, String artifactType) {
        super(name, "Slayer", level, experience, weapon, artifact, artifactType);
    }
}
