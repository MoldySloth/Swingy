package rdejage.wethinkcode.swingy.model.characters;

import java.util.Random;

public class VillainFactory {
    public static Villain newVillain(Integer x, Integer y) {
        Random      rand = new Random();
        int         n = rand.nextInt(3);
        switch (n) {
            case 1:
                return new EvilWoodland(x, y);
            case 2:
                return new RooflessHominid(x, y);
            case 3:
                return new AlienInfestation(x, y);
            default:
                break;
        }
        return null;
    }
}
