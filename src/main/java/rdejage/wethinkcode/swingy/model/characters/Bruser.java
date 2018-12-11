package rdejage.wethinkcode.swingy.model.characters;

public class Bruser extends Character {
    public Bruser(String name) {
        // save as a character
        super(name, "Bruser", 100, 250, 100);
    }

    public Bruser(String name, Integer level, Integer experience, String weapon, String artifact, String artifactType) {
        super(name, "Bruser", level, experience, weapon, artifact, artifactType);
    }
}
