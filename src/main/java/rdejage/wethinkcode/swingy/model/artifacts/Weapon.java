package rdejage.wethinkcode.swingy.model.artifacts;

import java.util.Random;

public class Weapon extends Artifact {
    private static String   artifactName;

    public Weapon() {
        artifactName = getRandomName();
        buffType = "Weapon";
        buffValue = getRandomValue();
    }

    public static String    getRandomName() {
        // returns a random name to use as
        String[]    helmTypes = {"Wooden Sword", "Bloody Axe", "Chop! Chop! Cleaver", "Heroes Iron Long Sword"};
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
