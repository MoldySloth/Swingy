package rdejage.wethinkcode.swingy.model.characters;

public class CharacterFactory {
    public static Character newCharacter(String name, Integer classType) {
        switch (classType) {
            case 1:
                return new Paladin(name);
            case 2:
                return new Bruser(name);
            case 3:
                return new Necromancer(name);
            case 4:
                return new Slayer(name);
            default:
                break;
        }
        return null;
    }

    public static Character loadCharacter(String name, String classType, Integer level, Integer experience, String weapon, String artifact, String artifactType) {
        switch (classType) {
            case "Paladin":
                return new Paladin(name, level, experience, weapon, artifact, artifactType);
            case "Bruser":
                return new Bruser(name, level, experience, weapon, artifact, artifactType);
            case "Necromancer":
                return new Necromancer(name, level, experience, weapon, artifact, artifactType);
            case "Slayer":
                return new Slayer(name, level, experience, weapon, artifact, artifactType);
            default:
                break;
        }
        return null;
    }
}
