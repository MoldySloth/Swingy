package rdejage.wethinkcode.swingy.model.artifacts;

public class Armor extends Artifact {
    private static String   artifactName;
    public Armor(String name, String type, Integer value) {
        artifactName = name;
        buffType = type;
        buffValue = value;
    }
}
