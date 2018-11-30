package rdejage.wethinkcode.swingy.model.artifacts;

import java.util.*;

public class ArtifactFactory {
    public static   Artifact    buildArtifact() {
        // random item based on armor or helm
        Random      rand = new Random();
        Integer     n = rand.nextInt(3);

        switch(n) {
            case 1:
                return new Armor();
            case 2:
                return new Helm();
            case 3:
                return new Weapon();
            default:
                break;
        }
        return null;
    }
}
