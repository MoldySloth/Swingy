package rdejage.wethinkcode.swingy.model;

import rdejage.wethinkcode.swingy.model.characters.Character;

public class MapGenerator {
    private Integer     mapSize;
    private Character[] villians;

    public MapGenerator(Character hero) {
        // get the map size based on level
        Integer     level = hero.getLevel();
        this.mapSize = getMapSize(level);

    }

    public void     generateVillains() {

    }

    public Integer  getMapSize(Integer level) {
        return ((level - 1)*5+10-(level % 2));
    }

    public Integer  getSize() {
        return this.mapSize;
    }

    public boolean  positionIsValid(Integer x, Integer y) {
        // check that the x and y position is valid
        if((x > 0 && x < mapSize) && (y > 0 && y < mapSize)) {
            System.out.println("Hero position is valid");
            return true;
        }
        System.out.println("Hero position is outside of map");
        return false;
    }
}
