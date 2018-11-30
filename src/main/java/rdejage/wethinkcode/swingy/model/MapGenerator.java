package rdejage.wethinkcode.swingy.model;

import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.model.characters.Villain;
import rdejage.wethinkcode.swingy.model.characters.VillainFactory;

import java.util.*;

public class MapGenerator {
    private Character       hero;
    private Integer         mapSize;
    private static final List<Villain>    villains = new ArrayList<Villain>();

    public MapGenerator(Character hero) {
        // get the map size based on level
        this.hero = hero;
        Integer     level = hero.getLevel();
        this.mapSize = getMapSize(level);
        generateVillains();
    }

    public void     generateVillains() {
        // traverse through the map
        for(int y = 1; y <= mapSize; y++) {
            for(int x = 1; x <= mapSize; x++) {
                // list of villains or a percentage of spawning
                Random      rand = new Random();
                float       chance = rand.nextFloat();

                if(chance <= 0.30f) {
                    // add villain to list
                    try {
                        Villain villain = VillainFactory.newVillain(x, y);
                        if (villain != null) {
                            villains.add(villain);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Map Error: Could not create villain");
                    }
                }
            }
        }
    }

    public Villain  isVillain() {
        // Compare hero coordinates to villains coordinates
        for(Villain villain: villains) {
            if(villain.getPosX().equals(hero.getPosX()) && villain.getPosY().equals(hero.getPosY())) {
                return villain;
            }
        }
        return null;
    }

    public void     fightVillain() {
        Villain     villain = isVillain();
        // hero attacks villain...
        hero.fight(villain);
    }

    public Integer  getMapSize(Integer level) {
        return ((level - 1)*5+10-(level % 2));
    }

    public Integer  getSize() {
        return this.mapSize;
    }

    public boolean  positionIsValid(Integer x, Integer y) {
        // check that the x and y position is valid
        if((x > 0 && x <= mapSize) && (y > 0 && y <= mapSize)) {
            System.out.println("Hero position is valid");
            return true;
        }
        System.out.println("Hero position is outside of map");
        return false;
    }
}
