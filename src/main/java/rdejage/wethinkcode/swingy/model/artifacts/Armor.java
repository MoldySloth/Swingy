package rdejage.wethinkcode.swingy.model.artifacts;

import java.util.Random;

public class Armor extends Artifact {
    private static String   artifactName;

    public Armor() {
        artifactName = getRandomName();
        buffType = "Armor";
        buffValue = getRandomValue();
    }

    public static String    getRandomName() {
        // returns a random name to use as
        String[]    helmTypes = {"Pot of Luck", "Elixir of Redbull", "Heal of Water", "Elixir of Coffee"};
        Random rand = new Random();
        Integer     n = rand.nextInt(4);
        return helmTypes[n];
    }

    public static Integer   getRandomValue() {
        // returns a random int value
        Random      rand = new Random();
        Integer     n = rand.nextInt(9);
        return (n * 10);
    }

    @Override
    public String           getArtifactName() {
        return artifactName;
    }
}
