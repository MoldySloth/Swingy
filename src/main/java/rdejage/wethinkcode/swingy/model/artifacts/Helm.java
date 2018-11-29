package rdejage.wethinkcode.swingy.model.artifacts;

public class Helm extends Artifact {
    private static String   artifactName;
    public Helm(String name, String type, Integer value) {
        artifactName = name;
        buffType = type;
        buffValue = value;
    }
}
